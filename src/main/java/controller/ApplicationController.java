package controller;

import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 * 全局控制器基类
 * <p>
 * 用法：
 * 1、继承该类，且所有子类均为抽象类
 * <p>
 * 建议：
 * 1、该类内所有方法均为静态方法
 * 2、该类内所有被路由调用的方法均为void method(CoapExchange exchange)的形式
 */
public abstract class ApplicationController {

    /**
     * 控制器方法类
     * <p>
     * 用途：
     * 1、作为资源类中，路由挂载方法的接口类型
     */
    public interface ControllerMethod {
        /**
         * 方法执行
         *
         * @param exchange 交换对象
         */
        void execute(CoapExchange exchange);
    }
}
