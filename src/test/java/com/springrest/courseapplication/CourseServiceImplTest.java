package com.springrest.courseapplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import com.springrest.courseapplication.entities.Course;
import com.springrest.courseapplication.services.CourseServiceImpl;

public class CourseServiceImplTest {

    @InjectMocks
    private CourseServiceImpl courseService;

    @Mock
    private List<Course> mockCourseList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Sample data for testing
        when(mockCourseList.size()).thenReturn(2);
        when(mockCourseList.get(0)).thenReturn(new Course(1, "Java Course", "Java Basics"));
        when(mockCourseList.get(1)).thenReturn(new Course(2, "Python Course", "Python Basics"));
    }

    
    
    
    
    @Test
    void testGetCourses() {
        List<Course> courses = courseService.getCourses();
        assertEquals(2, courses.size());
        assertEquals("Java Course", courses.get(0).getTitle());
        assertEquals("Python Course", courses.get(1).getTitle());
    }
    @Test
    void testAddCourse() {
        // Given
        Course courseToAdd = new Course(3, "JavaScript Course", "JavaScript Basics");

        // When
        courseService.addCourse(courseToAdd);

        // Then
        ArgumentCaptor<Course> courseArgumentCaptor = ArgumentCaptor.forClass(Course.class);
        verify(mockCourseList).add(courseArgumentCaptor.capture());

        Course capturedCourse = courseArgumentCaptor.getValue();
        assertThat(capturedCourse).isEqualTo(courseToAdd);
    }

//    @Test
//    void testUpdateCourse() {
//        Course updatedCourse = new Course(1, "Updated Java Course", "Updated Java Basics");
//        when(mockCourseList.indexOf(updatedCourse)).thenReturn(0);
//
//        Course result = courseService.updateCourse(updatedCourse);
//
//        assertNotNull(result);
//        assertEquals("Updated Java Course", result.getTitle());
//        assertEquals("Updated Java Basics", result.getDescription());
//    }
//
//    @Test
//    void testDeleteCourse() {
//        when(mockCourseList.remove(any())).thenReturn(true);
//
//        Course deletedCourse = courseService.deleteCourse(1);
//
//        assertNotNull(deletedCourse);
//        assertEquals(1, deletedCourse.getId());
//        assertEquals("Java Course", deletedCourse.getTitle());
//        assertEquals("Java Basics", deletedCourse.getDescription());
//    }
        


}
