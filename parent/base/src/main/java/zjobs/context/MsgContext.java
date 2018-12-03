package zjobs.context;

/**
 * 消息，生成日志
 *
 * @author jiezhang
 */
public class MsgContext {
    private final String messageId;
    private final String channelName;
    private final long startTime;
    private long timeOut = 120000L;
    private String log_level = "INFO";

    public MsgContext(String messageId, String channelName, long startTime) {
        this.messageId = messageId;
        this.channelName = channelName;
        this.startTime = startTime;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getTimeOut() {
        return this.timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public String getLog_level() {
        return this.log_level;
    }

    public void setLog_level(String log_level) {
        this.log_level = log_level;
    }
}
