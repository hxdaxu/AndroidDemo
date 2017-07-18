package com.hqc.demo.preferencedemo;


import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.app.ActionBar;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hqc.demo.R;
import com.hqc.demo.utils.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class SettingsActivity extends PreferenceActivity implements Preference.OnPreferenceClickListener {

    private static final String TAG = "SettingsActivity";
    private static final String CHECKBOX_PREFERENCE_KEY = "checkbox";
    private static final String RADIO_PREFERENCE_KEY = "radio_pref";
    private static final String RADIO_PREFERENCE2_KEY = "radio_pref2";

    private CheckBoxPreference checkBox;
    private RadioPreference radio_pref;
    private RadioPreference2 radio_pref2;
//    RadioButton
//    RadioGroup


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        checkBox = (CheckBoxPreference) findPreference(CHECKBOX_PREFERENCE_KEY);
        checkBox.setOnPreferenceClickListener(this);

        radio_pref = (RadioPreference) findPreference(RADIO_PREFERENCE_KEY);
        radio_pref.setOnPreferenceClickListener(this);

        radio_pref2 = (RadioPreference2) findPreference(RADIO_PREFERENCE2_KEY);
        radio_pref2.setOnPreferenceClickListener(this);

        Notification.Builder builder = new Notification.Builder(this);
//        builder.addAction()
//        builder.setContentIntent()

        ImageView iv = new ImageView(this);
//        iv.setR

//        HashMap<Object,Integer> map = new HashMap<>();
//        ArrayList<Object> list = new ArrayList<Object>();
//        for (Object o : list){
//
//        }
////        map.
//
//        for(String s : map.keySet()){
////            map.keySet().c
//        }


    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        Log.d(TAG,"onPreferenceClick! id = "+preference.getKey());

        switch (preference.getKey()){
            case RADIO_PREFERENCE_KEY:
                Log.d(TAG,"radio onClicked !");
                break;
            case RADIO_PREFERENCE2_KEY:
                Log.d(TAG,"radio2 onClicked !");
                radio_pref2.setChecked(!radio_pref2.isChecked());
                break;

            default:
                break;
        }
        return false;
    }
}
