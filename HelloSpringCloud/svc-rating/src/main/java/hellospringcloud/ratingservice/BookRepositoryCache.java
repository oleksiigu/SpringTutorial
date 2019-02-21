package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepositoryCache {

    @Cacheable("books")
    public List<Book> getBooks(){
        return Arrays.asList();
    }
}
