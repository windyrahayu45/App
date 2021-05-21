package com.dicoding.windi.app.data.source.remote;

import android.os.Handler;
import android.os.Looper;

import com.dicoding.windi.app.data.source.remote.response.ContentResponse;
import com.dicoding.windi.app.data.source.remote.response.CourseResponse;
import com.dicoding.windi.app.data.source.remote.response.ModuleResponse;
import com.dicoding.windi.app.utils.JsonHelper;

import java.util.List;

public class RemoteDataSource {
    private static RemoteDataSource INSTANCE;
    private JsonHelper jsonHelper;
    private Handler handler = new Handler(Looper.getMainLooper());
    private final long SERVICE_LATENCY_IN_MILLIS = 1000;

    private RemoteDataSource(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteDataSource getInstance(JsonHelper helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(helper);
        }
        return INSTANCE;
    }

//    public List<CourseResponse> getAllCourses() {
//        return jsonHelper.loadCourses();
//    }
//
//    public List<ModuleResponse> getModules(String courseId) {
//        return jsonHelper.loadModule(courseId);
//    }
//
//    public ContentResponse getContent(String moduleId) {
//        return jsonHelper.loadContent(moduleId);
//    }

    public void getAllCourses(LoadCoursesCallback callback) {
        handler.postDelayed(()-> callback.onAllCoursesReceived(jsonHelper.loadCourses()), SERVICE_LATENCY_IN_MILLIS);
    }

    public void getModules(String courseId, LoadModulesCallback callback) {
        handler.postDelayed(()-> callback.onAllModulesReceived(jsonHelper.loadModule(courseId)), SERVICE_LATENCY_IN_MILLIS);
    }

    public void getContent(String moduleId, LoadContentCallback callback) {
        handler.postDelayed(()-> callback.onContentReceived(jsonHelper.loadContent(moduleId)), SERVICE_LATENCY_IN_MILLIS);
    }

    public interface LoadCoursesCallback {
        void onAllCoursesReceived(List<CourseResponse> courseResponses);
    }
    public interface LoadModulesCallback {
        void onAllModulesReceived(List<ModuleResponse> moduleResponses);
    }
    public interface LoadContentCallback {
        void onContentReceived(ContentResponse contentResponse);
    }
}
