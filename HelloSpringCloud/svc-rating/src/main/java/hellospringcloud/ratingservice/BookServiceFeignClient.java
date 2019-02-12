package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.BookService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("book-service")
public interface BookServiceFeignClient extends BookService {
}
