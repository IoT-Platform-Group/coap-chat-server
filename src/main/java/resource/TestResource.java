package resource;

import controller.TestController;

/**
 * 测试资源
 */
public class TestResource extends ApplicationResource {
    /**
     * 构造函数
     */
    public TestResource() {
        super("test");
        this
                .registerMethod(RequestType.GET, TestController::test)
                .registerMethod(RequestType.POST, TestController::test);
    }
}
