package com.example.practicedb.repository;

import com.example.practicedb.domain.Menu;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuRepository extends JpaRepository<Menu, Long> {

  @EntityGraph(attributePaths = {"category"})
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

  // [추가] Page 기반: 카테고리명 + 최소가격(2조건) + Pageable(정렬 포함)
  Page<Menu> findByCategoryNameAndPriceGreaterThanEqual(
      String categoryName,
      int minPrice,
      Pageable pageable
  );

  // Slice 기반 (메서드명만 변경)
  Slice<Menu> findSliceByCategoryNameAndPriceGreaterThanEqual(
      String categoryName,
      int minPrice,
      Pageable pageable
  );

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

  @Query("""
        SELECT m
        FROM Menu m
        JOIN FETCH m.category
        WHERE m.name LIKE %:keyword%
    """)
  List<Menu> findByNameContainingWithCategory(@Param("keyword") String keyword);

  @Query(
      value = """
        SELECT m
        FROM Menu m
        JOIN FETCH m.category
        WHERE m.price >= :minPrice
          AND (:categoryName IS NULL OR m.category.name = :categoryName)
    """,
      countQuery = """
        SELECT COUNT(m)
        FROM Menu m
        WHERE m.price >= :minPrice
          AND (:categoryName IS NULL OR m.category.name = :categoryName)
    """
  )
  Page<Menu> findByMinPriceAndOptionalCategoryWithCategory(
      @Param("minPrice") int minPrice,
      @Param("categoryName") String categoryName,
      Pageable pageable
  );

  List<Menu> findByCategoryName(String categoryName);

  // @Query는 기본적으로 SELECT 전용
  // @Modifying은 UPDATE / DELETE 쿼리를 실행한다고 JPA에게 알려주는 표시이고
  // clearAutomatically, flushAutomatically는 영속성 컨텍스트 동기화 옵션이다.
  @Modifying(clearAutomatically = true, flushAutomatically = true)
  @Query("update Menu m set m.price = :price where m.id = :id")
  int updatePrice(@Param("id") Long id, @Param("price") int price);

}
