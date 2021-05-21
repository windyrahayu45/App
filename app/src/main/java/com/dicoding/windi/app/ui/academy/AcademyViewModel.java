package com.dicoding.windi.app.ui.academy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.windi.app.data.CourseEntity;
import com.dicoding.windi.app.data.source.AcademyRepository;
import com.dicoding.windi.app.utils.DataDummy;

import java.util.List;

public class AcademyViewModel extends ViewModel {

    //public List<CourseEntity> getCourses() {
//        return DataDummy.generateDummyCourses();
//    }

    private AcademyRepository academyRepository;
    public AcademyViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }
//    public List<CourseEntity> getCourses() {
//        return academyRepository.getAllCourses();
//    }

    public LiveData<List<CourseEntity>> getCourses() {
        return academyRepository.getAllCourses();
    }
}