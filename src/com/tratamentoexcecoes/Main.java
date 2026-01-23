package com.tratamentoexcecoes;

import com.tratamentoexcecoes.dao.UserDAO;
import com.tratamentoexcecoes.enums.MenuOption;
import com.tratamentoexcecoes.model.UserMODEL; // Mantenha o nome que definiu, mas o ideal é UserModel
import com.tratamentoexcecoes.exception.UserNotFoundException;
import com.tratamentoexcecoes.exception.EmptyStorageException;
import com.validator.UserValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static UserDAO dao = new UserDAO();
    private final static Scanner scn = new Scanner(System.in);
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        while (true) {
            showMenu();
            // Lê a opção dentro do loop para permitir nova escolha
            int selectedOption = scn.nextInt();
            scn.nextLine(); // Limpa o buffer após ler inteiro

            try {
                // Previne erro se o usuário digitar um número fora do Enum
                if (selectedOption < 1 || selectedOption > MenuOption.values().length) {
                    System.out.println("Opção inválida!");
                    continue;
                }

                MenuOption optionMenu = MenuOption.values()[selectedOption - 1];

                switch (optionMenu) {
                    case SAVE -> {
                        UserMODEL user = dao.save(requestToSave());
                        System.out.printf("Usuário cadastrado com sucesso! \n%s\n", user);
                    }
                    case UPDATE -> {
                        try {
                            UserMODEL update = dao.update(requestToUpdate());
                            System.out.printf("Usuário atualizado com sucesso! \n%s\n", update);
                        } catch (UserNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case DELETE -> {
                        try {
                            dao.delete(requestId());
                            System.out.println("Usuário deletado!");
                        } catch (UserNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case FIND_BY_ID -> {
                        try {
                            long id = requestId();
                            UserMODEL user = dao.findById(id);
                            System.out.println("Usuário encontrado: " + user);
                        } catch (UserNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case FIND_ALL -> {
                        try {
                            List<UserMODEL> users = dao.findAll();
                            System.out.println("Usuários cadastrados:");
                            users.forEach(System.out::println);
                        } catch (UserNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case EXIT -> {
                        System.out.println("Saindo... Até logo!");
                        System.exit(0);
                    }
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Cadastro de Usuário ---");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Busca pelo ID");
        System.out.println("5 - Listar");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static long requestId() {
        System.out.println("Informe o identificador do usuário:");
        long id = scn.nextLong();
        scn.nextLine(); // Limpa buffer
        return id;
    }

    private static UserMODEL requestToSave() {
        System.out.println("Informe o nome do usuário:");
        String name = scn.nextLine();
        System.out.println("Informe o email do usuário:");
        String email = scn.nextLine();
        System.out.println("Informe a data de nascimento (dd/MM/yyyy):");
        String birthDayStr = scn.nextLine();

        LocalDate birthDate = LocalDate.parse(birthDayStr, formatter);

        // Criamos um modelo temporário com ID 0 pois o DAO gerará o ID real
        UserMODEL user = new UserMODEL(0L, name, email, birthDate);
        UserValidator.VerifyModel(user);
        return user;
    }

    private static UserMODEL requestToUpdate() {
        long id = requestId();
        System.out.println("Informe o novo nome:");
        String name = scn.nextLine();
        System.out.println("Informe o novo email:");
        String email = scn.nextLine();
        System.out.println("Informe a nova data de nascimento (dd/MM/yyyy):");
        String birthDayStr = scn.nextLine();

        LocalDate birthDate = LocalDate.parse(birthDayStr, formatter);

        UserMODEL user = new UserMODEL(id, name, email, birthDate);
        UserValidator.VerifyModel(user);
        return user;
    }
}
