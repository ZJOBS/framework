package zjobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import zjobs.entity.DataTablePage;
import zjobs.entity.db.Product;
import zjobs.service.ProductService;


/**
 * @author jiezhang
 */
@Controller
public class ProductController extends BaseController {
    @Autowired
    private ProductService productService;


    @RequestMapping(value = "productIndex")
    public String product() {
        return "product/index";
    }

    @RequestMapping(value = "queryProduct")
    @ResponseBody
    public DataTablePage<Product> pageQueryProduct(Product product) {
        DataTablePage<Product> page = null;
        try {
            page = productService.queryPage(product.toMap(), createDataTablePage(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping(value = "addProduct")
    @ResponseBody
    public int addProduct(Product product, MultipartFile file) {
        int flag = 0;
        try {
            if (file != null) {
                long imgId = qiNiuService.uploadFile(file);
                product.setImage(String.valueOf(imgId));
            }
            flag = productService.createEntity(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "deleteProduct")
    @ResponseBody
    public int deleteProduct(Product product) {
        int flag = 0;
        try {
            flag = productService.removeEntity(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "updateProduct")
    @ResponseBody
    public int updateProduct(Product product, MultipartFile file) {
        int flag = 0;
        try {
            if (file != null) {
                long imgId = qiNiuService.uploadFile(file);
                product.setImage(String.valueOf(imgId));
            }
            flag = productService.modifyEntity(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
