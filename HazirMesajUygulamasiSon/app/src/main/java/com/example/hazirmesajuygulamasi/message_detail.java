package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class message_detail extends AppCompatActivity {

    private ImageView imageViewDetail;
    private TextView textViewDetailMessage;
    private Button buttonShareWhatsapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);

        // XML'deki view'leri tanımla
        imageViewDetail = findViewById(R.id.imageViewDetail);
        textViewDetailMessage = findViewById(R.id.textViewDetailMessage);
        buttonShareWhatsapp = findViewById(R.id.buttonShareWhatsapp);

        // Intent verilerini al
        Intent intent = getIntent();
        if (intent != null) {
            String messageText = intent.getStringExtra("MESSAGE_TEXT");
            int imageResId = intent.getIntExtra("IMAGE_RESOURCE_ID", R.drawable.ic_launcher_background);

            textViewDetailMessage.setText(messageText);
            imageViewDetail.setImageResource(imageResId);

            // Paylaş butonu
            buttonShareWhatsapp.setOnClickListener(v -> shareToWhatsApp(messageText));
        }
    }

    private void shareToWhatsApp(String message) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.setPackage("com.whatsapp");
        shareIntent.putExtra(Intent.EXTRA_TEXT, message);

        try {
            startActivity(shareIntent);
        } catch (Exception e) {
            Toast.makeText(this, "WhatsApp yüklü değil.", Toast.LENGTH_SHORT).show();
        }
    }
}
