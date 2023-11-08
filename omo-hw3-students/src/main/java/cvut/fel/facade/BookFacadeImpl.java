package cvut.fel.facade;

import cvut.fel.facade.dto.BookDto;
import cvut.fel.facade.mapper.BookMapper;
import cvut.fel.model.Book;
import cvut.fel.services.AuthorServiceImpl;
import cvut.fel.services.BookServiceImpl;
import cvut.fel.services.LibraryServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BookFacadeImpl {
    //todo implement
    private BookServiceImpl bookService = new BookServiceImpl();
    private AuthorServiceImpl authorService = new AuthorServiceImpl();
    private LibraryServiceImpl libraryService = new LibraryServiceImpl();

    public BookFacadeImpl() {
    }

    //my method
    public List<BookDto> getAll() {
        List<BookDto> bookDtoList = new ArrayList<>();
        int counter = 1;
        while (true){
            try {
                Book b = bookService.getByBookId(counter);
                bookDtoList.add(BookMapper.toDto(
                        b,
                        authorService.getByBookId(b.getId()),
                        libraryService.getByBookId(b.getId())
                ));
            } catch (Exception e) {
                break;
            }
            counter++;
        }
        return bookDtoList;
    }

    public BookDto getByBookId(int id) {
        return BookMapper.toDto(
                this.bookService.getByBookId(id),
                this.authorService.getByBookId(id),
                this.libraryService.getByBookId(id)
        );
    }
}
