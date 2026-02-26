package com.example.practicedb.domain;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Getter;

@Entity
@Table(name = "menus")
@Getter
public class Menu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "menu_name", nullable = false, length = 80)
  private String name;

  @Column(nullable = false)
  private int price;

  @Column(name = "created_at", nullable = false)
  private Instant createdAt;

  protected Menu() { } // JPA 기본 생성자

  public Menu(String name, int price) {
    this.name = name;
    this.price = price;
    this.createdAt = Instant.now();
  }


}
