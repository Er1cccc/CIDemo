package org.sec.cidemo.service;

import org.sec.cidemo.model.Url;

public interface SSRFService {
    String ssrf1_fake1(String data);
    String ssrf1_fake2(String data);
    String ssrf1(String data);
    String ssrf1_url(Url url);

    String ssrf2_fake1(String data);
    String ssrf2_fake2(String data);
    String ssrf2(String data);

    String ssrf3_fake1(String host, int port);
    String ssrf3_fake2(String host, int port);
    String ssrf3(String host, int port);

    String ssrf4_fake1(String url);
    String ssrf4_fake2(String url);
    String ssrf4(String url);

}
