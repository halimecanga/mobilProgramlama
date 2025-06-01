package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Eski sayfaların butonlarını tanımla ve yönlendir
        findViewById(R.id.button).setOnClickListener(v -> openNewActivity(anneler.class));
        findViewById(R.id.button2).setOnClickListener(v -> openNewActivity(babalar.class));
        findViewById(R.id.button3).setOnClickListener(v -> openNewActivity(sevgili.class));
        findViewById(R.id.button4).setOnClickListener(v -> openNewActivity(ramazan.class));
        findViewById(R.id.button5).setOnClickListener(v -> openNewActivity(kurban.class));
        findViewById(R.id.button6).setOnClickListener(v -> openNewActivity(berat.class));
        findViewById(R.id.button7).setOnClickListener(v -> openNewActivity(mirac.class));
        findViewById(R.id.button8).setOnClickListener(v -> openNewActivity(regaip.class));
        findViewById(R.id.button9).setOnClickListener(v -> openNewActivity(kadir.class));
        findViewById(R.id.button13).setOnClickListener(v -> openNewActivity(ogretmenler.class));
        findViewById(R.id.button72).setOnClickListener(v -> openNewActivity(kadinlar.class));
        findViewById(R.id.button73).setOnClickListener(v -> openNewActivity(yeniyil.class));
        findViewById(R.id.button74).setOnClickListener(v -> openNewActivity(mezuniyet.class));
    }

    // Ortak yönlendirme metodu
    private void openNewActivity(Class<?> activityClass) {
        Intent intent = new Intent(MainActivity.this, activityClass);
        startActivity(intent);
    }
}
