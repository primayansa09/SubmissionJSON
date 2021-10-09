package com.example.submissiongithub2;

import android.preference.Preference;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.rxjava3.RxDataStore;

import java.util.function.Predicate;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public class SettingPreferences {
    private final Preferences.Key<Boolean> THEME_KEY = PreferencesKeys.booleanKey("theme_setting");
    private final RxDataStore<Preferences> dataStore;

    private SettingPreferences(RxDataStore<Preferences> dataStore){
        this.dataStore = dataStore;
    }

    private static volatile SettingPreferences INSTANCE;

    static SettingPreferences getInstance(final RxDataStore<Preferences> dataStore){
        if (INSTANCE == null){
            synchronized (SettingPreferences.class){
                if (INSTANCE == null){
                    INSTANCE = new SettingPreferences(dataStore);
                }
            }
        }
        return INSTANCE;
    }

    public Flowable<Boolean> getThemeSetting(){
        return dataStore.data().map(preferences -> {
            if (preferences.get(THEME_KEY) != null){
                return preferences.get(THEME_KEY);
            }else {
                return false;
            }
        });
    }

    public void savedThemeSetting(Boolean isDarkModeActivity){
        dataStore.updateDataAsync(preferences -> {
            MutablePreferences mutablePreferences = preferences.toMutablePreferences();
            mutablePreferences.set(THEME_KEY, isDarkModeActivity);
            return Single.just(mutablePreferences);
        });
    }
}
