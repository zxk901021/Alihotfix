package cn.hotfix.zxk.alihotfix.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zxk on 2018/2/8.
 */

public class SimpleService extends Service {

    public static final String TAG = "SimpleService";

    private LocalBinder binder = new LocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        showLog("onbind");
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        showLog("oncreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        showLog("ondestory");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showLog("onstartcommand");
        return super.onStartCommand(intent, flags, startId);
    }

    private void showLog(String msg){
        Log.e(TAG, msg);
    }

    public class LocalBinder extends Binder {
        SimpleService getService(){
            return SimpleService.this;
        }
    }

}
