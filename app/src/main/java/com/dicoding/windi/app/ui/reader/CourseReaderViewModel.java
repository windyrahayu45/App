package com.dicoding.windi.app.ui.reader;

import androidx.lifecycle.ViewModel;

import com.dicoding.windi.app.data.ContentEntity;
import com.dicoding.windi.app.data.ModuleEntity;
import com.dicoding.windi.app.utils.DataDummy;

import java.util.ArrayList;

public class CourseReaderViewModel extends ViewModel {

    private String courseId;
    private String moduleId;

    public void setSelectedCourse(String courseId) {
        this.courseId = courseId;
    }

    public void setSelectedModule(String moduleId) {
        this.moduleId = moduleId;
    }

    public ArrayList<ModuleEntity> getModules() {
        return (ArrayList<ModuleEntity>) DataDummy.generateDummyModules(courseId);
    }

    public ModuleEntity getSelectedModule() {
        ModuleEntity module = null;
        ArrayList<ModuleEntity> moduleEntities = getModules();
        for (ModuleEntity moduleEntity: moduleEntities) {
            if (moduleEntity.getModuleId().equals(moduleId)) {
                module = moduleEntity;
                module.contentEntity = new ContentEntity("<h3 class=\\\"fr-text-bordered\\\">" + module.getTitle() + "</h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>");
                break;
            }
        }
        return module;
    }
}
