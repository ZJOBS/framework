package zjobs.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjobs.Constant.RedisConstants;
import zjobs.dao.DictDao;
import zjobs.entity.db.Dict;
import zjobs.service.AbstractService;
import zjobs.service.DictService;
import zjobs.service.RedisService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 2015/3/9
 */
@Service
public class DictServiceImpl extends AbstractService<Dict, DictDao> implements DictService {


    @Autowired
    private RedisService redisService;

    @Override
    public void resetRedisDict() throws Exception {
        //插叙出所有的字典
        //{dictId:[{"name":"","value":""},{"name":"","value":""}]}
        Map<String, JSONArray> dictMaps = new HashMap<String, JSONArray>();
        List<Dict> rootDict = new LinkedList<Dict>();

        //统计dict按Code ：value放入dictMaps中
        List<Dict> dictList = dao.selectAll();
        //把parentId作为Key
        for (Dict dict : dictList) {
            if ("0".equals(dict.getParentId())) {
                rootDict.add(dict);
            } else if (dictMaps.containsKey(dict.getParentId())) {
                //包含的时候
                JSONObject dictObj = new JSONObject();
                dictObj.put("name", dict.getName());
                dictObj.put("value", dict.getValue());
                dictMaps.get(dict.getParentId()).add(dictObj);
            } else {
                //不包含的时候
                JSONArray jsonArray = new JSONArray();
                Map<String, String> dictMap = new HashMap<String, String>();
                dictMap.put("name", dict.getName());
                dictMap.put("value", dict.getValue());
                jsonArray.add(dictMap);
                dictMaps.put(dict.getParentId(), jsonArray);
            }
        }
        JSONObject jsonObject;
        for (Dict dict : rootDict) {
            jsonObject = new JSONObject();
            jsonObject.put("name", dict.getName());
            jsonObject.put("value", dictMaps.get(dict.getDictId()));
            redisService.put(RedisConstants.DICT, dict.getCode(), jsonObject.toJSONString());
        }
    }

    @Override
    public void updateRedisDict() throws Exception {

    }


}
