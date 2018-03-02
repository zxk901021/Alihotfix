package cn.hotfix.zxk.alihotfix;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import cn.hotfix.zxk.alihotfix.service.SimpleService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    Button btn;
    Button btn2;
    Button btn3;
    TextView filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
        }else {
            btn.setOnClickListener(this);
            btn2.setOnClickListener(this);
            btn3.setOnClickListener(this);
        }
        filePath = findViewById(R.id.file_path);
        String path = getFilesDir().getAbsolutePath();
        String cachePath = getCacheDir().getAbsolutePath();
        String publicPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath();
        String privatePath = getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        filePath.setText("path:" + path + "\n" + "cachePath:" + cachePath + "\n" + "publicPath:" + publicPath + "\n" + "privatePath:" + privatePath);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                btn.setOnClickListener(this);
                btn2.setOnClickListener(this);
                btn3.setOnClickListener(this);
            }else {
                Toast.makeText(this, "权限被禁止", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent service = new Intent(this, SimpleService.class);
        switch (v.getId()){
            case R.id.btn:
                tv.setText("bug has been fixed!");
                startService(service);
                break;
            case R.id.btn2:
                tv.setText("text has been changed!");
                stopService(service);
                break;
            case R.id.btn3:
                Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                break;
        }

    }
}
