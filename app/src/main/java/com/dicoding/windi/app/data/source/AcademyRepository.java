package com.dicoding.windi.app.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dicoding.windi.app.data.ContentEntity;
import com.dicoding.windi.app.data.CourseEntity;
import com.dicoding.windi.app.data.ModuleEntity;
import com.dicoding.windi.app.data.source.remote.RemoteDataSource;
import com.dicoding.windi.app.data.source.remote.response.CourseResponse;
import com.dicoding.windi.app.data.source.remote.response.ModuleResponse;

import java.util.ArrayList;
import java.util.List;

public class AcademyRepository implements  AcademyDataSource  {
    private volatile static AcademyRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;
    private AcademyRepository(@NonNull RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }
    public static AcademyRepository getInstance(RemoteDataSource remoteData) {
        if (INSTANCE == null) {
            synchronized (AcademyRepository.class) {
                INSTANCE = new AcademyRepository(remoteData);
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<CourseEntity>> getAllCourses() {
        MutableLiveData<List<CourseEntity>> courseResults = new MutableLiveData<>();
        remoteDataSource.getAllCourses(courseResponses -> {
            ArrayList<CourseEntity> courseList = new ArrayList<>();
            for (CourseResponse response : courseResponses) {
                CourseEntity course = new CourseEntity(response.getId(),
                        response.getTitle(),
                        response.getDescription(),
                        response.getDate(),
                        false,
                        response.getImagePath());

                courseList.add(course);
            }
            courseResults.postValue(courseList);
        });

        return courseResults;
    }

    @Override
    public LiveData<CourseEntity> getCourseWithModules(final String courseId) {
        MutableLiveData<CourseEntity> courseResult = new MutableLiveData<>();

        remoteDataSource.getAllCourses(courseResponses -> {
            CourseEntity course = null;
            for (CourseResponse response : courseResponses) {
                if (response.getId().equals(courseId)) {
                    course = new CourseEntity(response.getId(),
                            response.getTitle(),
                            response.getDescription(),
                            response.getDate(),
                            false,
                            response.getImagePath());
                }
            }
            courseResult.postValue(course);
        });
        return courseResult;
    }

    @Override
    public LiveData<List<ModuleEntity>> getAllModulesByCourse(String courseId) {
        MutableLiveData<List<ModuleEntity>> moduleResults = new MutableLiveData<>();
        remoteDataSource.getModules(courseId, moduleResponses -> {
            ArrayList<ModuleEntity> moduleList = new ArrayList<>();
            for (ModuleResponse response : moduleResponses) {
                ModuleEntity course = new ModuleEntity(response.getModuleId(),
                        response.getCourseId(),
                        response.getTitle(),
                        response.getPosition(),
                        false);

                moduleList.add(course);
            }
            moduleResults.postValue(moduleList);
        });

        return moduleResults;
    }

    @Override
    public LiveData<List<CourseEntity>> getBookmarkedCourses() {
        MutableLiveData<List<CourseEntity>> courseResults = new MutableLiveData<>();
        remoteDataSource.getAllCourses(courseResponses -> {
            ArrayList<CourseEntity> courseList = new ArrayList<>();
            for (CourseResponse response : courseResponses) {
                CourseEntity course = new CourseEntity(response.getId(),
                        response.getTitle(),
                        response.getDescription(),
                        response.getDate(),
                        false,
                        response.getImagePath());
                courseList.add(course);
            }
            courseResults.postValue(courseList);
        });
        return courseResults;
    }

    @Override
    public LiveData<ModuleEntity> getContent(String courseId, String moduleId) {
        MutableLiveData<ModuleEntity> moduleResult = new MutableLiveData<>();
        remoteDataSource.getModules(courseId, moduleResponses -> {
            ModuleEntity module;
            for (ModuleResponse response : moduleResponses) {
                if (response.getModuleId().equals(moduleId)) {
                    module = new ModuleEntity(response.getModuleId(),
                            response.getCourseId(),
                            response.getTitle(),
                            response.getPosition(),
                            false);
                    remoteDataSource.getContent(moduleId, contentResponse -> {
                        module.contentEntity = new ContentEntity(contentResponse.getContent());
                        moduleResult.postValue(module);
                    });
                    break;
                }
            }
        });
        return moduleResult;
    }
}
