package com.validator;

import com.tratamentoexcecoes.exception.ValidatorException;
import com.tratamentoexcecoes.model.UserMODEL;

public class UserValidator {

    private UserValidator() {
    }

    public static void VerifyModel(final UserMODEL users) {

        if (StringIsBlank(users.getName())) {
            throw new ValidatorException("Informe o nome válido");
        }

        if (users.getName().length() <= 1) {
            throw new ValidatorException("O nome deve conter no minimo 1 caracteres");
        }

        if (StringIsBlank(users.getMail())) {
            throw new ValidatorException("Informe o E-Mail válido");
        }

        if ((!users.getMail().contains("@")) || (!users.getMail().contains(".com"))) {
            throw new ValidatorException("Informe um email válido");
        }
    }

    private static boolean StringIsBlank(final String str) {
        return str == null || str.isBlank();
    }
}
