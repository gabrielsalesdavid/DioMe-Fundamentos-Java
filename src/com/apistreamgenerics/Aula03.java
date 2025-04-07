package com.apistreamgenerics;

import com.apistreamgenerics.Domain.UserDomain;
import com.apistreamgenerics.Dao.GenericDAO;
import com.apistreamgenerics.Dao.UserDAO;

public class Aula03 {

    private static GenericDAO<UserDomain> dao = new UserDAO();

    public static void main(String[] args) {

        UserDomain user = new UserDomain("João", 36);

        System.out.println(dao.count());
        System.out.println(dao.save(new UserDomain("João", 36)));
        System.out.println(dao.findAll());
        System.out.println(dao.count());
        dao.delete(new UserDomain("", -1));
        dao.delete(user);
        System.out.println(dao.findAll());
        System.out.println(dao.count());
    }
}