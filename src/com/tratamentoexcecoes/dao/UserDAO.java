package com.tratamentoexcecoes.dao;

import com.tratamentoexcecoes.exception.UserNotFoundException;
import com.tratamentoexcecoes.model.UserModel; // Ajustado de UserMODEL para UserModel

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAO {

    private long nextId = 1L; // Uso do L maiúsculo
    private final List<UserModel> users = new ArrayList<>(); // Nome no plural e final

    public final UserModel save(final UserModel user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    public UserModel update(final UserModel updateUser) {
        // findById já lança exceção se não encontrar
        UserModel existingUser = findById(updateUser.getId());

        int index = users.indexOf(existingUser);
        users.set(index, updateUser); // Substitui na mesma posição original

        return updateUser;
    }

    public UserModel delete(final long id) {
        UserModel toDelete = findById(id);
        users.remove(toDelete);
        return toDelete;
    }

    public UserModel findById(final long id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(
                String.format("Não existe usuário com o id %d cadastrado", id)));
    }

    public List<UserModel> findAll() {
        verifyEmptyStorage();
        // Retorna uma cópia para proteger a lista original (Encapsulamento)
        return new ArrayList<>(users);
    }

    private void verifyEmptyStorage() {
        if (users.isEmpty()) {
            throw new UserNotFoundException("Nenhum usuário cadastrado!");
        }
    }
}
