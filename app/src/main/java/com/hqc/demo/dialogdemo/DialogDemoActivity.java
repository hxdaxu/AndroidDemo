package com.hqc.demo.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hqc.demo.R;

public class DialogDemoActivity extends Activity implements View.OnClickListener{

    private Button itemDialogBtn;
    private AlertDialog itemDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo);

        itemDialogBtn = (Button) findViewById(R.id.item_dialog);
        itemDialogBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item_dialog:
                showItemDialog();
                break;
            default:
                break;
        }
    }

    private void showItemDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("关闭重复闹钟") ;
        builder.setItems(R.array.dialog_items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogDemoActivity.this,"clicked "+which,Toast.LENGTH_SHORT).show();
                itemDialog.dismiss();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                     Toast.makeText(DialogDemoActivity.this,"cancel",Toast.LENGTH_SHORT).show();
            }
        });
        itemDialog = builder.show();
    }
}
