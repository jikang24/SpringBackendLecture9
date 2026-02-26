package com.example.practicedb.service;

import com.example.practicedb.domain.Menu;
import com.example.practicedb.repository.MenuRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuService {

  private final MenuRepository repository;

  public MenuService(MenuRepository repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public Menu findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("메뉴 없음"));
  }

  @Transactional(readOnly = true)
  public List<Menu> search(String keyword) {
    return repository.findByNameContaining(keyword);
  }

  @Transactional(readOnly = true)
  public List<Menu> searchAll() {
    return repository.findAll();
  }







}
