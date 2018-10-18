package com.uryonet.movify.presenter.contract;

import com.uryonet.movify.model.entity.Project;

import java.util.List;

public interface MainContract {

    interface View {

        void showToast(String s);
        void displayProjects(List<Project> projectList);
        void displayError(String s);

    }

    interface Presenter {

        void getProjects();

    }

}
