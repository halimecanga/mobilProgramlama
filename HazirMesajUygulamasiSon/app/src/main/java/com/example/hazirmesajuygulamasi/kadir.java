package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class kadir extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5, button6;
    private TextView textViewKadir;

    // Mesaj listesi
    private List<MessageModel> kadirDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kadir);

        // TextView'i tanımla
        textViewKadir = findViewById(R.id.textViewKadir);
        textViewKadir.setText("Kadir Gecesi Mesajları");

        // Mesajları yükle
        loadkadirDayMessages();

        // Butonları tanımla
        button1 = findViewById(R.id.button58);
        button2 = findViewById(R.id.button59);
        button3 = findViewById(R.id.button60);
        button4 = findViewById(R.id.button61);
        button5 = findViewById(R.id.button62);
        button6 = findViewById(R.id.button63);

        // Buton tıklama olaylarını ayarla
        button1.setOnClickListener(v -> openMessageDetail(0));
        button2.setOnClickListener(v -> openMessageDetail(1));
        button3.setOnClickListener(v -> openMessageDetail(2));
        button4.setOnClickListener(v -> openMessageDetail(3));
        button5.setOnClickListener(v -> openMessageDetail(4));
        button6.setOnClickListener(v -> openMessageDetail(5));
    }

    private void openMessageDetail(int messageIndex) {
        MessageModel selectedMessage = kadirDayMessages.get(messageIndex);

        Intent intent = new Intent(this, message_detail.class);
        intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
        intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
        startActivity(intent);
    }

    private void loadkadirDayMessages() {
        kadirDayMessages = new ArrayList<>();

        kadirDayMessages.add(new MessageModel(
                "Kadir Geceniz mübarek olsun, dualarınız kabul olsun.",
                R.drawable.kadirgorsel1,
                "kadir_gecesi"));

        kadirDayMessages.add(new MessageModel(
                "Bu gece, Allah’ın rahmeti ve bereketi üzerinizde olsun.",
                R.drawable.kadirgorsel2,
                "kadir_gecesi"));

        kadirDayMessages.add(new MessageModel(
                "Kadir Gecesi’nin feyziyle hayatınız aydınlansın.",
                R.drawable.kadirgorsel3,
                "kadir_gecesi"));

        kadirDayMessages.add(new MessageModel(
                "Kadir Gecesi’nde tüm dilekleriniz kabul olsun.",
                R.drawable.kadirgorsel2,
                "kadir_gecesi"));

        kadirDayMessages.add(new MessageModel(
                "Bu mübarek gece, kalbiniz huzurla dolsun.",
                R.drawable.kadirgorsel3,
                "kadir_gecesi"));


    }
}