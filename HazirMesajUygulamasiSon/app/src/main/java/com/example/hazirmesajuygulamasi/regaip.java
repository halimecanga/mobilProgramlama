package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class regaip extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5;
    private TextView textViewRegaip;

    // Mesaj listesi
    private List<MessageModel>regaipDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regaip);

        // TextView'i tanımla
        textViewRegaip = findViewById(R.id.textViewRegaip);
        textViewRegaip.setText("Regaip Kandili Mesajları");

        // Mesajları yükle
        loadregaipDayMessages();

        // Butonları tanımla
        button1 = findViewById(R.id.button52);
        button2 = findViewById(R.id.button53);
        button3 = findViewById(R.id.button54);
        button4 = findViewById(R.id.button55);
        button5 = findViewById(R.id.button56);

        // Buton tıklama olaylarını ayarla
        button1.setOnClickListener(v -> openMessageDetail(0));
        button2.setOnClickListener(v -> openMessageDetail(1));
        button3.setOnClickListener(v -> openMessageDetail(2));
        button4.setOnClickListener(v -> openMessageDetail(3));
        button5.setOnClickListener(v -> openMessageDetail(4));
    }

    private void openMessageDetail(int messageIndex) {
        MessageModel selectedMessage = regaipDayMessages.get(messageIndex);

        Intent intent = new Intent(this, message_detail.class);
        intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
        intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
        startActivity(intent);
    }

    private void loadregaipDayMessages() {
        regaipDayMessages = new ArrayList<>();

        regaipDayMessages.add(new MessageModel(
                "Regaip Kandiliniz Mübarek Olsun! Allah dualarınızı kabul etsin, huzur ve bereket getirsin. ",
                R.drawable.regaigorsel1,
                "regaip_kandili"));

        regaipDayMessages.add(new MessageModel(
                "Hayırlı Kandiller! Bu mübarek gecede gönlünüz huzurla dolsun, dualarınız kabul olsun.",
                R.drawable.regaigorsel2,
                "regaip_kandili"));

        regaipDayMessages.add(new MessageModel(
                "Regaip Kandiliniz Mübarek Olsun! Sağlık, mutluluk ve huzur dolu nice kandillere…",
                R.drawable.regaigorsel3,
                "regaip_kandili"));

        regaipDayMessages.add(new MessageModel(
                "Kandiliniz mübarek olsun! Rabbim bu mübarek gece hürmetine tüm dualarınızı kabul eylesin.",
                R.drawable.regaipgorsel4,
                "regaip_kandili"));

        regaipDayMessages.add(new MessageModel(
                "Regaip Kandilinin bereketi üzerinize olsun.",
                R.drawable.regaipgorsel5,
                "regaip_kandili"));
    }
}
