package hellospringcloud.ratingservice;

import hellospringcloud.bookservice.Book;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class BookServiceFallback implements BookServiceFeignClient {

    private CacheManager cacheManager;

    public BookServiceFallback(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public List<Book> findAllBooks() {
        ConcurrentMapCache booksCache = (ConcurrentMapCache)cacheManager.getCache("books");

        if(booksCache == null)
            return new ArrayList<>();

        ConcurrentMap<Object, Object> cachedMap = booksCache.getNativeCache();
        List<Book> books = (List<Book>) cachedMap.get("books");

        return books;
    }

    @Override
    public Book findBook(Long bookId) {
        return null;
    }
}
