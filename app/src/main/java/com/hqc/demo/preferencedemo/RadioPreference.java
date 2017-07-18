package com.hqc.demo.preferencedemo;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hqc.demo.R;

public class RadioPreference extends Preference {

    private TextView title;
    private RadioButton radio;




    public RadioPreference(Context context) {
        super(context);
    }

    public RadioPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RadioPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected View onCreateView(ViewGroup parent) {

//        View view = View.inflate(getContext(), R.layout.preference_radio,parent);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.preference_radio,parent,false);
        title = (TextView) view.findViewById(R.id.pref_title);
        radio = (RadioButton) view.findViewById(R.id.pref_radio);
        return view;
    }

    public void setTitle(String title){
        this.title.setText(title);
    }

    public void setChecked(boolean isChecked){
        radio.setChecked(isChecked);
    }

}
