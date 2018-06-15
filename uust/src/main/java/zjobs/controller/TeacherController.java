package zjobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import zjobs.entity.DataTablePage;
import zjobs.entity.Teacher;
import zjobs.service.TeacherService;

/**
 * @author jiezhang
 */
@Controller
public class TeacherController extends BaseController {

    @Autowired
    private TeacherService teacherService;


    @RequestMapping(value = "teacherIndex")
    public String teacher() {
        return "teacher/index";
    }

    @RequestMapping(value = "queryTeacher")
    @ResponseBody
    public DataTablePage<Teacher> pageQueryTeacher(Teacher teacher) {
        DataTablePage<Teacher> page = null;
        try {
            page = teacherService.queryPage(teacher.toMap(), createDataTablePage(teacher));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping(value = "addTeacher")
    @ResponseBody
    public int addTeacher(Teacher teacher, MultipartFile file) {
        int flag = 0;
        try {
            flag = teacherService.createEntity(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "deleteTeacher")
    @ResponseBody
    public int deleteTeacher(Teacher teacher) {
        int flag = 0;
        try {
            flag = teacherService.removeEntity(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "updateTeacher")
    @ResponseBody
    public int updateTeacher(Teacher teacher, MultipartFile file) {
        int flag = 0;
        try {
            flag = teacherService.modifyEntity(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
