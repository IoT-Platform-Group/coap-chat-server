package resource;

import controller.ChatController;

/**
 * 聊天系统资源（单例）
 */
public class ChatResource extends ApplicationResource {
    /**
     * 静态内部类
     */
    private static class ChatResourceInstance {
        private static final ChatResource INSTANCE = new ChatResource();
    }

    /**
     * 获取实例
     *
     * @return 实例
     */
    public static ChatResource getInstance() {
        return ChatResourceInstance.INSTANCE;
    }

    /**
     * 构造函数
     */
    private ChatResource() {
        super("chat");
        add(new ApplicationResource("send").registerMethod(RequestType.POST, ChatController.getInstance()::sendMessage));
        add(ChatObsResource.getInstance());
    }

}
