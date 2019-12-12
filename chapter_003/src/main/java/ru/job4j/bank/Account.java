package ru.job4j.bank;

/**
 * Банковские переводы.[#193241]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 12.12.2019
 */
public class Account {
    private int value;
    private String requisites;

    public Account(int value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public int getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    /**
     * Переводит деньги другому пользователю.
     * @param destination счет получателя.
     * @param amount сумма отправления.
     * @return true если перевод удался.
     */
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount <= this.value && destination != null) {
            success = true;
            this.value -= amount;
            destination.value += amount;
        }
        return success;
    }
}
