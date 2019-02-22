package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceWrapper {

    @Autowired
    private BookServiceFeignClient bookService;

    @Cacheable(value = "books", unless = "#result.isEmpty()")
    public List<Book> findAllBooks(){
        return bookService.findAllBooks();
    }
}
