package com.library.management.dao;

import org.springframework.data.repository.CrudRepository;

import com.library.management.model.Borrower;

public interface BorrowerRepository extends CrudRepository<Borrower, Long> {
}
