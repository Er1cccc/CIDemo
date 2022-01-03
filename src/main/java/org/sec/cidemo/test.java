package org.sec.cidemo;

import org.sec.cidemo.service.SSRFService;
import org.sec.cidemo.service.impl.SSRFServiceImpl;

public class test {
    public static void main(String[] args) {
        SSRFService ssrfService = new SSRFServiceImpl();
        ssrfService.ssrf2("http://121.5.40.245:5566");
    }
}
