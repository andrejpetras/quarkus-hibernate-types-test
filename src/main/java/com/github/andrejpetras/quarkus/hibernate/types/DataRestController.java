package com.github.andrejpetras.quarkus.hibernate.types;

import io.quarkus.vertx.web.Body;
import io.quarkus.vertx.web.Param;
import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class DataRestController {

    @Inject
    EntityManager em;

    @Route(path = "/data/:id", methods = HttpMethod.GET, type = Route.HandlerType.BLOCKING)
    public Data data(@Param("id") String id) {
        Data data = em.find(Data.class, id);
        System.out.println("Data: " + data);
        return data;
    }

    @Transactional
    @Route(path = "/data", methods = HttpMethod.POST, type = Route.HandlerType.BLOCKING)
    public Data create(@Body Data data) {
        em.persist(data);
        return data;
    }
}
