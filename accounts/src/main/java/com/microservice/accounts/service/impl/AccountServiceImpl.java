package com.microservice.accounts.service.impl;

import com.microservice.accounts.dto.CustomerDto;
import com.microservice.accounts.exception.CustomerAlreadyExistsException;
import com.microservice.accounts.mapper.CustomerMapper;
import com.microservice.accounts.model.Account;
import com.microservice.accounts.model.AccountType;
import com.microservice.accounts.model.Customer;
import com.microservice.accounts.repository.AccountRepository;
import com.microservice.accounts.repository.CustomerRepository;
import com.microservice.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(CustomerDto customerDto) {
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException();
        }
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        System.out.println(customer);
        Customer savedCustomer = customerRepository.save(customer);

        Account account = this.createNewAccount(savedCustomer);

        return account;
    }

    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = new Random().nextLong(10000000000L);
        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountType.SAVING);

        return accountRepository.save(newAccount);
    }


}
