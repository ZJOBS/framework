package zjobs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjobs.dao.StudentDao;
import zjobs.entity.Student;
import zjobs.service.AbstractService;
import zjobs.service.StudentService;

/**
 * @author jiezhang
 */
@Service
public class StudentServiceImpl extends AbstractService<Student, StudentDao> implements StudentService {
}
