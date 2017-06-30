package com.hqc.demo.preferencedemo;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.preference.TwoStatePreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Checkable;
import android.widget.RadioButton;

import com.hqc.demo.R;

public class RadioPreference2 extends Preference {

    private RadioButton btn;

    public RadioPreference2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWidgetLayoutResource(R.layout.preference_item_radio);
    }

    public RadioPreference2(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RadioPreference2(Context context) {
        this(context,null);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
//        View radioView = view.findViewById(R.id.item_radio);
        btn = (RadioButton) view.findViewById(R.id.item_radio);
    }

    @Override
    protected View onCreateView(ViewGroup parent) {
        Resources res = getContext().getResources();
        View view = super.onCreateView(parent);
        // 更改Preference的高度
        view.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, res.getDimensionPixelSize(R.dimen.preference_height)));
        return view;
    }

    public void setChecked(boolean isChecked){
        btn.setChecked(isChecked);
    }

    public boolean isChecked(){
        return btn.isChecked();
    }


}
