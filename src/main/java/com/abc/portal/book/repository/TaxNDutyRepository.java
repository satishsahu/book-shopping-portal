package com.abc.portal.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.portal.book.entity.TaxNDuty;

@Repository
public interface TaxNDutyRepository extends JpaRepository<TaxNDuty, Long> {

}
