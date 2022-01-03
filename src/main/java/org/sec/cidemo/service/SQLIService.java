package org.sec.cidemo.service;

import org.sec.cidemo.model.User;

import java.util.List;

public interface SQLIService {
    String addUser(String name,int age);
    List<User> selectUser(String name);
}
