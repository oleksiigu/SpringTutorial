package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.BookController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RatingService {
    private Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookServiceFeignClient bookService;

    public List<RatedBook> findAllRatings(){
        log.info("findAllRatings");
        Random rnd = new Random();
        List<RatedBook> books = bookService.findAllBooks()
                .stream()
                .map(b->new RatedBook(b, rnd.nextInt(100)))
                .collect(Collectors.toList());

        return books;
    }
}
