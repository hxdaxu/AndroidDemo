package com.hxdaxu.alipay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText et;
    private Button bt;
    private ImageView iv;

    private String path = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.path_et);
        bt = findViewById(R.id.show_bt);
        iv = findViewById(R.id.icon_iv);

        bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.show_bt){
            path = et.getText().toString().trim();
            Log.i("AndroidDemo","path = "+path);

            String url = "https://s1.ax2x.com/2018/02/05/hwFF2.png";
            Glide.with(this)
                    .load(url)
                    .into(iv);
        }
    }
}
