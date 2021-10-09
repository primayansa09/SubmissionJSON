package com.example.submissiongithub2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

public class SettingViewModel extends ViewModel {

    private final SettingPreferences pref;

    public SettingViewModel(SettingPreferences pref) {
        this.pref = pref;
    }

    public LiveData<Boolean> getThemeSettings(){
        return LiveDataReactiveStreams.fromPublisher(pref.getThemeSetting());
    }

    public void saveThemeSetting(Boolean isDarkModeactive){
        pref.savedThemeSetting(isDarkModeactive);
    }
    
}
