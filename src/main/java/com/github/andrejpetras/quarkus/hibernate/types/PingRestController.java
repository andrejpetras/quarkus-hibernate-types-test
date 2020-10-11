package com.github.andrejpetras.quarkus.hibernate.types;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/ping")
public class PingRestController {

    @GET
    public Response ping() {
        return Response.ok("PONG").build();
    }
}
