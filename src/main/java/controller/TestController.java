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
        System.out.println("Test is called!");
        System.out.println(exchange.getQueryParameter("fuck"));
        exchange.respond(String.format("faq: %s", exchange.getQueryParameter("fuck")));
    }
}
