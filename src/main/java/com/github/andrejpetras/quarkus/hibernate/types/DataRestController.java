package com.github.andrejpetras.quarkus.hibernate.types;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/data")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DataRestController {

    @Inject
    EntityManager em;

    @GET
    @Path("{id}")
    public Response data(@PathParam("id") String id) {
        Data data = em.find(Data.class, id);
        System.out.println("Data: " + data);
        return Response.ok(data).build();
    }

    @POST
    @Transactional
    public Response create(Data data) {
        em.persist(data);
        return Response.ok(data).build();
    }
}
