package org.sec.cidemo.web;

import org.sec.cidemo.model.User;
import org.sec.cidemo.service.SQLIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sqli")
public class SQLIController {

    private final SQLIService sqliService;

    public SQLIController(SQLIService sqliService) {
        this.sqliService = sqliService;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addUser(String name,
                          int age){
        return sqliService.addUser(name,age);
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<User> select(@RequestParam("name") String name){
        return sqliService.selectUser(name);
    }
}
