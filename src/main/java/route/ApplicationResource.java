package route;

import controller.ControllerMethod;
import lib.RequestType;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

import java.util.HashMap;

/**
 * 路由封装基类
 */
public abstract class ApplicationResource extends CoapResource {
    /**
     * 方法存储
     */
    private final HashMap<RequestType, ControllerMethod> map = new HashMap<>();

    /**
     * 构造函数
     *
     * @param name 资源名
     */
    public ApplicationResource(String name) {
        super(name);
    }

    /**
     * 构造函数
     *
     * @param name    资源名
     * @param visible 可见性
     */
    public ApplicationResource(String name, boolean visible) {
        super(name, visible);
    }

    /**
     * 执行方法
     *
     * @param type     请求类型
     * @param exchange 交换对象
     */
    private void executeMethod(RequestType type, CoapExchange exchange) {
        ControllerMethod method = map.getOrDefault(type, null);
        if (method != null) {
            method.execute(exchange);
        }
    }

    /**
     * 注册方法
     *
     * @param type   请求类型
     * @param method 交换对象
     */
    protected void registerMethod(RequestType type, ControllerMethod method) {
        map.put(type, method);
    }

    /**
     * GET请求处理
     *
     * @param exchange 交换对象
     */
    @Override
    public void handleGET(CoapExchange exchange) {
        super.handleGET(exchange);
        this.executeMethod(RequestType.GET, exchange);
    }


    /**
     * POST请求处理
     *
     * @param exchange 交换对象
     */
    @Override
    public void handlePOST(CoapExchange exchange) {
        super.handlePOST(exchange);
        this.executeMethod(RequestType.POST, exchange);
    }

    /**
     * PUT请求处理
     *
     * @param exchange 交换对象
     */
    @Override
    public void handlePUT(CoapExchange exchange) {
        super.handlePUT(exchange);
        this.executeMethod(RequestType.PUT, exchange);
    }

    /**
     * DELETE请求处理
     *
     * @param exchange 交换对象
     */
    @Override
    public void handleDELETE(CoapExchange exchange) {
        super.handleDELETE(exchange);
        this.executeMethod(RequestType.DELETE, exchange);
    }
}
