package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.Book;

import java.util.Arrays;
import java.util.List;

public class BookServiceFallback implements BookServiceFeignClient {
    @Override
    public List<Book> findAllBooks() {
        return Arrays.asList();
    }

    @Override
    public Book findBook(Long bookId) {
        return null;
    }
}
