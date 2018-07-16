package resource;

import controller.ChatController;

/**
 * 聊天OBS资源（单例）
 */
public class ChatObsResource extends ObservableResource {

    /**
     * 静态内部类
     */
    private static class ChatObsResourceInstance {
        private static final ChatObsResource INSTANCE = new ChatObsResource();
    }

    /**
     * 获取实例
     *
     * @return 实例
     */
    public static ChatObsResource getInstance() {
        return ChatObsResourceInstance.INSTANCE;
    }

    /**
     * 构造函数
     */
    private ChatObsResource() {
        super("obs");
        registerObserveMethod(ChatController.getInstance()::receiveMessage);
    }
}
