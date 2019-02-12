package hellospringcloud.ratingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private BookServiceFeignClient bookService;

    @GetMapping("")
    public List<RatedBook> findAllRatings() {
        Random rnd = new Random();
        return bookService.findAllBooks()
                .stream()
                .map(b->new RatedBook(b, rnd.nextInt(100)))
                .collect(Collectors.toList());
    }
}
