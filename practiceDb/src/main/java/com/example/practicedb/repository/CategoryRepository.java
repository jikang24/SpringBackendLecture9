package com.example.practicedb.repository;

import com.example.practicedb.domain.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  // 신규 추가
  Optional<Category> findByName(String name);
}
