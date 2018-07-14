package controller;

import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 * 测试控制器
 */
public class TestController extends ApplicationController {
    /**
     * 测试方法
     *
     * @param exchange 交换对象
     */
    public static void test(CoapExchange exchange) {
        String token = exchange.getQueryParameter("token");
        System.out.println(String.format("Test is called! Token is %s.", token));
        exchange.respond(String.format("Test is received, the token is %s.", token));
    }
}
