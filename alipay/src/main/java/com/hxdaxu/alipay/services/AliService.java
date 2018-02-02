package com.hxdaxu.alipay.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AliService extends Service {

    private PayServiceImpl binder = null;

    public AliService() {

    }

    @Override
    public IBinder onBind(Intent intent) {

        if (binder == null){
            binder = new PayServiceImpl();
        }
        Log.i("AndroidDemo","alipay onBind. thread name is "+Thread.currentThread().getName());
        return binder;
    }


    class PayServiceImpl extends IPayService.Stub{

        @Override
        public void pay(String company, int amount) throws RemoteException {
            Log.d("AndroidDemo","pay " + amount +" $ to " + company + "company thread name is "+Thread.currentThread().getName());
        }
    }


}
