package com.example.yuehu.aria;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.test_button);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here
                String link = "test";
                directToSnapchat(link);
            }
        });

        Button button2 = (Button) findViewById(R.id.test_button_2);
        button2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here
                String link = "test";
                directToSnapchat(link);
            }
        });
    }

    private void directToSnapchat(String url) {
        try {
            Context context = getApplicationContext();
            PackageManager pm = context.getPackageManager();
            pm.getPackageInfo("com.snapchat.android", PackageManager.GET_ACTIVITIES);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        } catch (PackageManager.NameNotFoundException e) {
            Uri uri = Uri.parse(url);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(uri);
            startActivity(i);
        }
    }
}
