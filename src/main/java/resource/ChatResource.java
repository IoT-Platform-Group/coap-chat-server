package resource;

import controller.ChatController;

/**
 * 聊天系统资源
 */
public class ChatResource extends ApplicationResource {
    /**
     * 构造函数
     */
    public ChatResource() {
        super("chat");
        this
                .add(
                        new ApplicationResource("receive")
                                .registerMethod(RequestType.POST, ChatController::receiveMessage)
                );
    }
}
