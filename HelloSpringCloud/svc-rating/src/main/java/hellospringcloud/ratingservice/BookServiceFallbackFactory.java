package hellospringcloud.ratingservice;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class BookServiceFallbackFactory implements FallbackFactory<BookServiceFeignClient> {

    @Override
    public BookServiceFeignClient create(Throwable throwable) {
        return new BookServiceFallback();
    }
}
