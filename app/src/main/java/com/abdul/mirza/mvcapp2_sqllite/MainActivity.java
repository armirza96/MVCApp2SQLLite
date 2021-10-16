package com.abdul.mirza.mvcapp2_sqllite;

import android.app.Activity;
import android.os.Bundle;

import com.abdul.mirza.mvcapp2_sqllite.View.OnNotifyChild;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.abdul.mirza.mvcapp2_sqllite.View.OnNotifyParent;
import com.abdul.mirza.mvcapp2_sqllite.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnNotifyParent {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    OnNotifyChild listener;

    public FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main);
        OnNotifyChild fragment = (OnNotifyChild) navHostFragment.getChildFragmentManager().getFragments().get(0);

        listener = fragment;
        fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                FragmentManager fm = getSupportFragmentManager();
                MyDialogFragment frag = new MyDialogFragment();
                frag.show(fm, "FRAG_DIALOG");
                Activity activity = MainActivity.this;
                if(activity instanceof OnNotifyParent) {
                    frag.setListener( (OnNotifyParent) activity);
                }
            }
        });


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onNotify() {
        listener.onNotify();
    }
}