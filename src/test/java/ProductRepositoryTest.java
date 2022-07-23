import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Book book1 = new Book(1, "Fox in forest", 250, "Anna");
    Book book2 = new Book(2, "Travel Fox ", 400, "Mark");
    Smartphone smartphone1 = new Smartphone(3, "Honor 50S", 14500, "China");
    Book book3 = new Book(4, "Mark and Fox in forest", 300, "Spider");
    Smartphone smartphone2 = new Smartphone(5, "Honor 10 PRO", 24500, "China");
    Book book4 = new Book(6, "Red and black", 200, "Anna");
    Smartphone smartphone3 = new Smartphone(7, "Honor", 10000, "China");

    @Test
    public void souldNotFoundExceptionIdAbsent() {
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone1);
        repository.add(book3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeId(56);
        });
    }

    @Test
    public void souldRemoveId() {
        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone1);
        repository.add(book3);
        repository.removeId(book1.getId());


        Product[] expented = {book2, smartphone1, book3};
        Product[] actual = repository.getProducts();

        Assertions.assertArrayEquals(expented, actual);
    }
}
