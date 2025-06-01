package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import models.MessageModel;

public class mirac extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5, button6;
    private TextView textViewMirac;
    private List<MessageModel> miracDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirac);

        // TextView'i tanımla
        textViewMirac = findViewById(R.id.textViewMirac);
        textViewMirac.setText("Miraç Kandili Mesajları");

        // Mesajları yükle
        loadMiracDayMessages();

        // Butonları tanımla
        button1 = findViewById(R.id.button46);
        button2 = findViewById(R.id.button47);
        button3 = findViewById(R.id.button48);
        button4 = findViewById(R.id.button49);
        button5 = findViewById(R.id.button50);
        button6 = findViewById(R.id.button51);

        // Buton tıklama olaylarını ayarla
        button1.setOnClickListener(v -> openMessageDetail(0));
        button2.setOnClickListener(v -> openMessageDetail(1));
        button3.setOnClickListener(v -> openMessageDetail(2));
        button4.setOnClickListener(v -> openMessageDetail(3));
        button5.setOnClickListener(v -> openMessageDetail(4));
        button6.setOnClickListener(v -> openMessageDetail(5));
    }

    private void openMessageDetail(int messageIndex) {
        if (messageIndex >= 0 && messageIndex < miracDayMessages.size()) {
            MessageModel selectedMessage = miracDayMessages.get(messageIndex);

            Intent intent = new Intent(this, message_detail.class);
            intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
            intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
            startActivity(intent);
        }
    }

    private void loadMiracDayMessages() {
        miracDayMessages = new ArrayList<>();

        miracDayMessages.add(new MessageModel(
                "Miraç Kandiliniz mübarek olsun, dualarınız kabul olsun.",
                R.drawable.miracgorsel1,
                "mirac_kandili"));

        miracDayMessages.add(new MessageModel(
                "Miraç Kandili’nin feyzi ve bereketi üzerinizde olsun.",
                R.drawable.miracgorsel2,
                "mirac_kandili"));

        miracDayMessages.add(new MessageModel(
                "Bu mübarek gecede dualarınız kabul, kalbiniz huzurlu olsun.",
                R.drawable.miracgorsel3,
                "mirac_kandili"));

        miracDayMessages.add(new MessageModel(
                "Miraç Kandili’nde tüm dilekleriniz gerçek olsun.",
                R.drawable.miracgorsel4,
                "mirac_kandili"));

        miracDayMessages.add(new MessageModel(
                "Miraç Kandili, kalbinizi arındıran bir gece olsun.",
                R.drawable.miracgorsel5,
                "mirac_kandili"));

        miracDayMessages.add(new MessageModel(
                "Miraç Kandiliniz sevgi ve huzur getirsin.",
                R.drawable.miracgorsel2, // miracgorsel6 yoksa miracgorsel2 kullanıldı
                "mirac_kandili"));
    }
}