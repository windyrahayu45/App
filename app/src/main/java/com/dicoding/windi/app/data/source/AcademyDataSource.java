package com.dicoding.windi.app.data.source;

import androidx.lifecycle.LiveData;

import com.dicoding.windi.app.data.CourseEntity;
import com.dicoding.windi.app.data.ModuleEntity;

import java.util.List;

public interface AcademyDataSource {
//    List<CourseEntity> getAllCourses();
//
//    CourseEntity getCourseWithModules(String courseId);
//
//    List<ModuleEntity> getAllModulesByCourse(String courseId);
//
//    List<CourseEntity> getBookmarkedCourses();
//
//    ModuleEntity getContent(String courseId, String moduleId);

    LiveData<List<CourseEntity>> getAllCourses();

    LiveData<CourseEntity> getCourseWithModules(String courseId);

    LiveData<List<ModuleEntity>> getAllModulesByCourse(String courseId);

    LiveData<List<CourseEntity>> getBookmarkedCourses();

    LiveData<ModuleEntity> getContent(String courseId, String moduleId);
}
