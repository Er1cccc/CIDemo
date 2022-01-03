package org.sec.cidemo.dao;

import org.sec.cidemo.model.Message;

public interface XSSDao {
    Message get(int id);
    String insert(String data);
}
