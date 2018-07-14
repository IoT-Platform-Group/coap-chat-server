package controller;

import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 * 聊天控制器
 */
public class ChatController extends ApplicationController {
    /**
     * 消息接收
     *
     * @param exchange 交换对象
     */
    public static void receiveMessage(CoapExchange exchange) {
        String message = exchange.getQueryParameter("message");
        String target_user = exchange.getQueryParameter("target_user");
        if ((message != null) && (target_user != null)) {
            System.out.println(String.format("Message to user [%s] : \"%s\"", target_user, message));
            exchange.respond(CoAP.ResponseCode.VALID);
        } else {
            exchange.respond(CoAP.ResponseCode.UNSUPPORTED_CONTENT_FORMAT);
        }
    }
}
