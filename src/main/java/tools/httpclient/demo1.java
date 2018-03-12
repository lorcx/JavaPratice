package tools.httpclient;

import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Author lx
 * @Date 2018/3/11 10:56
 */
public class demo1 {
    static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) throws IOException {
        //t1();
        //t2();
        //t3();
        t4();
    }

    private static void t4() {
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "ok");
        response.addHeader("Set-Cookie", "c1=a; path=/; domain=localhost");
        response.addHeader("Set-Cookie", "c2=b; path=\"/\"; c3=3; domain=\"localhost\"");
        Header h1 = response.getFirstHeader("Set-Cookie");
        System.out.println(h1);
        Header h2 = response.getLastHeader("Set-Cookie");
        System.out.println(h2);

        HeaderIterator it = response.headerIterator("Set-Cookie");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        HeaderElementIterator it1 = new BasicHeaderElementIterator(response.headerIterator());
        while (it1.hasNext()) {
            HeaderElement ele = it1.nextElement();
            System.out.println(ele.getName() + "=" + ele.getValue());

            NameValuePair[] params = ele.getParameters();
            for (int i = 0; i < params.length; i++) {
                System.out.println(params[i]);
            }
        }


    }

    private static void t3() {
        HttpGet httpGet = new HttpGet("http://localhost:8080");
        HttpResponse response = null;
        try {
            response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "ok");
            System.out.println(response.getProtocolVersion());
            System.out.println(response.getStatusLine());
        }  catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void t1() {
        HttpGet httpGet = new HttpGet("http://localhost:8080");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            System.out.println("请求成功");
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
            }
        }
    }

    static void t2() {
        try {
            URI uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("www.google.com")
                    .setPath("/search")
                    .setParameter("q", "httpclient")
                    .setParameter("btnG", "Google Search")
                    .setParameter("aq", "f")
                    .setParameter("oq", "")
                    .build();
            HttpGet httpGet1 = new HttpGet(uri);
            System.out.println(httpGet1.getURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
