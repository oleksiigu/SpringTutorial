package hellospring.lesson008;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableCaching
class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        // Use guava cache manager for more configuration options
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("strs"),
                new ConcurrentMapCache("mul")
        ));
        return cacheManager;
    }
}
