package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.Book;

import java.util.List;

public class BookServiceFallback implements BookServiceFeignClient {

    private final BookServiceCache cache;

    BookServiceFallback(BookServiceCache cache) {
        this.cache = cache;
    }

    @Override
    public List<Book> findAllBooks() {
        return cache.getBooks();
    }

    @Override
    public Book findBook(Long bookId) {
        return null;
    }
}
