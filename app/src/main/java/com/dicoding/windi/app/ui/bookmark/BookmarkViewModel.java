package com.dicoding.windi.app.ui.bookmark;

import androidx.lifecycle.ViewModel;

import com.dicoding.windi.app.data.CourseEntity;
import com.dicoding.windi.app.utils.DataDummy;

import java.util.List;

public class BookmarkViewModel extends ViewModel {
    public List<CourseEntity> getBookmarks() {
        return DataDummy.generateDummyCourses();
    }
}
