package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {
    private Bank bank;
    private User user;
    private Account account;
    private User user2;
    private Account account2;

    @Test
    public void thenAddNewUserAndFindUser() {
        this.bank = new Bank();
        this.user = new User("test", "test");
        this.bank.addUser(this.user);
        Assert.assertThat(this.user, is(bank.findUser("test")));
    }

    @Before
    public void start() {
        this.bank = new Bank();
        this.user = new User("Ivan", "22222");
        this.account = new Account(100, "VTB");
        this.bank.addUser(this.user);
        this.bank.addAccountToUser(this.user.getPassport(), this.account);
        this.user2 = new User("Igor", "77777");
        this.bank.addUser(user2);
        this.account2 = new Account(50, "Sber");
        this.bank.addAccountToUser(user2.getPassport(),  this.account2);
    }

    @Test
    public void thenDeleteUser() {
        this.bank.deleteUser(this.user);
        boolean result = this.bank.getUsers().containsKey(this.user);
        assertThat(false, is(result));
    }

    @Test
    public void thenaddAccountToUserAndgetActualAccount() {
        this.account = new Account(100, "Alfa");
        this.bank.addAccountToUser(this.user.getPassport(), this.account);
        Account result = this.bank.getActualAccount("22222", "Alfa");
        assertThat(this.account, is(result));
    }

    @Test
    public void deleteAccountFromUser() {
        this.bank.deleteAccountFromUser(this.user.getPassport(), this.account);
        boolean result = this.bank.getUsers().get(this.user).contains(this.account);
        assertThat(false, is(result));
    }

    @Test
    public void whenSuccessTransfer() {
        boolean result = this.bank.transferMoney(this.user.getPassport(), this.account.getRequisites(), this.user2.getPassport(), this.account2.getRequisites(), 100);
        assertThat(true, is(result));
    }
}