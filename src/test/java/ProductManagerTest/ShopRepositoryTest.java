package ProductManagerTest;

import ProductManager.NotFoundException;
import ProductManager.Product;
import ProductManager.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void removeWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 50_000);
        Product product2 = new Product(2, "журнал", 300);
        Product product3 = new Product(3, "квартира", 15_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 50_000);
        Product product2 = new Product(2, "журнал", 300);
        Product product3 = new Product(3, "квартира", 15_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class,
                ()-> repo.remove(24777)
        );
    }

}
