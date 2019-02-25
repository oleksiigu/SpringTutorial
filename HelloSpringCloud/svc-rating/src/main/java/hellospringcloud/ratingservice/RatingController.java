package hellospringcloud.ratingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    private Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookServiceWrapper bookService;

    @GetMapping("")
    public List<RatedBook> findAllRatings() {

        return ratingService.findAllRatings();
    }
}
