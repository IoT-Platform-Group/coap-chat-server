import controller.TestController;
import resource.ApplicationResource;
import resource.ChatResource;
import resource.ObservableResource;
import resource.TestResource;

import java.util.concurrent.Executors;

/**
 * 主类
 */
public abstract class Main {
    /**
     * 入口点
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        Server server = new Server();
        server
                .add(new TestResource())
                .add(new ChatResource());
        server
                .add(new ObservableResource());
        Executors.newSingleThreadExecutor().execute(server::start);
    }
}
