package zjobs.util.file;

import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.File;
import java.io.FileInputStream;

/**
 * 千牛网上传文件方法
 * Created by ZhangJie on 2017/3/9.
 */
public class QiNiuUtils {
    String ak = "kp2FKD8lWEYVwnkni-h-4LUSRQ7LrEdiIh16nrmb";
    String sk = "qVHAoWFNYC0wJTy7vA_a8GxUI-fkBlCQfmS355tB";    // 密钥配置
    String key = "1111";    //上传的图片名

    /*上传图片到七牛云*/
    public void put64image(File file, String fileType) throws Exception {
        String bucketname = "image";    //空间名
        FileInputStream fis = null;
        int l = (int) (file.length());
        byte[] src = new byte[l];
        fis = new FileInputStream(file);
        fis.read(src);
        String file64 = Base64.encodeToString(src, 0);
        String url = "http://upload.qiniu.com/putb64/" + l + "/key/" + UrlSafeBase64.encodeToString(key);
        Auth auth = Auth.create(ak, sk);
        String upToken = auth.uploadToken(bucketname, null, 3600, new StringMap().put("insertOnly", 1));

        //非华东空间需要根据注意事项 1 修改上传域名
        RequestBody rb = RequestBody.create(null, file64);
        Request request = new Request.Builder().
                url(url).
                addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + upToken)
                .post(rb).build();
        System.out.println(request.headers());

        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = client.newCall(request).execute();

        //需要做错误处理
        System.out.println(response);
    }

    public static void main(String[] args) throws Exception {
        String file = "D:\\我的坚果云\\图片\\地平线 期待黎明\\0001202195.jpg";//图片路径
        new QiNiuUtils().put64image(new File(file), "Image");
    }
}
