package zjobs;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import zjobs.common.utils.EncryptAndDecryptUtil;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Unit CyclicBarrier for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the CyclicBarrier case
     *
     * @param testName name of the CyclicBarrier case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public AppTest() {
    }

    public static void main(String[] args) {
        String aaa = "111111";
        System.out.println("MD5加密后:" + aaa);
        aaa = EncryptAndDecryptUtil.encrypt("111111");
        System.out.println("自己的加密后:" + aaa);
        aaa = EncryptAndDecryptUtil.decrypt(aaa);
        System.out.println("自己的解密后:" + aaa);
    }
}
