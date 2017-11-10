package com.hqc.demo;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.Thing;
import com.hqc.demo.addAlarmDemo.AddAlarmActivity;
import com.hqc.demo.callbackdemo.CallBackDemoActivity;
import com.hqc.demo.dataclearreceiverdemo.DataClearReceiverDemoActivity;
import com.hqc.demo.dialogdemo.DialogDemoActivity;
import com.hqc.demo.eventbusdemo.EventBusActivity1;
import com.hqc.demo.gesturedemo.GestureActivity;
import com.hqc.demo.mediaplayerdemo.MediaDemoActivity;
import com.hqc.demo.preferencedemo.SettingsActivity;
import com.hqc.demo.remoteservicedemo.ServiceControlActivity;
import com.hqc.demo.sharedpreferencedemo.SharedPreferenceActivity;
import com.hqc.demo.startactivitydemo.StartActivityDemoActivity;
import com.hqc.demo.surfaceviewdemo.SurfaceViewActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener {

    private ListView mListView;
    private String[] mStringArray = {
            "eventbusDemo", "callbackDemo", "DataClearReceiverDemo",
            "addAlarmDemo", "surfaceViewDemo", "mediaPlayerDemo",
            "gestureDemo", "sharePreferenceDemo", "DialogDemoActivity",
            "preferenceDemo", "StartActivityDemoActivity","serviceDemo"
    };
    private final int DEMO_EVENTBUS = 0;
    private final int DEMO_CALLBACK = 1;
    private final int DEMO_DATA_CLEAR_RECEIVER = 2;
    private final int DEMO_ADD_ALARM = 3;
    private final int DEMO_SURFACE_VIEW = 4;
    private final int DEMO_MEDIAPLAYER = 5;
    private final int DEMO_GESTURE = 6;
    private final int DEMO_SHAREDPREFERENCE = 7;
    private final int DEMO_DIALOG = 8;
    private final int DEMO_PREFERENCE = 9;
    private final int DEMO_START_ACTIVITY = 10;
    private final int SERVICE_DEMO = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.main_listview);
        mListView.setAdapter(new MainListViewAdapter(this, mStringArray));
        mListView.setOnItemClickListener(this);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.action_settings));
        builder.setNegativeButton(getString(R.string.app_name), null);
        builder.setPositiveButton(getString(R.string.app_name),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.setCancelable(true);
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {

            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        switch (position) {
            case DEMO_EVENTBUS:
                Intent intent0 = new Intent(this, EventBusActivity1.class);
                startActivity(intent0);
                break;
            case DEMO_CALLBACK:
                Intent intent1 = new Intent(this, CallBackDemoActivity.class);
                startActivity(intent1);
                break;
            case DEMO_DATA_CLEAR_RECEIVER:
                Intent intent2 = new Intent(this, DataClearReceiverDemoActivity.class);
                startActivity(intent2);
                break;
            case DEMO_ADD_ALARM:
                Intent intent3 = new Intent(this, AddAlarmActivity.class);
                startActivity(intent3);
                break;
            case DEMO_SURFACE_VIEW:
                Intent intent4 = new Intent(this, SurfaceViewActivity.class);
                startActivity(intent4);
                break;
            case DEMO_MEDIAPLAYER:
                Intent intent5 = new Intent(this, MediaDemoActivity.class);
                startActivity(intent5);
                break;
            case DEMO_GESTURE:
                Intent intent6 = new Intent(this, GestureActivity.class);
                startActivity(intent6);
                break;
            case DEMO_SHAREDPREFERENCE:
                Intent intent7 = new Intent(this, SharedPreferenceActivity.class);
                startActivity(intent7);
                break;
            case DEMO_DIALOG:
                Intent intent8 = new Intent(this, DialogDemoActivity.class);
                startActivity(intent8);
                break;
            case DEMO_PREFERENCE:
                Intent intent9 = new Intent(this, SettingsActivity.class);
                startActivity(intent9);
                break;
            case DEMO_START_ACTIVITY:
                Intent intent10 = new Intent(this, StartActivityDemoActivity.class);
                startActivity(intent10);
                break;
            case SERVICE_DEMO:
                Intent intent11 = new Intent(this, ServiceControlActivity.class);
                startActivity(intent11);
                break;

            default:
                break;
        }

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

}
