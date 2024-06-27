package com.library.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.model.Borrower;
import com.library.management.service.BorrowerService;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {

	@Autowired
	private BorrowerService borrowerService;

	// Register a new borrower
	@PostMapping
	public ResponseEntity<Borrower> registerBorrower(@RequestBody Borrower borrower) {
		Borrower savedBorrower = borrowerService.registerBorrower(borrower);
		return new ResponseEntity<>(savedBorrower, HttpStatus.CREATED);
	}

	// Get all borrowers
	@GetMapping
	public ResponseEntity<List<Borrower>> getAllBorrowers() {
		List<Borrower> borrowers = (List<Borrower>) borrowerService.getAllBorrowers();
		return new ResponseEntity<>(borrowers, HttpStatus.OK);
	}

	// Update a borrower by id
	@PutMapping("/{id}")
	public ResponseEntity<Borrower> updateBorrower(@PathVariable Long id, @RequestBody Borrower updatedBorrower) {
		try {
			Borrower borrower = borrowerService.updateBorrower(id, updatedBorrower);
			return new ResponseEntity<>(borrower, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle not found exception
		}
	}

	// Delete a borrower by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBorrower(@PathVariable Long id) {
		try {
			borrowerService.deleteBorrower(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle not found exception
		}
	}

	// Find a borrower by id
	@GetMapping("/{id}")
	public ResponseEntity<Borrower> findBorrowerById(@PathVariable Long id) {
		Optional<Borrower> borrowerOptional = borrowerService.findBorrowerById(id);
		return borrowerOptional.map(borrower -> new ResponseEntity<>(borrower, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}