package ru.job4j.pojo;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * 3. Удаление моделей из массива.[#193324]
 * @author Andrey Markushin
 * @version 4.0
 * @since 27.11.2019
 */
public class ShopTest {

    @Test
    public void delete() {
        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 4);
        Product egg = new Product("Egg", 19);

        Product[] products1 = new Product[3];
        products1[0] = milk;
        products1[1] = bread;
        products1[2] = egg;

        Product[] products2 = new Product[3];
        products2[0] = milk;
        products2[1] = bread;
        Shop delete = new Shop();
        delete.delete(products1, 2);

        assertThat(products1, is(products2));
    }
}
