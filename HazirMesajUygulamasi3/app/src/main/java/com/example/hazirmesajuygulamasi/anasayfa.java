package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class anasayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_anasayfa);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // onCreate DIŞINA ALINDI
    public void annelergit(View view) {
        Intent a = new Intent(getApplicationContext(), anneler.class);
        startActivity(a);
    }
    public void babalargit(View view) {
        Intent b = new Intent(getApplicationContext(), babalar.class);
        startActivity(b);
    }
    public void beratgit(View view) {
        Intent be = new Intent(getApplicationContext(), berat.class);
        startActivity(be);
    }
    public void ramazangit(View view) {
        Intent r = new Intent(getApplicationContext(), ramazan.class);
        startActivity(r);
    }
    public void kurbangit(View view) {
        Intent k = new Intent(getApplicationContext(), kurban.class);
        startActivity(k);
    }
    public void miracgit(View view) {
        Intent m = new Intent(getApplicationContext(), mirac.class);
        startActivity(m);
    }
    public void regaipgit(View view) {
        Intent re = new Intent(getApplicationContext(), regaip.class);
        startActivity(re);
    }
    public void kadirgit(View view) {
        Intent ka = new Intent(getApplicationContext(), kadir.class);
        startActivity(ka);
    }
    public void sevgiligit(View view) {
        Intent s = new Intent(getApplicationContext(), sevgili.class);
        startActivity(s);
    }
}
