package hellospring.lesson008;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class HelloBean {

    @Autowired
    private CachedBean cached;

    void run() {
        System.out.println(cached.getStrCached("str1"));
        System.out.println(cached.getStrCached("str2"));
        System.out.println(cached.getStrCached("str1"));
        System.out.println(cached.getStrCached("str2"));

        System.out.println("Update cache for str 1");
        System.out.println(cached.getStrUpdateCache("str1"));
        System.out.println(cached.getStrCached("str1"));


        System.out.println("2*3="+cached.mul(2, 3));
        System.out.println("2*4="+cached.mul(2, 4));
        System.out.println("2*3="+cached.mul(2, 3));

        cached.clearCache();
        System.out.println(cached.getStrCached("str1"));
        System.out.println(cached.getStrCached("str1"));

        System.out.println("2*3="+cached.mul(2, 3));
    }
}
