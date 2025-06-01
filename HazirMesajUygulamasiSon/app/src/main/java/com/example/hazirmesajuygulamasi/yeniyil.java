package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import models.MessageModel;

public class yeniyil extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5;
    private TextView textViewYeniyil;
    private List<MessageModel> newYearDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeniyil);

        // TextView'i tanımla
        textViewYeniyil = findViewById(R.id.textViewYeniyil);
        textViewYeniyil.setText("Yeni Yıl Mesajları");

        // Mesajları yükle
        loadNewYearDayMessages();

        // Butonları tanımla
        button1 = findViewById(R.id.button17);
        button2 = findViewById(R.id.button27);
        button3 = findViewById(R.id.button64);
        button4 = findViewById(R.id.button65);
        button5 = findViewById(R.id.button66);

        // Buton tıklama olaylarını ayarla
        button1.setOnClickListener(v -> openMessageDetail(0));
        button2.setOnClickListener(v -> openMessageDetail(1));
        button3.setOnClickListener(v -> openMessageDetail(2));
        button4.setOnClickListener(v -> openMessageDetail(3));
        button5.setOnClickListener(v -> openMessageDetail(4));
    }

    private void openMessageDetail(int messageIndex) {
        if (messageIndex >= 0 && messageIndex < newYearDayMessages.size()) {
            MessageModel selectedMessage = newYearDayMessages.get(messageIndex);

            Intent intent = new Intent(this, message_detail.class);
            intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
            intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
            startActivity(intent);
        }
    }

    private void loadNewYearDayMessages() {
        newYearDayMessages = new ArrayList<>();

        newYearDayMessages.add(new MessageModel(
                "Yeni yıl, sağlık, mutluluk ve başarılarla dolu olsun! 2025'te tüm hayalleriniz gerçek olsun. İyi seneler!",
                R.drawable.yeniyilgorsel1,
                "yeni_yil"));

        newYearDayMessages.add(new MessageModel(
                "Her yeni yıl, yeni umutlar ve başlangıçlar demektir. 2025’te yaşamınızda sadece güzellikler olsun. Mutlu yıllar!",
                R.drawable.yeniyilgorsel2,
                "yeni_yil"));

        newYearDayMessages.add(new MessageModel(
                "Geçen yılın tüm zorlukları geride kaldı, şimdi yeni umutlarla dolu bir yıl başlıyor. Yeni yılınız kutlu olsun! 🎉",
                R.drawable.yeniyilgorsel3,
                "yeni_yil"));

        newYearDayMessages.add(new MessageModel(
                "Yeni yıl, hayatınıza neşe, huzur ve başarı getirsin. Her şeyin en iyisi sizlerin olsun! Mutlu yıllar!",
                R.drawable.yeniyilgorsel4,
                "yeni_yil"));

        newYearDayMessages.add(new MessageModel(
                "Yeni bir yıl, yeni bir başlangıç... 2025, tüm dileklerinizin gerçeğe dönüştüğü bir yıl olsun. İyi yıllar!",
                R.drawable.yeniyilgorsel5,
                "yeni_yil"));
    }
}