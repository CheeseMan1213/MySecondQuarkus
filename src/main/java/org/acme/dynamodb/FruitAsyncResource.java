package org.acme.dynamodb;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Uni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Path("/async-fruits")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
@RestController
@RequestMapping("/async-fruits")
public class FruitAsyncResource {

//    @Inject
	@Autowired
    FruitAsyncService service;

//    @GET
	@GetMapping
    public Uni<List<Fruit>> getAll() {
        return service.findAll();
    }

//    @GET
//    @Path("{name}")
	@GetMapping("/{name}")
    public Uni<Fruit> getSingle(@PathVariable("name") String name) {
        return service.get(name);
    }

//    @POST
	@PostMapping
    public Uni<List<Fruit>> add(Fruit fruit) {
        return service.add(fruit)
                .onItem().ignore().andSwitchTo(this::getAll);
    }
}
