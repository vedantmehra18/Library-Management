package com.library.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.library.management.dao.BorrowerRepository;
import com.library.management.model.Borrower;

@Transactional
public class BorrowerServiceImpl implements BorrowerService {


    @Autowired
    BorrowerRepository borrowerRepository;

    // Method to register a new borrower
    @Override
    public Borrower registerBorrower(Borrower borrower) {
        // Implement validation and business logic as needed
        return borrowerRepository.save(borrower);
    }

    // Method to retrieve all borrowers
    @Override
    public List<Borrower> getAllBorrowers() {
        return (List<Borrower>) borrowerRepository.findAll();
    }

    // Method to find a borrower by ID
    @Override
    public Optional<Borrower> findBorrowerById(Long id) {
        return borrowerRepository.findById(id);
    }

    // Method to delete a borrower by ID
    @Override
    public void deleteBorrower(Long id) {
        borrowerRepository.deleteById(id);
    }

    // Method to update a borrower
    @Override
    public Borrower updateBorrower(Long id, Borrower updatedBorrower) {
        // Check if the borrower exists
        Optional<Borrower> existingBorrowerOptional = borrowerRepository.findById(id);
        if (existingBorrowerOptional.isPresent()) {
            Borrower existingBorrower = existingBorrowerOptional.get();
            // Update fields of existingBorrower with fields from updatedBorrower
            existingBorrower.setName(updatedBorrower.getName());
            existingBorrower.setEmail(updatedBorrower.getEmail());
            return borrowerRepository.save(existingBorrower);
        } else {
            throw new RuntimeException("Borrower not found with id: " + id);
        }
    }

    // Other methods as needed

}