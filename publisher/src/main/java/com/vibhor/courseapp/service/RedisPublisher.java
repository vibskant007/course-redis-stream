package com.vibhor.courseapp.service;

import com.vibhor.courseapp.dto.CourseUser;
import io.cucumber.java.bs.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.data.redis.core.ReactiveRedisTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RedisPublisher {

    @Autowired
    CourseService courseService;

    @Value("${stream.key}")
    private String streamKey;

    @Autowired
    ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    private final AtomicInteger atomicInteger = new AtomicInteger();

    @Scheduled(fixedDelay = 10000)
    public void redisPublisher() {
        CourseUser courseUser= courseService.getRandomCourseUser();
        System.out.println(courseUser.getCourse().getCourseId()+ ":::" + courseUser.getRating() + "::::" + courseUser.isLikes() + "::::" + courseUser.isDislikes());
        ObjectRecord<String, CourseUser> record = StreamRecords.newRecord()
                .ofObject(courseUser)
                .withStreamKey(streamKey);

        this.reactiveRedisTemplate.opsForStream().add(record).subscribe(System.out::println);
        atomicInteger.incrementAndGet();
    }

    @Scheduled(fixedDelay = 10000)
    public void incrementAndGet(){
        System.out.println("course Events :: " + atomicInteger.get());
    }
}
