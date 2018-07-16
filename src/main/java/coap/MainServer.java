package coap;

import config.CoapServerConfig;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.elements.tcp.TcpServerConnector;
import coap.resource.ChatResource;
import coap.resource.TestResource;

import java.net.InetSocketAddress;

/**
 * 主服务对象（单例）
 */
public class MainServer extends CoapServer {
    /**
     * 静态内部类
     */
    private static class MainServerInstance {
        private static final MainServer INSTANCE = new MainServer();
    }

    /**
     * 获取实例
     *
     * @return 实例
     */
    public static MainServer getInstance() {
        return MainServerInstance.INSTANCE;
    }

    /**
     * 构造函数
     */
    private MainServer() {
        initialize();
    }

    /**
     * 对象初始化
     */
    private void initialize() {
        initializeEndpoint();
        initializeRootResource();
    }

    /**
     * 协议节点初始化
     */
    private void initializeEndpoint() {
        addEndpoint(new CoapEndpoint(new InetSocketAddress(CoapServerConfig.IP_ADDRESS, CoapServerConfig.PORT)));
        addEndpoint(new CoapEndpoint(
                new TcpServerConnector(
                        new InetSocketAddress(CoapServerConfig.IP_ADDRESS, CoapServerConfig.PORT),
                        CoapServerConfig.NUMBER_OF_THREAD,
                        CoapServerConfig.IDLE_TIMEOUT
                ),
                NetworkConfig.getStandard()
        ));
    }

    /**
     * 跟路由初始化
     */
    private void initializeRootResource() {
        add(ChatResource.getInstance());
        add(TestResource.getInstance());
    }
}
