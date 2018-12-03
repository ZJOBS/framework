package zjobs.web.tag;

import zjobs.base.FormTag;

/**
 * 文件上传
 *
 * @author jiezhang
 */
public class UploadFile extends FormTag {
    @Override
    public String getStartTemplate() {
        return "file.ftl";
    }
}
