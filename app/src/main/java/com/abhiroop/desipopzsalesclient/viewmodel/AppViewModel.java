package com.abhiroop.desipopzsalesclient.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.abhiroop.desipopzsalesclient.repository.LocalRepository;

public class AppViewModel extends AndroidViewModel {

    private LocalRepository mLocalRepository;

    public AppViewModel(@NonNull Application application) {
        super(application);
        mLocalRepository = new LocalRepository();
    }
}
