package com.dicoding.windi.app.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.windi.app.data.CourseEntity;
import com.dicoding.windi.app.data.ModuleEntity;
import com.dicoding.windi.app.data.source.AcademyRepository;
import com.dicoding.windi.app.utils.DataDummy;

import java.util.ArrayList;
import java.util.List;

public class DetailCourseViewModel extends ViewModel {
//    private String courseId;
//
//    public void setSelectedCourse(String courseId) {
//        this.courseId = courseId;
//    }
//
//    public CourseEntity getCourse() {
//        CourseEntity course = null;
//        List<CourseEntity> courseEntities = DataDummy.generateDummyCourses();
//        for (CourseEntity courseEntity : courseEntities) {
//            if (courseEntity.getCourseId().equals(courseId)) {
//                course = courseEntity;
//            }
//        }
//        return course;
//    }
//
//    public List<ModuleEntity> getModules() {
//        return DataDummy.generateDummyModules(courseId);
//    }


    private String courseId;
    private AcademyRepository academyRepository;
    public DetailCourseViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public void setSelectedCourse(String courseId) {
        this.courseId = courseId;
    }

//    public CourseEntity getCourse() {
//        return academyRepository.getCourseWithModules(courseId);
//    }
//
//    public List<ModuleEntity> getModules() {
//        return academyRepository.getAllModulesByCourse(courseId);
//    }
public LiveData<CourseEntity> getCourse() {
    return academyRepository.getCourseWithModules(courseId);
}

    public LiveData<List<ModuleEntity>> getModules() {
        return academyRepository.getAllModulesByCourse(courseId);
    }
}
