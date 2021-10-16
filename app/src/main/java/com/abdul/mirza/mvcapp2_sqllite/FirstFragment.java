package com.abdul.mirza.mvcapp2_sqllite;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abdul.mirza.mvcapp2_sqllite.Controller.MainController;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Profile;
import com.abdul.mirza.mvcapp2_sqllite.View.IMainView;
import com.abdul.mirza.mvcapp2_sqllite.View.OnNotifyChild;
import com.abdul.mirza.mvcapp2_sqllite.databinding.FragmentFirstBinding;

import java.util.List;

public class FirstFragment extends Fragment implements IMainView, OnNotifyChild,RecyclerViewItemSelectedListener<Profile> {
    private final String TAG = "FIRST_GRAGMENT";

    private FragmentFirstBinding binding;
    MainController mainController;

    TextView tv;
    RecyclerView rv;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        mainController = new MainController(this, getActivity());

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv = binding.tv;
        rv = binding.rv;

        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rv.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void updateUI(List<Profile> items, String text, boolean showSurnames) {
        tv.setText(text);
        onRecyclerViewUpdate(items, showSurnames);
    }

    @Override
    public void onRecyclerViewUpdate( List<Profile> items, boolean showSurnames) {
        if(rv.getAdapter() != null) {
            ProfileRecyclerViewAdapter adapter = (ProfileRecyclerViewAdapter) rv.getAdapter();
            adapter.setShowDataNames(showSurnames);
            adapter.setData(items);
            adapter.notifyDataSetChanged();
        } else {
            rv.setAdapter(new ProfileRecyclerViewAdapter(this, items, true));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Activity activity = getActivity();
        ((MainActivity) activity).fab.show();
        mainController.onSetup();
    }

    @Override
    public void itemSelected(Profile item) {
        Bundle bundle = new Bundle();
        bundle.putInt("PROFILE_ID", item.getId());

        Activity activity = getActivity();
        ((MainActivity) activity).fab.hide();
        NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_toggle_display_mode) {
            mainController.changeState();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNotify() {
        mainController.onSetup();
    }
}