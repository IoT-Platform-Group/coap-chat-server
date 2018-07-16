package controller;

import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;
import resource.ChatObsResource;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 聊天控制器
 */
public class ChatController extends ApplicationController {
    /**
     * 构造函数
     */
    private ChatController() {
    }

    /**
     * 静态内部类
     */
    private static class ChatControllerInstance {
        private static final ChatController INSTANCE = new ChatController();
    }

    /**
     * 获得实例
     *
     * @return 实例
     */
    public static ChatController getInstance() {
        return ChatControllerInstance.INSTANCE;
    }


    /**
     * 消息接收
     *
     * @param exchange 交换对象
     */
    public void sendMessage(CoapExchange exchange) {
        String message = exchange.getRequestText();
        String user = exchange.getQueryParameter("user");
        if ((message != null) && (user != null)) {

            putMessage(user, message);
            exchange.respond(CoAP.ResponseCode.VALID, "Message received by server!");
        } else {
            exchange.respond(CoAP.ResponseCode.UNSUPPORTED_CONTENT_FORMAT);
        }
    }

    /**
     * 获取指定用户的消息队列
     *
     * @param user 用户名
     * @return 消息队列
     */
    private ArrayList<String> getMessageQueue(String user) {
        if (map.containsKey(user)) {
            return map.get(user);
        } else {
            ArrayList<String> arrayList = new ArrayList<>();
            map.put(user, arrayList);
            return arrayList;
        }
    }

    /**
     * 将指定消息加入指定用户的消息队列
     *
     * @param user    用户名
     * @param message 消息
     */
    private void putMessage(String user, String message) {
        getMessageQueue(user).add(message);
        System.out.println(String.format("Message to user [%s] : \"%s\"", user, message));
        ChatObsResource.getInstance().changed();
    }

    /**
     * 获取并删除指定用户的消息队列的第一条消息
     *
     * @param user 用户名
     * @return 第一条消息
     */
    private String getFirstMessage(String user) {
        ArrayList<String> arrayList = getMessageQueue(user);
        if (arrayList.size() == 0) {
            return null;
        } else {
            String first = arrayList.get(0);
            arrayList.remove(0);
            return first;
        }
    }

    /**
     * 消息队列map
     */
    private final ConcurrentHashMap<String, ArrayList<String>> map = new ConcurrentHashMap<>();

    /**
     * 接受消息
     *
     * @param exchange 交换对象
     */
    public synchronized void receiveMessage(CoapExchange exchange) {
        String user = exchange.getQueryParameter("user");
        String message = getFirstMessage(user);
        if (message == null) {
            exchange.respond(CoAP.ResponseCode.VALID, "No message found!");
        } else {
            exchange.respond(CoAP.ResponseCode.VALID, String.format("Message : \"%s\"", message));
        }
    }
}
