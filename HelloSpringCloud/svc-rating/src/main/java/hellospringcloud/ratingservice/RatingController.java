package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.Book;
import hellospringcloud.bookservice.BookController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    private Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookServiceFeignClient bookService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("")
    @CachePut("books")
    public List<RatedBook> findAllRatings() {
        log.info("findAllRatings");
        Random rnd = new Random();

        List<Book> books = bookService.findAllBooks();
        // saving book to cache
        cacheManager.getCache("books").putIfAbsent("books", books);

        List<RatedBook> ratedBooks = books
                .stream()
                .map(b->new RatedBook(b, rnd.nextInt(100)))
                .collect(Collectors.toList());

        return ratedBooks;
    }
}
