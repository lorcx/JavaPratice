package encrypt.wlsw;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * @Author: lx
 * @Date: Created in 2020/8/19
 */
public class CerTest {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void main(String[] args) throws CertificateException, NoSuchProviderException, FileNotFoundException {
        Load load = new Load().invoke("e:\\cert\\unionpay\\dev\\acp_test_enc.cer");
        X509Certificate certificate = load.getCertificate();
        PublicKey publicKey = load.getPublicKey();
        System.out.println(publicKey);
        System.out.println(certificate.getSerialNumber());


        load = new Load().invoke("e:\\cert\\unionpay\\dev\\acp_test_verify_sign.cer");
        certificate = load.getCertificate();
        publicKey = load.getPublicKey();
        System.out.println(publicKey);
        System.out.println(certificate.getSerialNumber());

        load = new Load().invoke("e:\\cert\\unionpay\\prod\\acp_prod_verify_sign.cer");
        certificate = load.getCertificate();
        publicKey = load.getPublicKey();
        System.out.println(publicKey);
        System.out.println(certificate.getSerialNumber());

        load = new Load().invoke("e:\\cert\\unionpay\\prod\\acp_prod_enc.cer");
        certificate = load.getCertificate();
        publicKey = load.getPublicKey();
        System.out.println(publicKey);
        System.out.println(certificate.getSerialNumber());
    }

    private static class Load {
        private X509Certificate certificate;
        private PublicKey publicKey;

        public X509Certificate getCertificate() {
            return certificate;
        }

        public PublicKey getPublicKey() {
            return publicKey;
        }

        public Load invoke(String path) throws CertificateException, NoSuchProviderException, FileNotFoundException {
            CertificateFactory factory = CertificateFactory.getInstance("X.509", "BC");
            FileInputStream fis = new FileInputStream(path);
            certificate = (X509Certificate) factory.generateCertificate(fis);
            publicKey = certificate.getPublicKey();
            return this;
        }
    }
}
