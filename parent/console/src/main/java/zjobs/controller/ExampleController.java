package zjobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiezhang
 */
@Controller
@RequestMapping(value = "example")
public class ExampleController {


    @RequestMapping(value = "/select")
    public String select() {
        return "example/select";
    }

    @RequestMapping(value = "/check")
    public String check() {
        return "example/check";
    }

    @RequestMapping(value = "/radio")
    public String radio() {
        return "example/radio";
    }

    @RequestMapping(value = "/switch")
    public String switch1() {
        return "example/switch";
    }


    @RequestMapping(value = "/datepicker")
    public String datepicker() {
        return "example/datepicker";
    }

    @RequestMapping(value = "/tableColumn")
    public String tableColumn() {
        return "example/tableColumn";
    }

    @RequestMapping(value = "/product")
    public String product() {
        return "example/product";
    }

    @RequestMapping(value = "/productEdit")
    public String productEdit() {
        return "example/productEdit";
    }

}
