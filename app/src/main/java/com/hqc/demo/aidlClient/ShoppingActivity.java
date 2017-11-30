package com.hqc.demo.aidlClient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hqc.demo.R;
import com.hqc.demo.utils.LogUtils;
import com.hxdaxu.alipay.services.IPayService;

import java.util.List;

public class ShoppingActivity extends Activity implements View.OnClickListener {

    private EditText company;
    private EditText amount;
    private Button pay;
    private static final String action = "alipay.hxdaxu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        company = (EditText) findViewById(R.id.company_et);
        amount = (EditText) findViewById(R.id.amount_et);
        pay = (Button) findViewById(R.id.bt_pay);
        pay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_pay){
            Toast.makeText(ShoppingActivity.this,"服务启动中。。。",Toast.LENGTH_SHORT).show();
            bindPayService();
        }
    }

    private void bindPayService(){
        PackageManager pm = this.getPackageManager();
        List<ResolveInfo> infos = pm.queryIntentServices(new Intent(action,null),0);

        for (ResolveInfo info : infos){
            LogUtils.i("aidlClient package name = ",info.serviceInfo.packageName);
        }

        Intent intent = new Intent();
        intent.setAction(action);
        intent.setPackage(infos.get(0).serviceInfo.packageName);

        bindService(intent,new MyServiceConnection(), Context.BIND_AUTO_CREATE);

    }


    class MyServiceConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LogUtils.i(name.getPackageName()+"绑定成功！");
            IPayService payService = IPayService.Stub.asInterface(service);
            try {
                payService.pay(company.getText().toString(),100);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }


}
