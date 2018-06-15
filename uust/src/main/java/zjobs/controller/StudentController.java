package zjobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import zjobs.entity.DataTablePage;
import zjobs.entity.Student;
import zjobs.service.StudentService;

/**
 * @author jiezhang
 */
@Controller
public class StudentController extends BaseController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "studentIndex")
    public String student() {
        return "student/index";
    }

    @RequestMapping(value = "queryStudent")
    @ResponseBody
    public DataTablePage<Student> pageQueryStudent(Student student) {
        DataTablePage<Student> page = null;
        try {
            page = studentService.queryPage(student.toMap(), createDataTablePage(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping(value = "addStudent")
    @ResponseBody
    public int addStudent(Student student, MultipartFile file) {
        int flag = 0;
        try {
            flag = studentService.createEntity(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "deleteStudent")
    @ResponseBody
    public int deleteStudent(Student student) {
        int flag = 0;
        try {
            flag = studentService.removeEntity(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "updateStudent")
    @ResponseBody
    public int updateStudent(Student student, MultipartFile file) {
        int flag = 0;
        try {
            flag = studentService.modifyEntity(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
