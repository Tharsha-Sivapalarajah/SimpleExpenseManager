/*
 * Copyright 2015 Department of Computer Science and Engineering, University of Moratuwa.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *                  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package lk.ac.mrt.cse.dbs.simpleexpensemanager;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.control.ExpenseManager;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.control.PersistentExpenseManager;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

public class ApplicationTest {

    private ExpenseManager expenseManager;

    private static final Account SampleAccount1 = new Account("TH-6666", "BOC", "S.Tharsha", 70000.00);
    private static final Account SampleAccount2 = new Account("TN-5454", "HNB", "T.Nigitha", 5000.00 );


    @Before
    public void BeforeTestSetUp() {

        Context context = ApplicationProvider.getApplicationContext();
        assertEquals("lk.ac.mrt.cse.dbs.simpleexpensemanager", context.getPackageName());
        expenseManager = new PersistentExpenseManager(context);
    }


    @Test
    public void AddAccountTest() {

        expenseManager.addAccount(SampleAccount1.getAccountNo(), SampleAccount1.getBankName(), SampleAccount1.getAccountHolderName(), SampleAccount1.getBalance());
        expenseManager.addAccount(SampleAccount2.getAccountNo(), SampleAccount2.getBankName(), SampleAccount2.getAccountHolderName(), SampleAccount2.getBalance());


        List<String> AccountNumbersList = expenseManager.getAccountNumbersList();

        assertTrue( AccountNumbersList.contains(SampleAccount1.getAccountNo()) );
        assertTrue( AccountNumbersList.contains(SampleAccount2.getAccountNo()) );

    }
}