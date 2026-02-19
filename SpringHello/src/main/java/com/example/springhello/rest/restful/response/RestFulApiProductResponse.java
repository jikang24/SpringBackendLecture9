package com.example.springhello.rest.restful.response;

public class RestFulApiProductResponse {
    private Long id;
    private String name;

    public RestFulApiProductResponse(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }

}
