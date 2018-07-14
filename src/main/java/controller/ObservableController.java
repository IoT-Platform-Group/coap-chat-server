package controller;

import org.eclipse.californium.core.server.resources.CoapExchange;

import java.util.Date;

public class ObservableController extends ApplicationController {
    static public void update(CoapExchange exchange) {
        String current = new Date().toString();
        exchange.respond(current);
    }
}
