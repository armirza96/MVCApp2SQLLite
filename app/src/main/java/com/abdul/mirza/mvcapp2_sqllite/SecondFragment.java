package com.abdul.mirza.mvcapp2_sqllite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abdul.mirza.mvcapp2_sqllite.Controller.ProfileController;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Access;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Profile;
import com.abdul.mirza.mvcapp2_sqllite.View.IProfileView;
import com.abdul.mirza.mvcapp2_sqllite.databinding.FragmentSecondBinding;

import java.util.List;

public class SecondFragment extends Fragment implements IProfileView {

    private FragmentSecondBinding binding;
    TextView tv_name, tv_surName, tv_studentId, tv_gpa, tv_create_date;
    RecyclerView rv;

    ProfileController controller;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        Bundle b = getArguments();
        int profileId = b.getInt("PROFILE_ID");

        controller = new ProfileController(this, getContext(), profileId);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv = binding.rv;

        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rv.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));

        tv_name = binding.tvName;
        tv_surName = binding.tvSurname;
        tv_studentId = binding.tvId;
        tv_gpa = binding.tvGpa;
        tv_create_date = binding.tvProfileCreateDate;
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.onSetup();
        controller.onCreateOpenAccess();
    }

    @Override
    public void onPause() {
        controller.onCreateClosedAccess();
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void updateUI(List<Access> items, String name, String surName, String studentId, String gpa, String createDate) {
        tv_name.setText(name);
        tv_surName.setText(surName);
        tv_studentId.setText(studentId);
        tv_gpa.setText(gpa);
        tv_create_date.setText(createDate);
        rv.setAdapter(new AccessRecyclerViewAdapter(items));

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_delete_profile) {
            controller.onCreateDeletedAccess();
            getActivity().onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

}