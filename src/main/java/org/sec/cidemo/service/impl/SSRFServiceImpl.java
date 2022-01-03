package org.sec.cidemo.service.impl;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.sec.cidemo.model.Url;
import org.sec.cidemo.service.SSRFService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

@Service
public class SSRFServiceImpl implements SSRFService {
    @Override
    public String ssrf1_fake1(String data) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL("http://www.baidu.com");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return String.valueOf(response.length());
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String ssrf1_fake2(String data) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(data);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            return String.valueOf(response.length());
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


    @Override
    public String ssrf1(String data) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(data);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return String.valueOf(response.length());
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String ssrf1_url(Url u) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(u.getUrl());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return String.valueOf(response.length());
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String ssrf2_fake1(String data) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://www.baidu.com");
            HttpResponse response = httpClient.execute(getRequest);
            HttpEntity entity = response.getEntity();
            return String.valueOf(entity.getContentLength());
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String ssrf2_fake2(String data) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet(data);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String ssrf2(String data) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet(data);
            HttpResponse response = httpClient.execute(getRequest);
            HttpEntity entity = response.getEntity();
            return String.valueOf(entity.getContentLength());
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String ssrf3_fake1(String host, int port) {
        try {
            Socket socket = new Socket("14.215.177.38", 80);
            InputStream in = socket.getInputStream();
            return in.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String ssrf3_fake2(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


    @Override
    public String ssrf3(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            InputStream in = socket.getInputStream();
            return in.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String ssrf4_fake1(String url) {
        try {
            OkHttpClient httpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://www.baidu.com")
                    .build();
            Response response = httpClient.newCall(request).execute();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String ssrf4_fake2(String url) {
        try {
            OkHttpClient httpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            httpClient.newCall(request).execute();
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String ssrf4(String url) {
        try {
            OkHttpClient httpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = httpClient.newCall(request).execute();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static void main(String[] args) {
//        Url url = new Url();
//        url.setUrl("http://121.5.40.245:5566");
//        new SSRFServiceImpl().ssrf1_url(url);
        new SSRFServiceImpl().ssrf4_fake2("http://121.5.40.245:5566");
    }


}
