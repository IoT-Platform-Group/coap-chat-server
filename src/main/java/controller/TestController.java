package controller;

import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 * 测试控制器
 */
public class TestController extends ApplicationController {
    /**
     * 构造函数
     */
    private TestController() {
    }

    /**
     * 静态内部类
     */
    private static class TestControllerInstance {
        private static TestController INSTANCE = new TestController();
    }

    /**
     * 获取实例
     *
     * @return 实例
     */
    public static TestController getInstance() {
        return TestControllerInstance.INSTANCE;
    }

    /**
     * 测试方法
     *
     * @param exchange 交换对象
     */
    public void test(CoapExchange exchange) {
        String token = exchange.getQueryParameter("token");
        System.out.println(String.format("Test is called! Token is %s.", token));
        exchange.respond(String.format("Test is received, the token is %s.", token));
    }


    /**
     * 获取系统时间戳
     *
     * @param exchange 交换对象
     */
    public void getTime(CoapExchange exchange) {
        exchange.respond(String.format("%s", System.currentTimeMillis()));
    }
}
