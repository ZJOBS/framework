package zjobs.controller;

import org.springframework.stereotype.Controller;
import zjobs.constant.BaseConstants;
import zjobs.entity.UAI;

/**
 * Created by ZhangJie on 2016/4/13.
 */
@Controller
public class AuthorityController extends BaseController {

    protected UAI getUAI() {
        return (UAI) getSession().getAttribute(BaseConstants.UAI);
    }

    protected String getUai() {
        UAI u = getUAI();
        return u == null ? "" : u.getAdminName();
    }

}
