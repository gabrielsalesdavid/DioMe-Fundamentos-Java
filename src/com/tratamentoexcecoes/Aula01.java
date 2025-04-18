package com.tratamentoexcecoes;

import com.tratamentoexcecoes.dao.UserDAO;
import com.tratamentoexcecoes.enums.MenuOption;
import com.tratamentoexcecoes.model.UserMODEL;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Aula01 {

    private final static UserDAO dao = new UserDAO();

    private final static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bem-Vindo ao cadastro de usuario, selecione a operação desejada!");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Busca pelo ID");
        System.out.println("5 - Listar");
        System.out.println("6 - Sair");

        int selectedOption = scn.nextInt();
        while (true) {

            System.out.println("Bem-Vindo ao cadastro de usuario, selecione a operação desejada!");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Busca pelo ID");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");

            MenuOption optionMenu = MenuOption.values()[selectedOption -1];
            switch(optionMenu) {
                case SAVE -> {
                    UserMODEL user = dao.save(requestToSave());
                    System.out.printf("Usuario cadastrado \n%s!", user);
                }
                case UPDATE -> {
                    UserMODEL update = dao.update(requestToUpdate());
                    System.out.printf("Usuario atualizado \n%s!", update);
                }
                case DELETE -> {
                    dao.delete(requestId());
                    System.out.println("Usuario deletado!");
                }
                case FIND_BY_ID -> {
                    long id = requestId();
                    UserMODEL users = dao.findById(id);
                    System.out.printf("Usuario com id: \n%s", id);
                    System.out.println(users);
                }
                case FIND_ALL -> {
                    List<UserMODEL> users = dao.findAll();
                    System.out.println("Usuarios cadastrados:");
                    users.forEach(System.out::println);
                }
                case EXIT -> System.exit(0);
            }
        }
    }

    private static long requestId() {

        System.out.println("Informe o identificador do usuario:");
        return scn.nextLong();
    }

    private static UserMODEL requestToSave() {

        System.out.println("Informe o nome do usuario:");
        String name = scn.nextLine();
        scn.nextLine();
        System.out.println("Informe o email do usuario:");
        String email = scn.next();
        scn.nextLine();
        System.out.println("Informe a data de nascimento do usuario (dd/MM/yyyy):");
        String birthDay = scn.next();
        DateTimeFormatter datatimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birth = OffsetDateTime.parse(birthDay, datatimeFormat);
        return new UserMODEL(0, email, email, birth);
    }

    private static UserMODEL requestToUpdate() {

        System.out.println("Informe o identificador do usuario:");
        long id = scn.nextLong();
        scn.nextLine();
        System.out.println("Informe o nome do usuario:");
        String name = scn.nextLine();
        System.out.println("Informe o email do usuario:");
        String email = scn.next();
        scn.nextLine();
        System.out.println("Informe a data de nascimento do usuario (dd/MM/yyyy):");
        String birthDay = scn.next();
        DateTimeFormatter datatimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birth = OffsetDateTime.parse(birthDay, datatimeFormat);
        return new UserMODEL(id, email, email, birth);
    }
}