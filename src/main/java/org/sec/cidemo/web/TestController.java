package org.sec.cidemo.web;

import org.sec.cidemo.model.Message;
import org.sec.cidemo.service.XSSService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request) {
        return request.getParameter("a");
    }

}
