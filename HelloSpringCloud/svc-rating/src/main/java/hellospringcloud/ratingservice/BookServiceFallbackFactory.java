package hellospringcloud.ratingservice;

import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookServiceFallbackFactory implements FallbackFactory<BookServiceFeignClient> {

    @Autowired
    private BookRepositoryCache cache;

    @Override
    public BookServiceFeignClient create(Throwable throwable) {
        return new BookServiceFallback(cache);
    }
}
