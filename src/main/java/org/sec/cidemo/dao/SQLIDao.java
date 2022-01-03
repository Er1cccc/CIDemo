package org.sec.cidemo.dao;

import org.sec.cidemo.model.User;

import java.util.List;

public interface SQLIDao {
    String addUser(String name,int age);
    List<User> selectUser(String name);
}
