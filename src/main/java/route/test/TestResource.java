package route.test;

import controller.TestController;
import lib.RequestType;
import route.ApplicationResource;

/**
 * 测试资源
 */
public class TestResource extends ApplicationResource {
    /**
     * 构造函数
     */
    public TestResource() {
        super("test");
        this.registerMethod(RequestType.GET, TestController::test);
    }
}
