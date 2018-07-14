import lib.Server;
import resource.test.TestResource;

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
                .add(new TestResource());
        Executors.newSingleThreadExecutor().execute(server::start);
    }
}
