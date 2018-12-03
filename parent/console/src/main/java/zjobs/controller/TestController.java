package zjobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zjobs.utils.MailServiceUtil;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * 测试界面
 *
 * @author jiezhang
 */
@Controller
public class TestController {
    /**
     * 用于测试界面的
     *
     * @return
     */
    @RequestMapping(value = "testIndex")
    public String testIndex() {
        return "test/index";
    }

    /**
     * 用于测试界面的
     *
     * @return
     */
    @RequestMapping(value = "test")
    public void test() {
        try {
            MailServiceUtil.sendHtmlMail("438220615@qq.com", "测试", "随便什么内容");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(Double.MAX_VALUE);
    }
}
