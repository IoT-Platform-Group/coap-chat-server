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
        private static ChatResource INSTANCE = new ChatResource();
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
     * 聊天OBS
     */
    private final ChatObsResource obs;

    /**
     * 构造函数
     */
    private ChatResource() {
        super("chat");
        add(new ApplicationResource("send").registerMethod(RequestType.POST, ChatController.getInstance()::sendMessage));
        this.obs = new ChatObsResource();
        add(this.obs);
    }

    /**
     * 获取OBS
     *
     * @return OBS资源
     */
    public ChatObsResource getObs() {
        return obs;
    }
}
