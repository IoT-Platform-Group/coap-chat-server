package resource;

import controller.ChatController;

/**
 * 聊天OBS资源
 */
public class ChatObsResource extends ObservableResource {
    /**
     * 构造函数
     */
    public ChatObsResource() {
        super("obs");
        registerObserveMethod(ChatController.getInstance()::receiveMessage);
    }
}
