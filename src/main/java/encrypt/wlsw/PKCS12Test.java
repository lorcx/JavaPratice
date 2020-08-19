package encrypt.wlsw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @Author: lx
 * @Date: Created in 2020/8/19
 */
public class PKCS12Test {
    public static void main(String[] args) throws Exception {
        String filePath = "E:\\cert\\unionpay\\dev\\acp_test_sign_inst.pfx";
        String pwd = "000000";

        try (FileInputStream fis = new FileInputStream(filePath)) {
            KeyStore store = KeyStore.getInstance("pkcs12");
            store.load(fis, pwd.toCharArray());

            Enumeration<String> aliases = store.aliases();
            System.out.println(aliases.toString());

            if (aliases.hasMoreElements()) {
                String alias = aliases.nextElement();
                PrivateKey privateKey = (PrivateKey) store.getKey(alias, pwd.toCharArray());
                System.out.println(privateKey);

                System.out.println(privateKey.getFormat());
                System.out.println(Arrays.toString(privateKey.getEncoded()));


                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            }
        }

    }
}
