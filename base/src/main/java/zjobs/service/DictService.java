package zjobs.service;

import zjobs.entity.db.Dict;
/**
 * Created by ZJOBS on 2015/2/22.
 */
public interface DictService extends BaseService<Dict,Exception> {
    /**
     * 注入字典
     */
    public void injectionDictMap();
}
