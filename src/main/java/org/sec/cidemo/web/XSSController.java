package org.sec.cidemo.web;

import org.sec.cidemo.model.Message;
import org.sec.cidemo.service.XSSService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/xss")
public class XSSController {
    private final XSSService xssService;

    public XSSController(XSSService xssService) {
        this.xssService = xssService;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insertMessage(@RequestParam("data") String message) {
        return xssService.insert(message);
    }

    @RequestMapping("/get")
    @ResponseBody
    public String getMessage(@RequestParam("id") int id) {
        Message message = xssService.get(id);
        return message.getData();
    }

    @RequestMapping("/reflection")
    @ResponseBody
    public String reflection(@RequestParam("data") String message) {
        return xssService.reflection(message);
    }

    @RequestMapping("/protect")
    @ResponseBody
    public String protect(@RequestParam("data") String message) {
        return xssService.protect(message);
    }
}
