package com.abc.portal.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abc.portal.book.entity.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {

	@Query("select c from Discount c where c.category = :category")
    public List<Discount> getDiscountbyCategory(@Param("category") String category);
}
