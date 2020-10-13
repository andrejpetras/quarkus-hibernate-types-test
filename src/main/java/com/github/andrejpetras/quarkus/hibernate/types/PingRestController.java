package com.github.andrejpetras.quarkus.hibernate.types;

import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;
import io.quarkus.vertx.web.Route;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PingRestController {

    @Route(methods = HttpMethod.GET)
    public void ping(RoutingContext rc) {
        rc.response().end("PONG");
    }
}
