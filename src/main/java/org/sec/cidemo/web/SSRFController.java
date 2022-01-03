package org.sec.cidemo.web;

import org.sec.cidemo.model.Url;
import org.sec.cidemo.service.SSRFService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ssrf")
public class SSRFController {
    private final SSRFService ssrfService;

    public SSRFController(SSRFService ssrfService) {
        this.ssrfService = ssrfService;
    }

    @RequestMapping(path = "/ssrf1_fake1")
    @ResponseBody
    public String ssrf1_fake1(@RequestParam(name = "url") String data) {
        return ssrfService.ssrf1_fake1(data);
    }

    @RequestMapping(path = "/ssrf1_fake2")
    @ResponseBody
    public String ssrf1_fake2(@RequestParam(name = "url") String data) {
        return ssrfService.ssrf1_fake2(data);
    }

    @RequestMapping(path = "/ssrf1")
    @ResponseBody
    public String ssrf1(@RequestParam(name = "url") String data) {
        return ssrfService.ssrf1(data);
    }

    @RequestMapping(path = "/ssrf1")
    @ResponseBody
    public String ssrf1_url(@RequestParam(name = "url") Url url) {
        return ssrfService.ssrf1_url(url);
    }

    @RequestMapping(path = "/ssrf2_fake1")
    @ResponseBody
    public String ssrf2_fake1(@RequestParam(name = "url") String data) {
        return ssrfService.ssrf2_fake1(data);
    }

    @RequestMapping(path = "/ssrf2_fake2")
    @ResponseBody
    public String ssrf2_fake2(@RequestParam(name = "url") String data) {
        return ssrfService.ssrf2_fake2(data);
    }

    @RequestMapping(path = "/ssrf2")
    @ResponseBody
    public String ssrf2(@RequestParam(name = "url") String data) {
        return ssrfService.ssrf2(data);
    }


    @RequestMapping(path = "/ssrf3_fake1")
    @ResponseBody
    public String ssrf3_fake1(@RequestParam(name = "ip") String ip,int port) {
        return ssrfService.ssrf3_fake1(ip,port);
    }

    @RequestMapping(path = "/ssrf3_fake2")
    @ResponseBody
    public String ssrf3_fake2(@RequestParam(name = "ip") String ip,int port) {
        return ssrfService.ssrf3_fake2(ip,port);
    }

    @RequestMapping(path = "/ssrf3")
    @ResponseBody
    public String ssrf3(@RequestParam(name = "ip") String ip,int port) {
        return ssrfService.ssrf3(ip,port);
    }


    @RequestMapping(path = "/ssrf4_fake1")
    @ResponseBody
    public String ssrf4_fake1(@RequestParam(name = "url") String data) {
        return ssrfService.ssrf4_fake1(data);
    }

    @RequestMapping(path = "/ssrf4_fake2")
    @ResponseBody
    public String ssrf4_fake2(@RequestParam(name = "url") String data) {
        return ssrfService.ssrf4_fake2(data);
    }

    @RequestMapping(path = "/ssrf4")
    @ResponseBody
    public String ssrf4(@RequestParam(name = "url") String data) {
        return ssrfService.ssrf4(data);
    }
}
