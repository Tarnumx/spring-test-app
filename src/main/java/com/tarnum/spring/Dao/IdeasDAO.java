package com.tarnum.spring.Dao;

import com.tarnum.spring.Model.Idea;
import com.tarnum.spring.Model.User;

import java.util.List;

public interface IdeasDAO {

    int add(Idea idea);

    int update(Idea idea);

    int delete(int id);

    Idea get(int id);

    List<Idea> list();

    boolean registerUser(User user);

    boolean isUserExists(String login);
}
