package com.example.practicedb.controller;

import com.example.practicedb.domain.Menu;
import com.example.practicedb.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

  private final MenuService service;

  public MenuController(MenuService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public Menu get(@PathVariable Long id) {
    return service.findById(id);
  }

  @GetMapping
  public List<Menu> search(@RequestParam String keyword) {
    return service.search(keyword);
  }

  @GetMapping
  public List<Menu> findAll(){
    return service.searchAll();
  }





}

