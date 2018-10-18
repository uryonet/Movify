package com.uryonet.movify.presenter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.uryonet.movify.R;
import com.uryonet.movify.model.entity.Project;
import com.uryonet.movify.presenter.contract.MainContract;
import com.uryonet.movify.presenter.presenter.MainPresenter;
import com.uryonet.movify.presenter.view.adapter.ProjectsAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.rvProjects)
    RecyclerView rvProjects;

    private String TAG = "MainActivity";
    RecyclerView.Adapter adapter;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupMVP();
        setupViews();
        getProjectList();
    }

    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }

    private void setupViews() {
        rvProjects.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getProjectList() {
        mainPresenter.getProjects();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayProjects(List<Project> projectList) {
        if(projectList != null) {
            Log.d(TAG, projectList.get(1).getFull_name());
            adapter = new ProjectsAdapter(projectList, MainActivity.this);
            rvProjects.setAdapter(adapter);
        } else {
            Log.d(TAG, "Projects response null");
        }
    }

    @Override
    public void displayError(String e) {
        showToast(e);
    }
}
