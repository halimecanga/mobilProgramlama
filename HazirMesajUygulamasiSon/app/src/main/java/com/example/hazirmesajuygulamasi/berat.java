package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class berat extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5;
    private TextView textViewBerat;

    // Mesaj listesi
    private List<MessageModel> beratDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berat);

        // TextView'i tanımla
        textViewBerat = findViewById(R.id.textViewBerat);
        textViewBerat.setText("Berat Kandili Mesajları");

        // Mesajları yükle
        loadberatDayMessages();

        // Butonları tanımla
        button1 = findViewById(R.id.button40);
        button2 = findViewById(R.id.button41);
        button3 = findViewById(R.id.button42);
        button4 = findViewById(R.id.button43);
        button5 = findViewById(R.id.button44);

        // Buton tıklama olaylarını ayarla
        button1.setOnClickListener(v -> openMessageDetail(0));
        button2.setOnClickListener(v -> openMessageDetail(1));
        button3.setOnClickListener(v -> openMessageDetail(2));
        button4.setOnClickListener(v -> openMessageDetail(3));
        button5.setOnClickListener(v -> openMessageDetail(4));
    }

    private void openMessageDetail(int messageIndex) {
        MessageModel selectedMessage = beratDayMessages.get(messageIndex);

        Intent intent = new Intent(this, message_detail.class);
        intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
        intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
        startActivity(intent);
    }

    private void loadberatDayMessages() {
        beratDayMessages = new ArrayList<>();

        beratDayMessages.add(new MessageModel(
                "Berat Kandiliniz mübarek olsun, dualarınız kabul olsun.",
                R.drawable.beratkandiligorsel1,
                "berat_kandili"));

        beratDayMessages.add(new MessageModel(
                "Bu mübarek gece, kalbiniz aydınlık, dualarınız kabul olsun.️",
                R.drawable.beratkandiligorsel2,
                "berat_kandili"));

        beratDayMessages.add(new MessageModel(
                "Allah tüm dileklerinizi kabul etsin.",
                R.drawable.beratkandiligorsel3,
                "berat_kandili"));

        beratDayMessages.add(new MessageModel(
                "Berat Kandilinizde, huzur ve bereket sizinle olsun.",
                R.drawable.beratkandiligorsel4,
                "berat_kandili"));

        beratDayMessages.add(new MessageModel(
                "Berat Kandili, gönüllerinizi sevgiyle doldursun.",
                R.drawable.beratkandiligorsel5,
                "berat_kandili"));
    }
}
