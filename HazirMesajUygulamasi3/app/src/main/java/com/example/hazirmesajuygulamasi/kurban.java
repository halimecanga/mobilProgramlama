package com.example.hazirmesajuygulamasi;
import android.content.ClipboardManager;
import android.widget.Button;

import android.os.Bundle;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.widget.Toast;
import android.content.Context;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.widget.Toast;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class kurban extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kurban);
        Button kopyala1;
        Button kopyala2;
        Button kopyala3;
        Button kopyala4;
        Button kopyala5;
        Button kopyala6;

        kopyala1 = (Button) findViewById(R.id.button34);
        kopyala2 = (Button) findViewById(R.id.button35);
        kopyala3 = (Button) findViewById(R.id.button36);
        kopyala4 = (Button) findViewById(R.id.button37);
        kopyala5 = (Button) findViewById(R.id.button38);
        kopyala6 = (Button) findViewById(R.id.button39);

        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        kopyala1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = kopyala1.getText().toString();
                ClipData clipData = ClipData.newPlainText("text", text);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(), "Kopyalandı", Toast.LENGTH_SHORT).show();
            }
        });
    }
}