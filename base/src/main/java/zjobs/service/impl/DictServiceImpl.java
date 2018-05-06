package zjobs.service.impl;

//import org.springframework.stereotype.Service;
//import zjobs.dao.DictDao;
//import zjobs.entity.db.Dict;
//import zjobs.entity.Page;
//import zjobs.service.AbstractService;
//import zjobs.service.DictService;

import org.springframework.stereotype.Service;
import zjobs.dao.DictDao;
import zjobs.entity.db.Dict;
import zjobs.service.AbstractService;
import zjobs.service.DictService;

/**
 * @author Administrator
 * @date 2015/3/9
 */
@Service
public class DictServiceImpl extends AbstractService<Dict, DictDao> implements DictService {

    @Override
    public void injectionDictMap() {
        
    }

}
