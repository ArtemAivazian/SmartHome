package cvut.fel;

import cvut.fel.model.Book;
import cvut.fel.services.BookServiceImpl;
import cvut.fel.services.strategy.ImutableBookStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Testy {

    BookServiceImpl bookServiceImpl = new BookServiceImpl();

    public Testy() {
    }
    @Test
    public void testStrategyImutable2() {
        String nameForTesting = "book3changed";
        this.bookServiceImpl.setBookStrategy(new ImutableBookStrategy());
        Book updatedBook = this.bookServiceImpl.updateBook(new Book(3, 3L, "book3changed"));
        Assert.assertNotEquals(3L, (long)updatedBook.getId());
    }
}
