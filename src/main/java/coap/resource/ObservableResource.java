package coap.resource;

import coap.controller.ApplicationController;
import org.eclipse.californium.core.coap.CoAP;

/**
 * 可观察资源
 * 在原有ApplicationResource的基础上自带了Observable属性配置
 * <p>
 * 用法：
 * 1、大部分用法同ApplicationResource
 * 2、通过registerObserveMethod来进行观察方法的注册（行为同注册GET方法）
 * 3、需要进行changed提醒的时候，直接调用changed方法即可
 * <p>
 * 注意：
 * 1、同ApplicationResource
 * 2、其子类应该设计为单例模式
 */
public abstract class ObservableResource extends ApplicationResource {
    /**
     * 构造函数
     *
     * @param name 资源名
     */
    ObservableResource(String name) {
        super(name);
    }

    /**
     * 构造函数
     *
     * @param name    资源名
     * @param visible 可见性
     */
    ObservableResource(String name, boolean visible) {
        super(name, visible);
    }

    /**
     * 初始化函数
     */
    protected void initialize() {
        super.initialize();
        setObservable(true);
        setObserveType(CoAP.Type.CON);
    }

    /**
     * 注册观察方法
     *
     * @param method 控制器方法
     * @return 资源对象
     */
    ObservableResource registerObserveMethod(ApplicationController.ControllerMethod method) {
        this.registerMethod(RequestType.GET, method);
        return this;
    }
}
