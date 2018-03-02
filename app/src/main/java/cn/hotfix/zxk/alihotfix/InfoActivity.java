package cn.hotfix.zxk.alihotfix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        textView = findViewById(R.id.info);
//        try{
//            textView.setText(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
//        }catch (PackageManager.NameNotFoundException e){
//            e.printStackTrace();
//        }
    }

}
