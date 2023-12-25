package com.microservice.accounts.service;

import com.microservice.accounts.dto.CustomerDto;
import com.microservice.accounts.model.Account;

public interface AccountService {
    Account createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
