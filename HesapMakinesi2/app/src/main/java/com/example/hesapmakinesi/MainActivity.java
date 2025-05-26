package com.example.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private veritabani db;
    private TextView veriTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        veriTextView = findViewById(R.id.veriTextView);

        // Veritabanı nesnesini oluştur
        db = new veritabani(this);

        // Örnek kayıt ekle
        db.KayitEkle("Ali", "Yılmaz", "25", "Ankara");

        // Kayıtları getir
        String veriler = db.KayitGetir();

        // Kayıtları ekranda göster
        veriTextView.setText(veriler);
    }
}
