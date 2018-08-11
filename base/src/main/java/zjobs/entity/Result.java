package zjobs.entity;

import java.io.Serializable;

/**
 * 返回值公共方法
 *
 * @author jiezhang
 */
public class Result implements Serializable {


    private static final long serialVersionUID = -53765340319286134L;

    /**
     * 是否成功  true：成功 、false：失败
     */
    public boolean success;

    public String errorCode;

    /**
     * 错误信息
     */
    public String errorMsg = "";

    public String code;
    public String msg = "";

    /**
     * 推送保留字段
     */
    public String pushResult = "";

    /**
     * 服务器时间
     */
    public String serverTime;

    /**
     * 数据
     **/
    public Object data = "";

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getPushResult() {
        return pushResult;
    }

    public void setPushResult(String pushResult) {
        this.pushResult = pushResult;
    }


    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public Object getData() {
        if (data == "") {
            data = null;
        }
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}