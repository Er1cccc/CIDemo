package org.sec.cidemo.service;

import org.sec.cidemo.model.Message;

public interface XSSService {
    String insert(String data);
    Message get(int id);
    String reflection(String message);
    String protect(String message);
}
