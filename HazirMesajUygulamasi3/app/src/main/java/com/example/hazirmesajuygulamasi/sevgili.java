package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class sevgili extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5;
    private TextView textViewSevgililer;

    // Mesaj listesi
    private List<MessageModel> valentinesDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sevgili);

        // TextView'i tanımla
        textViewSevgililer = findViewById(R.id.textViewSevgililer);
        textViewSevgililer.setText("Sevgililer Günü Mesajları");

        // Mesajları yükle
        loadvalentinesDayMessages();

        // Butonları tanımla
        button1 = findViewById(R.id.button10);
        button2 = findViewById(R.id.button11);
        button3 = findViewById(R.id.button18);
        button4 = findViewById(R.id.button19);
        button5 = findViewById(R.id.button20);

        // Buton tıklama olaylarını ayarla
        button1.setOnClickListener(v -> openMessageDetail(0));
        button2.setOnClickListener(v -> openMessageDetail(1));
        button3.setOnClickListener(v -> openMessageDetail(2));
        button4.setOnClickListener(v -> openMessageDetail(3));
        button5.setOnClickListener(v -> openMessageDetail(4));
    }

    private void openMessageDetail(int messageIndex) {
        MessageModel selectedMessage = valentinesDayMessages.get(messageIndex);

        Intent intent = new Intent(this, message_detail.class);
        intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
        intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
        startActivity(intent);
    }

    private void loadvalentinesDayMessages() {
        valentinesDayMessages = new ArrayList<>();

        valentinesDayMessages.add(new MessageModel(
                "Seninle her gün Sevgililer Günü! Seni çok seviyorum! ❤",
                R.drawable.sevgililergunugorsel1,
                "sevgililer_gunu"));

        valentinesDayMessages.add(new MessageModel(
                "Aşkın hayatıma ışık gibi doğdu. İyi ki varsın! ",
                R.drawable.sevgililergunugorsel2,
                "sevgililer_gunu"));

        valentinesDayMessages.add(new MessageModel(
                "Kalbim hep seninle, bugün ve her zaman! ",
                R.drawable.sevgililergunugorsel3,
                "sevgililer_gunu"));

        valentinesDayMessages.add(new MessageModel(
                "Sonsuz sevgimle… Sevgililer Günün kutlu olsun! ",
                R.drawable.sevgililergunugorsel4,
                "sevgililer_gunu"));

        valentinesDayMessages.add(new MessageModel(
                "Seninle her an özel, her an güzel! İyi ki hayatımdasın!",
                R.drawable.sevgililergunugorsel5,
                "sevgililer_gunu"));
    }
}