package cn.hotfix.zxk.alihotfix.application;

import android.content.Context;
import android.support.annotation.Keep;

import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixApplication;
import com.taobao.sophix.SophixEntry;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;


/**
 * Created by zxk on 2018/2/8.
 */

public class SophixStubApplication extends SophixApplication {

    @Keep
    @SophixEntry(BaseApplication.class)
    static class RealApplicationStub{}

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        initSophix();
    }

    private void initSophix(){
        String version =  "0.0.0";
        try{
            version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        }catch (Exception e){
            e.printStackTrace();
        }
        SophixManager instance = SophixManager.getInstance();
        instance.setContext(this)
                .setAppVersion(version)
                .setSecretMetaData(null, null, null)
                .setEnableDebug(true)
                .setEnableFullLog()
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(int i, int i1, String s, int i2) {
                        if (i1 == PatchStatus.CODE_LOAD_SUCCESS){

                        }else if (i1 == PatchStatus.CODE_LOAD_RELAUNCH){

                        }else {

                        }
                    }
                }).initialize();

    }
}
