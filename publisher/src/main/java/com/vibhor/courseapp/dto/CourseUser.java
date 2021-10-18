package com.vibhor.courseapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseUser {
    private Course course;
    private boolean likes;
    private boolean dislikes;
    private String rating;

}
