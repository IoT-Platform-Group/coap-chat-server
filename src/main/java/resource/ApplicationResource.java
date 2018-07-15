package resource;

import controller.ApplicationController;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 路由封装基类
 */
public class ApplicationResource extends CoapResource {
    /**
     * 请求类型
     */
    public enum RequestType {
        GET, POST, PUT, DELETE
    }

    /**
     * 方法存储
     */
    private final ConcurrentHashMap<RequestType, ApplicationController.ControllerMethod> map = new ConcurrentHashMap<>();

    /**
     * 构造函数
     *
     * @param name 资源名
     */
    ApplicationResource(String name) {
        super(name);
        this.initialize();
    }

    /**
     * 构造函数
     *
     * @param name    资源名
     * @param visible 可见性
     */
    ApplicationResource(String name, boolean visible) {
        super(name, visible);
        this.initialize();
    }

    /**
     * 初始化方法
     */
    protected void initialize() {
    }

    /**
     * 执行方法
     *
     * @param type     请求类型
     * @param exchange 交换对象
     */
    private boolean executeMethod(RequestType type, CoapExchange exchange) {
        ApplicationController.ControllerMethod method = map.getOrDefault(type, null);
        if (method != null) {
            method.execute(exchange);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 注册方法
     *
     * @param type   请求类型
     * @param method 交换对象
     */
    ApplicationResource registerMethod(RequestType type, ApplicationController.ControllerMethod method) {
        map.put(type, method);
        return this;
    }

    /**
     * GET请求处理
     *
     * @param exchange 交换对象
     */
    @Override
    public void handleGET(CoapExchange exchange) {
        if (!this.executeMethod(RequestType.GET, exchange)) {
            super.handleGET(exchange);
        }
    }


    /**
     * POST请求处理
     *
     * @param exchange 交换对象
     */
    @Override
    public void handlePOST(CoapExchange exchange) {
        if (!this.executeMethod(RequestType.POST, exchange)) {
            super.handlePOST(exchange);
        }
    }

    /**
     * PUT请求处理
     *
     * @param exchange 交换对象
     */
    @Override
    public void handlePUT(CoapExchange exchange) {
        if (!this.executeMethod(RequestType.PUT, exchange)) {
            super.handlePUT(exchange);
        }
    }

    /**
     * DELETE请求处理
     *
     * @param exchange 交换对象
     */
    @Override
    public void handleDELETE(CoapExchange exchange) {
        if (!this.executeMethod(RequestType.DELETE, exchange)) {
            super.handleDELETE(exchange);
        }
    }


}
