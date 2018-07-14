package lib;

import config.ApplicationConfig;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.elements.tcp.TcpServerConnector;

import java.net.InetSocketAddress;

/**
 * 主服务对象
 */
public class Server extends CoapServer {
    /**
     * 构造函数
     */
    public Server() {
        initialize();
    }

    /**
     * 对象初始化
     */
    private void initialize() {
        addEndpoint(new CoapEndpoint(new InetSocketAddress(ApplicationConfig.IP_ADDRESS, ApplicationConfig.PORT)));
        addEndpoint(new CoapEndpoint(
                new TcpServerConnector(
                        new InetSocketAddress(ApplicationConfig.IP_ADDRESS, ApplicationConfig.PORT),
                        ApplicationConfig.NUMBER_OF_THREAD,
                        ApplicationConfig.IDLE_TIMEOUT
                ),
                NetworkConfig.getStandard()
        ));
    }
}
