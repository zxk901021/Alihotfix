package cn.hotfix.zxk.alihotfix.application;

import android.app.Application;

import com.taobao.sophix.SophixManager;

/**
 * Created by zxk on 2018/2/8.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SophixManager.getInstance().queryAndLoadNewPatch();
    }
}
