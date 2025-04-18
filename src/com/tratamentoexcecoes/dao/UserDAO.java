package com.tratamentoexcecoes.dao;

import com.tratamentoexcecoes.exception.UserNotFoundException;
import com.tratamentoexcecoes.model.UserMODEL;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private long nextId = 1l;
    private List<UserMODEL> userModel = new ArrayList<>();

    public final UserMODEL save(final UserMODEL modelUser) {

        modelUser.setId(nextId++);
        userModel.add(modelUser);
        return modelUser;
    }

    public UserMODEL update(final UserMODEL updateUserModel) {

        UserMODEL toUpdate = findById(updateUserModel.getId());
        userModel.remove(toUpdate);
        userModel.add(updateUserModel);
        return updateUserModel;
    }

    public UserMODEL delete(final long id) {

        UserMODEL toDelete = findById(id);
        userModel.remove(toDelete);
        return toDelete;
    }

    public UserMODEL findById(final long id) {

        String message = String.format("Não existe usuario com o id %s cadastrado", id);
        return userModel.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));
    }

    public List<UserMODEL> findAll() {

        return userModel;
    }
}