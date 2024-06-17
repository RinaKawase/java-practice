package com.example.location_sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ０、レイアウトファイルをアクティビティの画面に表示
        setContentView(R.layout.activity_main);
        // １、HomeFragmentを追加するトランザクションを開始（フラグメントをActivityに追加する）
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new HomeFragment())
                .commit();
        // ２、システムバーに重ならないようにする
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}