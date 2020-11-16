package org.acme.dynamodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@Path("/fruits")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
@RestController
@RequestMapping("/fruits")
public class FruitResource {

//    @Inject
	@Autowired
    FruitSyncService service;

//    @GET
	@GetMapping
    public List<Fruit> getAll() {
        return service.findAll();
    }

//    @GET
//    @Path("{name}")
	@GetMapping("/{name}")
    public Fruit getSingle(@PathVariable("name") String name) {
        return service.get(name);
    }

//    @POST
	@PostMapping
    public List<Fruit> add(@Valid @RequestBody Fruit fruit) {
        service.add(fruit);
        return getAll();
    }
}