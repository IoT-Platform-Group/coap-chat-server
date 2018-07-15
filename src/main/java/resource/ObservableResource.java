package resource;

import controller.ApplicationController;
import org.eclipse.californium.core.coap.CoAP;

/**
 * 可观察资源
 */
public class ObservableResource extends ApplicationResource {
    /**
     * 构造函数
     *
     * @param name 资源名
     */
    public ObservableResource(String name) {
        super(name);
        this.initialize();
    }

    /**
     * 构造函数
     *
     * @param name    资源名
     * @param visible 可见性
     */
    ObservableResource(String name, boolean visible) {
        super(name, visible);
        this.initialize();
    }

    /**
     * 初始化函数
     */
    private void initialize() {
        setObservable(true);
        setObserveType(CoAP.Type.CON);
    }

    /**
     * 注册观察方法
     *
     * @param method 控制器方法
     * @return 资源对象
     */
    public ObservableResource registerObserveMethod(ApplicationController.ControllerMethod method) {
        this.registerMethod(RequestType.GET, method);
        return this;
    }
}
