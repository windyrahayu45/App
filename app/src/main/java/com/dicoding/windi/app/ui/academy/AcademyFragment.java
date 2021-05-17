package com.dicoding.windi.app.ui.academy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dicoding.windi.app.R;
import com.dicoding.windi.app.data.CourseEntity;
import com.dicoding.windi.app.databinding.FragmentAcademyBinding;
import com.dicoding.windi.app.utils.DataDummy;

import java.util.List;


public class AcademyFragment extends Fragment {
    private FragmentAcademyBinding fragmentAcademyBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        fragmentAcademyBinding = FragmentAcademyBinding.inflate(inflater, container, false);
        return fragmentAcademyBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {

            AcademyViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(AcademyViewModel.class);
            List<CourseEntity> courses = viewModel.getCourses();
            //List<CourseEntity> courses = DataDummy.generateDummyCourses();
            AcademyAdapter academyAdapter = new AcademyAdapter();
            academyAdapter.setCourses(courses);
            fragmentAcademyBinding.rvAcademy.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentAcademyBinding.rvAcademy.setHasFixedSize(true);
            fragmentAcademyBinding.rvAcademy.setAdapter(academyAdapter);
        }
    }
}