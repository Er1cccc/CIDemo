package org.sec.cidemo.service.impl;

import org.sec.cidemo.dao.SQLIDao;
import org.sec.cidemo.model.User;
import org.sec.cidemo.service.SQLIService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SQLIServiceImpl implements SQLIService {

    private final SQLIDao sqliDao;

    public SQLIServiceImpl(SQLIDao sqliDao) {
        this.sqliDao = sqliDao;
    }

    @Override
    public String addUser(String name, int age) {
        return sqliDao.addUser(name, age);
    }

    @Override
    public List<User> selectUser(String name) {
        return sqliDao.selectUser(name);
    }
}
