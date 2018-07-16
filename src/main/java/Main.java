import coap.MainServer;

import java.util.Scanner;
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
        run(Main::runCoapServer, args);
        run(Main::runWebServer, args);
    }

    /**
     * 以独立线程的形式运行一个入口点方法
     *
     * @param entrance 入口点方法
     * @param args     命令行参数
     */
    private static void run(Entrance entrance, String[] args) {
        Executors.newSingleThreadExecutor().execute(() -> entrance.enter(args));
    }

    /**
     * 运行Coap服务端
     *
     * @param args 命令行参数
     */
    private static void runCoapServer(String[] args) {
        MainServer.getInstance().start();
    }

    /**
     * 运行web服务端
     *
     * @param args 命令行参数
     */
    private static void runWebServer(String[] args) {
        
    }

    /**
     * 入口点方法接口
     */
    private interface Entrance {
        /**
         * 入口点方法
         *
         * @param args 命令行参数
         */
        void enter(String[] args);
    }

}
