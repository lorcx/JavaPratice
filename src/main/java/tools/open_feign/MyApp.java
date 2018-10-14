package tools.open_feign;

import feign.Feign;
import feign.gson.GsonDecoder;

import java.util.List;

/**
 * @Author lx
 * @Date 2018/10/14 16:36
 */
public class MyApp {
    public static void main(String[] args) {
        GitHub gitHub = Feign.builder()
                .decoder(new GsonDecoder())
                .target(GitHub.class, "https://api.github.com");

        List<Contributor> contributors = gitHub.contributors("OpenFeign", "feign");
        for (Contributor contributor : contributors) {
            System.out.println(contributor.login + " （" + contributor + ")");
        }
    }
}
