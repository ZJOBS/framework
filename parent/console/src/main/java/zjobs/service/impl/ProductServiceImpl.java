package zjobs.service.impl;

import org.springframework.stereotype.Service;
import zjobs.dao.ProductDao;
import zjobs.entity.DataTablePage;
import zjobs.entity.db.Product;
import zjobs.service.AbstractService;
import zjobs.service.ProductService;

import java.util.List;
import java.util.Map;

/**
 * 产品服务层
 *
 * @author jiezhang
 */
@Service
public class ProductServiceImpl extends AbstractService<Product, ProductDao> implements ProductService {
//
//    @Override
//    public DataTablePage queryPage(Map parameters, DataTablePage page) throws Exception {
//        page.setParams(parameters);
//        List<Product> list = dao.queryDataTablePage(page);
//        page.setAaData(list);
//        return page;
//    }
}
