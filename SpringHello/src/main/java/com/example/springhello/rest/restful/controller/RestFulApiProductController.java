package com.example.springhello.rest.restful.controller;

import com.example.springhello.rest.restful.response.RestFulApiProductResponse;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/products")
public class RestFulApiProductController {

    @GetMapping("/{id}")
    public EntityModel<RestFulApiProductResponse> getProduct(@PathVariable Long id) {
        RestFulApiProductResponse product = new RestFulApiProductResponse(id, "test product");

        return EntityModel.of(product,
                linkTo(methodOn(RestFulApiProductController.class).getProduct(id)).withSelfRel(),
                linkTo(methodOn(RestFulApiProductController.class).getAllProducts()).withRel("all-products")
        );
    }

    @GetMapping
    public CollectionModel<RestFulApiProductResponse> getAllProducts() {
        List<RestFulApiProductResponse> list = Arrays.asList(
                new RestFulApiProductResponse(1L, "Product 1"),
                new RestFulApiProductResponse(2L, "Product 2")
        );

        return CollectionModel.of(list,
                linkTo(methodOn(RestFulApiProductController.class).getAllProducts()).withSelfRel()
        );
    }
}
