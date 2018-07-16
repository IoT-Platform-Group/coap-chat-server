package config;

/**
 * 全局设置类
 */
public abstract class CoapServerConfig {
    /**
     * 绑定ip地址
     */
    public static final String IP_ADDRESS = "127.0.0.1";
    /**
     * 监听端口号
     */
    public static final int PORT = 5683;
    /**
     * 线程数
     */
    public static final int NUMBER_OF_THREAD = 4;
    /**
     * IDLE超时时间
     */
    public static final int IDLE_TIMEOUT = 20000;
}
