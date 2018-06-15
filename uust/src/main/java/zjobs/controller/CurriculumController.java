package zjobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import zjobs.entity.DataTablePage;
import zjobs.entity.Curriculum;
import zjobs.service.CurriculumService;

/**
 * @author jiezhang
 */
@Controller
public class CurriculumController extends BaseController {
    @Autowired
    private CurriculumService curriculumService;


    @RequestMapping(value = "curriculumIndex")
    public String curriculum() {
        return "curriculum/index";
    }

    @RequestMapping(value = "queryCurriculum")
    @ResponseBody
    public DataTablePage<Curriculum> pageQueryCurriculum(Curriculum curriculum) {
        DataTablePage<Curriculum> page = null;
        try {
            page = curriculumService.queryPage(curriculum.toMap(), createDataTablePage(curriculum));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping(value = "addCurriculum")
    @ResponseBody
    public int addCurriculum(Curriculum curriculum, MultipartFile file) {
        int flag = 0;
        try {
            flag = curriculumService.createEntity(curriculum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "deleteCurriculum")
    @ResponseBody
    public int deleteCurriculum(Curriculum curriculum) {
        int flag = 0;
        try {
            flag = curriculumService.removeEntity(curriculum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "updateCurriculum")
    @ResponseBody
    public int updateCurriculum(Curriculum curriculum, MultipartFile file) {
        int flag = 0;
        try {
            flag = curriculumService.modifyEntity(curriculum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
