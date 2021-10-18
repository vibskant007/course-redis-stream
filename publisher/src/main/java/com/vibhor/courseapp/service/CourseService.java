package com.vibhor.courseapp.service;


import com.vibhor.courseapp.dto.Course;
import com.vibhor.courseapp.dto.CourseUser;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    @PostConstruct
    public void loadCourses() {
        courseList.add(new Course("0f6708c9-9703-40c8-a865-021fa799661d","course-a","A"));
        courseList.add(new Course("fa897d10-b4e3-46a4-9603-0cd681e616e5","course-b","B"));
        courseList.add(new Course("06d17946-dfe2-4f10-8828-f90c1d12d1bb","course-c","C"));
        courseList.add(new Course("6fd68be0-7bb9-48c3-8136-c7d6bbc57d71","course-d","D"));
        courseList.add(new Course("c78b3272-5977-45e0-9376-3e640695d8c7","course-e","E"));
        courseList.add(new Course("ea4606a9-56a9-4fb6-a066-bd9cfbd01ed7","course-f","F"));
        courseList.add(new Course("a8b1bf0f-92bf-406e-a51a-c8d7c5a18eea","course-g","G"));
        courseList.add(new Course("4068b12d-9bc4-48c9-b604-4c8852c221f9","course-h","H"));
    }

    public CourseUser getRandomCourseUser() {
        int random = ThreadLocalRandom.current().nextInt(0, 8);
        int rating = ThreadLocalRandom.current().nextInt(0, 5);
        Course course = courseList.get(random);
        boolean like = ThreadLocalRandom.current().nextBoolean();
        return new CourseUser(course,ThreadLocalRandom.current().nextBoolean(),!like,String.valueOf(rating));
    }


}
