package com.validator;

import com.tratamentoexcecoes.exception.ValidatorException;
import com.tratamentoexcecoes.model.UserModel; // Ajustado para padrão CamelCase

public class UserValidator {

    // Construtor privado está correto para classes Utilitárias
    private UserValidator() {
    }

    public static void verifyModel(final UserModel user) {

        // Verifica se o objeto user em si não é nulo antes de acessar os métodos
        if (user == null) {
            throw new ValidatorException("O modelo do usuário não pode ser nulo");
        }

        if (isBlank(user.getName())) {
            throw new ValidatorException("Informe um nome válido");
        }

        // Ajuste na lógica: se o length for menor que 2, o nome é curto demais
        if (user.getName().trim().length() < 2) {
            throw new ValidatorException("O nome deve conter no mínimo 2 caracteres");
        }

        if (isBlank(user.getMail())) {
            throw new ValidatorException("Informe um e-mail válido");
        }

        // Validação de e-mail mais flexível
        if (!user.getMail().contains("@") || !user.getMail().contains(".")) {
            throw new ValidatorException("O formato do e-mail é inválido");
        }
    }

    // Nome do método em minúsculo seguindo a convenção Java
    private static boolean isBlank(final String str) {
        return str == null || str.trim().isEmpty();
    }
}
