package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class kurban extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5;
    private TextView textViewKurban;

    // Mesaj listesi
    private List<MessageModel>kurbanDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurban);

        // TextView'i tanımla
        textViewKurban = findViewById(R.id.textViewKurban);
        textViewKurban.setText("Kurban Bayramı Mesajları");

        // Mesajları yükle
        loadkurbanDayMessages();

        // Butonları tanımla
        button1 = findViewById(R.id.button34);
        button2 = findViewById(R.id.button35);
        button3 = findViewById(R.id.button36);
        button4 = findViewById(R.id.button37);
        button5 = findViewById(R.id.button38);

        // Buton tıklama olaylarını ayarla
        button1.setOnClickListener(v -> openMessageDetail(0));
        button2.setOnClickListener(v -> openMessageDetail(1));
        button3.setOnClickListener(v -> openMessageDetail(2));
        button4.setOnClickListener(v -> openMessageDetail(3));
        button5.setOnClickListener(v -> openMessageDetail(4));
    }

    private void openMessageDetail(int messageIndex) {
        MessageModel selectedMessage = kurbanDayMessages.get(messageIndex);

        Intent intent = new Intent(this, message_detail.class);
        intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
        intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
        startActivity(intent);
    }

    private void loadkurbanDayMessages() {
        kurbanDayMessages = new ArrayList<>();

        kurbanDayMessages.add(new MessageModel(
                "Bayramınız bereketli ve güzel olsun.",
                R.drawable.kurbangorsel1,
                "kurban_bayrami"));

        kurbanDayMessages.add(new MessageModel(
                "Sevdiklerinizle mutlu bir bayram geçirin..",
                R.drawable.kurbangorsel2,
                "kurban_bayrami"));

        kurbanDayMessages.add(new MessageModel(
                "Bayramda kalbiniz hep huzurla dolsun.",
                R.drawable.kurbangorsel3,
                "kurban_bayrami"));

        kurbanDayMessages.add(new MessageModel(
                "Bayramınız mübarek, gönlünüz ferah olsun.",
                R.drawable.kurbangorsel4,
                "kurban_bayrami"));

        kurbanDayMessages.add(new MessageModel(
                "Bayramda mutluluk ve sağlık sizinle olsun.",
                R.drawable.kurbangorsel5,
                "kurban_bayrami"));
    }
}
