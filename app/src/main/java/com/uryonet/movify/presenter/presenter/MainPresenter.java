package com.uryonet.movify.presenter.presenter;

import android.util.Log;

import com.uryonet.movify.model.entity.Project;
import com.uryonet.movify.model.network.NetworkAPI;
import com.uryonet.movify.model.network.NetworkDatasource;
import com.uryonet.movify.presenter.contract.MainContract;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View mainContractView;
    private String TAG = "MainPresenter";

    public MainPresenter(MainContract.View mainContractView) {
        this.mainContractView = mainContractView;
    }

    @Override
    public void getProjects() {
    }

    public Observable<List<Project>> getObservable() {
        return NetworkDatasource.getRetrofit().create(NetworkAPI.class).getProjects("uryonet").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<List<Project>> getObserver() {
        return new DisposableObserver<List<Project>>() {
            @Override
            public void onNext(List<Project> projectList) {
                Log.d(TAG, "OnNext");
                mainContractView.displayProjects(projectList);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error");
                e.printStackTrace();
                mainContractView.displayError("Error fetching Project Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
            }
        };
    }
}
