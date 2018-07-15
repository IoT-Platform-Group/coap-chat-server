package resource;

import controller.TestController;

/**
 * 测试资源（单例）
 */
public class TestResource extends ApplicationResource {

    /**
     * 静态内部类
     */
    private static class TestResourceInstance {
        private static TestResource INSTANCE = new TestResource();
    }

    /**
     * 获取实例
     *
     * @return 实例
     */
    public static TestResource getInstance() {
        return TestResourceInstance.INSTANCE;
    }

    /**
     * 构造函数
     */
    private TestResource() {
        super("test");
        this
                .registerMethod(RequestType.GET, TestController.getInstance()::test)
                .registerMethod(RequestType.POST, TestController.getInstance()::test);
    }
}
