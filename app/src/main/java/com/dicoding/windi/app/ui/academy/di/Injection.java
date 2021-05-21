package com.dicoding.windi.app.ui.academy.di;

import android.content.Context;

import com.dicoding.windi.app.data.source.AcademyRepository;
import com.dicoding.windi.app.data.source.remote.RemoteDataSource;
import com.dicoding.windi.app.utils.JsonHelper;

public class Injection {
    public static AcademyRepository provideRepository(Context context) {

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));

        return AcademyRepository.getInstance(remoteDataSource);
    }
}
