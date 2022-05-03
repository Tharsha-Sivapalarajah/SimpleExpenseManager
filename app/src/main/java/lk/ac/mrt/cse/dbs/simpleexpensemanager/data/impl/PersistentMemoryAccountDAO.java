package lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl;

import java.util.List;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.exception.InvalidAccountException;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.DatabaseHelper;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.ExpenseType;

public class PersistentMemoryAccountDAO implements AccountDAO {

    private DatabaseHelper databaseHelper;

    public PersistentMemoryAccountDAO( DatabaseHelper databaseHelper ){

        this.databaseHelper = databaseHelper;
    }

    @Override
    public List<String> getAccountNumbersList() {
        return  databaseHelper.getAccountNumbersList();
    }

    @Override
    public List<Account> getAccountsList() {
        return databaseHelper.getAccountsList();
    }

    @Override
    public Account getAccount(String accountNo) throws InvalidAccountException {
        return databaseHelper.getAccount(accountNo);
    }

    @Override
    public void addAccount(Account account) {
        databaseHelper.addAccount(account.getAccountNo(), account.getAccountHolderName(), account.getBankName(), account.getBalance());
    }

    @Override
    public void removeAccount(String accountNo) throws InvalidAccountException {
        databaseHelper.removeAccount(accountNo);
    }

    @Override
    public void updateBalance(String accountNo, ExpenseType expenseType, double amount) throws InvalidAccountException {

        databaseHelper.updateBalance(accountNo, expenseType, amount);
    }
}
