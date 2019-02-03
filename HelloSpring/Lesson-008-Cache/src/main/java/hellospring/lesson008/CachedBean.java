package hellospring.lesson008;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
class CachedBean {
    @Cacheable("strs")
    public String getStrCached(String key) {
        return getStr(key);
    }

    @CachePut(value="strs")
    public String getStrUpdateCache(String key) {
        return getStr(key);
    }

    @CacheEvict(value={"strs", "mul"}, allEntries=true)
    public void clearCache() {
        System.out.println("clearCache");
    }

    private String getStr(String key) {
        System.out.println("getStr "+key);
        return key+" value";
    }

    @Cacheable("mul")
    public int mul(int a, int b) {
        System.out.println(String.format("mul %d %d", a, b));
        return a * b;
    }
}
