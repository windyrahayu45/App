package com.dicoding.windi.app.ui.academy;

import androidx.lifecycle.ViewModel;

import com.dicoding.windi.app.data.CourseEntity;
import com.dicoding.windi.app.utils.DataDummy;

import java.util.List;

public class AcademyViewModel extends ViewModel {

    public List<CourseEntity> getCourses() {
        return DataDummy.generateDummyCourses();
    }
}