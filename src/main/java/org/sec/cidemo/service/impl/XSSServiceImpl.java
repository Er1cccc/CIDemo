package org.sec.cidemo.service.impl;

import org.sec.cidemo.dao.XSSDao;
import org.sec.cidemo.model.Message;
import org.sec.cidemo.service.XSSService;
import org.sec.cidemo.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class XSSServiceImpl implements XSSService {
    private final XSSDao xssDao;

    public XSSServiceImpl(XSSDao xssDao) {
        this.xssDao = xssDao;
    }

    @Override
    public String insert(String data) {
        return xssDao.insert(data);
    }

    @Override
    public Message get(int id) {
        return xssDao.get(id);
    }

    @Override
    public String reflection(String message) {
        if (!message.equals("test")) {
            return message;
        }
        return "error";
    }

    @Override
    public String protect(String message) {
        return StringUtil.clean(message);
    }
}
