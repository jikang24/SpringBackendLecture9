package com.example.practicedb.repository;

import com.example.practicedb.domain.Menu;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuRepository extends JpaRepository<Menu, Long> {

  List<Menu> findByNameContaining(String keyword);

  List<Menu> findByPriceBetween(int min, int max);

  boolean existsByPriceGreaterThan(int price);

  List<Menu> findByCategoryId(Long categoryId);

  @Query("""
        SELECT m
        FROM Menu m
        WHERE m.category.name = :categoryName
          AND m.price >= :minPrice
        ORDER BY m.price DESC
    """)
  List<Menu> findByCategoryNameAndMinPrice(
      @Param("categoryName") String categoryName,
      @Param("minPrice") int minPrice
  );

  List<Menu> findByCategoryNameAndPriceGreaterThanEqualOrderByPriceDesc(
      String categoryName,
      int minPrice
  );

  Page<Menu> findByCategoryNameAndPriceGreaterThanEqual(
      String categoryName, int minPrice, Pageable pageable);

  Slice<Menu> findSliceByCategoryNameAndPriceGreaterThanEqual(
      String categoryName, int minPrice, Pageable pageable);

  @Query("""
        SELECT m
        FROM Menu m
        WHERE m.price >= :minPrice
          AND (:categoryName IS NULL OR m.category.name = :categoryName)
    """)
  Page<Menu> findByMinPriceAndOptionalCategory(
      @Param("minPrice") int minPrice,
      @Param("categoryName") String categoryName,
      Pageable pageable
  );
}
