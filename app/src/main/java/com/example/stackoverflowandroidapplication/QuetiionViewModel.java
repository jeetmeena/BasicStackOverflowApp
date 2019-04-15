package com.example.stackoverflowandroidapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

public class QuetiionViewModel extends ViewModel {
    private QusestionEntity qusestionEntity;
    private LiveData<QusestionEntity> qusestionEntityLiveData;
    private String userId;
    private QusestionEntity user;
     private StackUserRepo userRepo;
    public void init(String userId) {
        this.userId = userId;
    }


    // Instructs Dagger 2 to provide the UserRepository parameter.
    @Inject
    public QuetiionViewModel(StackUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void init(int userId) {
        if (this.user != null) {
            // ViewModel is created on a per-Fragment basis, so the userId
            // doesn't change.
            return;
        }
        //qusestionEntityLiveData = userRepo.getUser(userId);
    }


    public LiveData<QusestionEntity> getUser() {
        return this.qusestionEntityLiveData;
    }
}
