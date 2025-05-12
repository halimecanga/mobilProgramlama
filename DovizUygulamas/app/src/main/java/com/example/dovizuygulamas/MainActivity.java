package com.example.dovizuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView usdText;
    TextView eurText;
    TextView gbpText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usdText = findViewById(R.id.usdText);
        eurText = findViewById(R.id.eurText);
        gbpText = findViewById(R.id.gbpText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonVeriGetir();
            }
        });
    }

    private void jsonVeriGetir() {
        OkHttpClient client = new OkHttpClient();

        String url = "http://data.fixer.io/api/latest?access_key=08327d0ec934ee82890307e1b5ca2f8f&format=1";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonData = response.body().string();

                try {
                    JSONObject jsonObject = new JSONObject(jsonData);
                    JSONObject rates = jsonObject.getJSONObject("rates");

                    double usd = rates.getDouble("USD");
                    double eur = rates.getDouble("EUR");
                    double gbp = rates.getDouble("GBP");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            usdText.setText("USD: " + usd);
                            eurText.setText("EUR: " + eur);
                            gbpText.setText("GBP: " + gbp);
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
