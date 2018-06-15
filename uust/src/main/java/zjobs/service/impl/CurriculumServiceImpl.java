package zjobs.service.impl;

import org.springframework.stereotype.Service;
import zjobs.dao.CurriculumDao;
import zjobs.entity.Curriculum;
import zjobs.service.AbstractService;
import zjobs.service.CurriculumService;

/**
 * @author jiezhang
 */
@Service
public class CurriculumServiceImpl extends AbstractService<Curriculum, CurriculumDao> implements CurriculumService {
}
