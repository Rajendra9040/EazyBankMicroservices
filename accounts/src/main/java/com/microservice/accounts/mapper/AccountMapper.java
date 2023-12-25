package com.microservice.accounts.mapper;

import com.microservice.accounts.dto.AccountDto;
import com.microservice.accounts.model.Account;
import com.microservice.accounts.model.AccountType;

public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account, AccountDto accountDto) {
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType().name());
        return accountDto;
    }

    public static Account mapToAccount(AccountDto accountDto, Account account) {
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(AccountType.valueOf(accountDto.getAccountType()));
        return account;
    }
}
