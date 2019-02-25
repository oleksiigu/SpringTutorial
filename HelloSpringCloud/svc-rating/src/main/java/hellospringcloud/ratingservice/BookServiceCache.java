package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BookServiceCache {

    @Cacheable("books")
    public List<Book> getBooks(){
        return Arrays.asList();
    }
}
