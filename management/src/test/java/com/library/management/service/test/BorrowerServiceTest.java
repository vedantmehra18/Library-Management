package com.library.management.service.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.library.management.dao.BorrowerRepository;
import com.library.management.model.Borrower;
import com.library.management.service.BorrowerService;

public class BorrowerServiceTest {

    @Mock
    private BorrowerRepository borrowerRepository;

    @InjectMocks
    private BorrowerService borrowerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterBorrower() {
        Borrower borrower = new Borrower();
        borrower.setName("John Doe");
        borrower.setEmail("john.doe@example.com");

        borrowerService.registerBorrower(borrower);

        verify(borrowerRepository).save(any(Borrower.class));
    }

    // Add more tests as needed
}

