package com.library.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.management.model.Borrower;

@Service
public interface BorrowerService {

	public Borrower registerBorrower(Borrower borrower);

	public List<Borrower> getAllBorrowers();

	Borrower updateBorrower(Long id, Borrower updatedBorrower);

	void deleteBorrower(Long id);

	Optional<Borrower> findBorrowerById(Long id);
}
