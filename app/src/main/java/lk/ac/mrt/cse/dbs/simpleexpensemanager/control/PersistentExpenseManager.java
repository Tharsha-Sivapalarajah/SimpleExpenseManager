package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.control.exception.ExpenseManagerException;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentMemoryAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentMemoryTransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.DatabaseHelper;
import android.content.Context;


public class PersistentExpenseManager extends ExpenseManager {

    private DatabaseHelper databaseHelper;

    public PersistentExpenseManager(Context context) {

        super(context);
        this.databaseHelper = new DatabaseHelper(context);
        setup();
    }

    @Override
    public void setup() {
        TransactionDAO persistentMemoryTransactionDAO = new PersistentMemoryTransactionDAO( databaseHelper );
        setTransactionsDAO( persistentMemoryTransactionDAO );

        AccountDAO persistentMemoryAccountDAO = new PersistentMemoryAccountDAO( databaseHelper );
        setAccountsDAO( persistentMemoryAccountDAO );

    }
}
