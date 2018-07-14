package resource;


import controller.ObservableController;
import org.eclipse.californium.core.coap.CoAP;

import java.util.Timer;
import java.util.TimerTask;

public class ObservableResource extends ApplicationResource {

    public ObservableResource() {
        super("obs");

        setObservable(true);
        setObserveType(CoAP.Type.CON);


        this.registerMethod(RequestType.GET, ObservableController::update);


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                changed();
            }
        }, 0, 5000);  // 每5秒
    }
}
