package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Банковские переводы.[#193241]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 12.12.2019
 */
public class Bank {
    Map<User, List<Account>> users = new HashMap();

    public Map<User, List<Account>> getUsers() {
        return users;
    }

    /**
     * Добавляет нового User в список users.
     * @param user новый пользователь.
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<Account>());
    }
    /**
     * Удаляет User из списка users.
     * @param user пользователь.
     */
    public void deleteUser(User user) {
        users.remove(user);
    }

    /**
     * Находит пользователя по пасспорту.
     * @param passport идитефикатор пользователя.
     * @return user пользователя.
     */
    public User findUser(String passport) {
        User result = null;
        for (Map.Entry<User, List<Account>> user : this.users.entrySet()) {
            if (user.getKey().getPassport() == passport) {
                result = user.getKey();
                break;
            }
        }
        return result;
    }

    /**
     * Добавляет новый счет пользователю.
     * @param passport идитефикатор пользователя.
     * @param account новый счет для пользователя.
     */
    public void addAccountToUser(String passport, Account account) {
        this.users.get(findUser(passport)).add(account);
//        User find = null;
//        for (Map.Entry<User, List<Account>> user : this.users.entrySet()) {
//            if (user.getKey().getPassport() == passport) {
//                find = user.getKey();
//                break;
//            }
//        }
//        List accounts = this.users.get(findUser(passport));
//        if (accounts != null && accounts.indexOf(account) == -1) {
//            accounts.add(account);
//        }
    }

    /**
     * Удаляет счет пользователю.
     * @param passport идитефикатор пользователя.
     * @param account счет для удаления у пользователя.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.users.get(findUser(passport)).remove(account);
//        List accounts = this.users.get(findUser(passport));
//        if (accounts != null) {
//           // accounts.remove(account);
        //}
    }

    /**
     * Список счетов у пользователя.
     * @param passport идитефикатор пользователя.
     * @return возвращает список счетов пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        List accounts = this.users.get(findUser(passport));
        return accounts;
    }

    /**
     * Возвращает актуальный счет.
     * @param passport идитефикатор пользователя.
     * @param requisite идитефикатор счета.
     * @return возвращает найденый счет
     */
    public Account getActualAccount(String passport, String requisite) {
        List<Account> list = this.users.get(findUser(passport));
        Account req = null;
        for (Account account: list) {
            if (account.getRequisites().contains(requisite)) {
                req = account;
                break;
            }
        }
        int index = 0;
        Account result = null;
        if (list == null) {
            index = -1;
        } else {
            index = list.indexOf(req);
        }
        if (index != -1) {
            result = list.get(index);
        }
        return result;
    }

    /**
     * Перечисляет деньги с одного счёта на другой счёт.
     * @param srcPassport идитефикатор пользователя отправителя
     * @param srcRequisite идитефикатор счета отправителя
     * @param destPassport идитефикатор пользователя получателя.
     * @param dstRequisite идитефикатор счета получателя.
     * @return возвращает true если перевод удался.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
         boolean result = getActualAccount(srcPassport, srcRequisite).transfer(
                getActualAccount(destPassport, dstRequisite), amount);
        return result;
    }
}
