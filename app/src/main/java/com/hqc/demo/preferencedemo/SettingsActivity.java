package com.hqc.demo.preferencedemo;


import android.app.Notification;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.widget.ImageView;

import com.hqc.demo.R;
import com.hqc.demo.utils.LogUtils;


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
        LogUtils.d(TAG,"onPreferenceClick! id = "+preference.getKey());

        switch (preference.getKey()){
            case RADIO_PREFERENCE_KEY:
                LogUtils.d(TAG,"radio onClicked !");
                break;
            case RADIO_PREFERENCE2_KEY:
                LogUtils.d(TAG,"radio2 onClicked !");
                radio_pref2.setChecked(!radio_pref2.isChecked());
                break;

            default:
                break;
        }
        return false;
    }
}
