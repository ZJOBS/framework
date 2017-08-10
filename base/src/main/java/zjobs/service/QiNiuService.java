package zjobs.service;

import java.io.File;

/**
 * Created by ZhangJie on 2017/3/9.
 */
public interface QiNiuService {
    /**
     * @param file     文件
     * @param FileType 文件类型
     * @throws Exception
     */
    public long uploadFile(File file, String FileType) throws Exception;
}
