package zjobs.service.impl;

import org.springframework.stereotype.Service;
import zjobs.dao.TeacherDao;
import zjobs.entity.Teacher;
import zjobs.service.AbstractService;
import zjobs.service.TeacherService;

/**
 * @author jiezhang
 */
@Service
public class TeacherServiceImpl extends AbstractService<Teacher, TeacherDao> implements TeacherService {
}
