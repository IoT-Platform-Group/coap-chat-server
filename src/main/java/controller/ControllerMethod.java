package controller;

import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 * 控制器方法类
 */
public interface ControllerMethod {
    /**
     * 方法执行
     *
     * @param exchange 交换对象
     */
    void execute(CoapExchange exchange);
}
