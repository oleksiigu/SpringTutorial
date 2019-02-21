package hellospringcloud.ratingservice;

import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class BookServiceFallbackFactory implements FallbackFactory<BookServiceFeignClient> {

    @Autowired
    private CacheManager cacheManager;

    @Override
    public BookServiceFeignClient create(Throwable throwable) {
        return new BookServiceFallback(cacheManager);
    }
}
