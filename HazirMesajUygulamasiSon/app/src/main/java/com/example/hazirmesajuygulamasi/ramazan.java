package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class ramazan extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5;
    private TextView textViewRamazan;

    // Mesaj listesi
    private List<MessageModel> ramazanDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramazan);

        // TextView'i tanımla
        textViewRamazan = findViewById(R.id.textViewRamazan);
        textViewRamazan.setText("Ramazan Bayramı Mesajları");

        // Mesajları yükle
        loadramazanDayMessages();

        // Butonları tanımla
        button1 = findViewById(R.id.button28);
        button2 = findViewById(R.id.button29);
        button3 = findViewById(R.id.button30);
        button4 = findViewById(R.id.button31);
        button5 = findViewById(R.id.button32);

        // Buton tıklama olaylarını ayarla
        button1.setOnClickListener(v -> openMessageDetail(0));
        button2.setOnClickListener(v -> openMessageDetail(1));
        button3.setOnClickListener(v -> openMessageDetail(2));
        button4.setOnClickListener(v -> openMessageDetail(3));
        button5.setOnClickListener(v -> openMessageDetail(4));
    }

    private void openMessageDetail(int messageIndex) {
        MessageModel selectedMessage = ramazanDayMessages.get(messageIndex);

        Intent intent = new Intent(this, message_detail.class);
        intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
        intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
        startActivity(intent);
    }

    private void loadramazanDayMessages() {
        ramazanDayMessages = new ArrayList<>();

        ramazanDayMessages.add(new MessageModel(
                "Bayramınız mübarek olsun!",
                R.drawable.ramazanbayramigorsel1,
                "ramazan_bayrami"));

        ramazanDayMessages.add(new MessageModel(
                "Huzurlu bir bayram dilerim.",
                R.drawable.ramazanbayramigorsel2,
                "ramazan_bayrami"));

        ramazanDayMessages.add(new MessageModel(
                "Bayramda sevdiklerinizle olmanın keyfini çıkarın.",
                R.drawable.ramazanbayramigorsel3,
                "ramazan_bayrami"));

        ramazanDayMessages.add(new MessageModel(
                "Sağlık ve mutluluk dolu bir bayram olsun.",
                R.drawable.ramazanbayramigorsel4,
                "ramazan_bayrami"));

        ramazanDayMessages.add(new MessageModel(
                "Bayramınız kutlu olsun, gönlünüz hep huzurlu olsun.",
                R.drawable.ramazanbayramigorsel5,
                "ramazan_bayrami"));
    }
}
