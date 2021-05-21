package com.dicoding.windi.app.ui.bookmark;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dicoding.windi.app.data.CourseEntity;
import com.dicoding.windi.app.data.source.AcademyRepository;
import com.dicoding.windi.app.utils.DataDummy;

import java.util.List;

public class BookmarkViewModel extends ViewModel {
//    public List<CourseEntity> getBookmarks() {
//        return DataDummy.generateDummyCourses();
//    }

    private AcademyRepository academyRepository;
    public BookmarkViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

//    List<CourseEntity> getBookmarks() {
//        return academyRepository.getBookmarkedCourses();
//    }

    public LiveData<List<CourseEntity>> getBookmarks() {
        return academyRepository.getBookmarkedCourses();
    }
}
