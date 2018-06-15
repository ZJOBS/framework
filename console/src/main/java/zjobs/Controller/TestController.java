package zjobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试界面
 *
 * @author jiezhang
 */
@Controller
public class TestController {
    /**
     * 用于测试界面的
     * @return
     */
    @RequestMapping(value = "testIndex")
    public String test() {
        return "test/index";
    }
}
