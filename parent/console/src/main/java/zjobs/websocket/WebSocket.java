package zjobs.websocket;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jiezhang
 */
@ServerEndpoint("/pushMess")
@Component
public class WebSocket {
    private static Map<String, Session> soketSessionMap = new ConcurrentHashMap();
    private static Map<String, String> userMap = new ConcurrentHashMap();

//    public static MessageNoticeService messageNoticeService;


    @OnOpen
    public void onOpen(Session session) {
        String sessionId = session.getId();
        String dateTime = FastDateFormat.getInstance("yyyyMMddHHmmss").format(new Date());
        soketSessionMap.put(sessionId, session);
        System.out.println("开启websocket");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        if (StringUtils.isNotEmpty(message)) {
            String sessionId = session.getId();
            JSONObject jsonObject = JSON.parseObject(message);
            String action = jsonObject.getString("action");
            switch (action) {
//                case "2":
//                    String uuid = jsonObject.getString("data");
//                    userMap.put(uuid, sessionId);
//                    Integer count = messageNoticeService.getUnreadCountByToken(uuid);
//                    String jsonStr = JSON.toJSONString(ImmutableMap.of("action", 1, "data", count));
//                    sendMessage(sessionId, jsonStr);
//                    break;
//                case "3":
//                    String token = jsonObject.getString("data");
//                    messageNoticeService.updateReadStatus(token);
//                    userMap.put(token, sessionId);
//                    break;
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        String sessionId = session.getId();
        soketSessionMap.remove(sessionId);
        for (Map.Entry<String, String> entry : userMap.entrySet()) {
            if (entry.getValue().equals(sessionId)) {
                userMap.remove(entry.getKey());
                return;
            }
        }
    }

    @OnError
    public void onError(Throwable throwable) {
        System.out.println("异常");
    }

    public void sendMessage(String sessionId, String message) {
        try {
            soketSessionMap.get(sessionId).getBasicRemote().sendText(message);
        } catch (Exception e) {
//            log.error("消息发送失败:sessionId:" + sessionId + ",内容:" + message);
        }
    }

    public void sendAllMessage(String message) {
        try {
            for (Session session : soketSessionMap.values()) {
                session.getBasicRemote().sendText(message);
            }
        } catch (Exception e) {
//            log.error("消息发送全部用户失败,内容:" + message);
        }
    }

}
