package com.dicoding.windi.app.ui.academy;

import com.dicoding.windi.app.data.CourseEntity;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class AcademyViewModelTest {
    private AcademyViewModel viewModel;
    @Before
    public void setUp() {
        viewModel = new AcademyViewModel();
    }

    @Test
    public void getCourses() {
        List<CourseEntity> courseEntities = viewModel.getCourses();
        assertNotNull(courseEntities);
        assertEquals(5, courseEntities.size());
    }
}
