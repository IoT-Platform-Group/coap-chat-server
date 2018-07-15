import controller.TestController;
import resource.ApplicationResource;
import resource.ChatResource;
import resource.TestResource;

import java.util.Timer;
import java.util.TimerTask;
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
                .add(TestResource.getInstance())
                .add(ChatResource.getInstance());
        Executors.newSingleThreadExecutor().execute(server::start);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                TestResource.getInstance().getObs().changed();
            }
        }, 0, 5000);
    }
}
