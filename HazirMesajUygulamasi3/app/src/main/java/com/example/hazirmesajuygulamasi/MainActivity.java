package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Butonları tanımla
        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        // Butonlara tıklanınca yeni sayfaya yönlendirme
        button1.setOnClickListener(view -> openNewActivity(anneler.class));
        button2.setOnClickListener(view -> openNewActivity(babalar.class));
        button3.setOnClickListener(view -> openNewActivity(sevgili.class));
        button4.setOnClickListener(view -> openNewActivity(ramazan.class));
        button5.setOnClickListener(view -> openNewActivity(kurban.class));
        button6.setOnClickListener(view -> openNewActivity(berat.class));
        button7.setOnClickListener(view -> openNewActivity(mirac.class));
        button8.setOnClickListener(view -> openNewActivity(regaip.class));
        button9.setOnClickListener(view -> openNewActivity(kadir.class));
    }

    // Yeni aktiviteyi açan metod
    private void openNewActivity(Class<?> activityClass) {
        Intent intent = new Intent(MainActivity.this, activityClass);
        startActivity(intent);
    }
}
