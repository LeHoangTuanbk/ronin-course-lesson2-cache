package org.example.ronincourselesson2cachingreadaside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RoninCourseLesson2CachingReadAsideApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoninCourseLesson2CachingReadAsideApplication.class, args);
    }

}
