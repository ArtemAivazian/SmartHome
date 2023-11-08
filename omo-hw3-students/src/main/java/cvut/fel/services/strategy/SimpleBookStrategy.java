package cvut.fel.services.strategy;

import cvut.fel.dao.BookRepository;
import cvut.fel.facade.BookFacadeImpl;
import cvut.fel.facade.dto.BookDto;
import cvut.fel.model.Book;
import cvut.fel.services.BookServiceImpl;

public class SimpleBookStrategy implements BookStrategy{
    //todo implement
    private BookServiceImpl bookService = new BookServiceImpl();
    private BookRepository bookRepository = new BookRepository();

    public SimpleBookStrategy() {
    }
    @Override
    public Book update(Book book) {
        bookService.setBookStrategy(this);
        //-update - najde objekt a udela aktualizaci
        return bookRepository.update(book);
    }
}
