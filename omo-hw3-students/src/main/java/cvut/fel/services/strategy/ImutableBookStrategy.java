package cvut.fel.services.strategy;

import cvut.fel.dao.BookRepository;
import cvut.fel.model.Book;
import cvut.fel.services.BookServiceImpl;

public class ImutableBookStrategy implements BookStrategy{
    private BookServiceImpl bookService = new BookServiceImpl();

    public ImutableBookStrategy() {
    }

    //todo implement
    @Override
    public Book update(Book book) {
        bookService.setBookStrategy(this);
       // vytvorit novy projekt ze stareho objektu a novych dat, které se měli aktualizovat
        Book b = bookService.getByBookId(book.getId());
        if (b == null)
            throw new RuntimeException("Book not found");
        b.incrementId();
        bookService.saveBook(b);
        return b;
    }
}
