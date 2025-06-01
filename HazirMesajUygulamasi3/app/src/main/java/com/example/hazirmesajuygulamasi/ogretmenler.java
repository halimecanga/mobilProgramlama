package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class ogretmenler extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5;
    private TextView textViewOgretmenler;

    // Mesaj listesi
    private List<MessageModel>teacherDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ogretmenler);

        // TextView'i tanımla
        textViewOgretmenler = findViewById(R.id.textViewOgretmenler);
        textViewOgretmenler.setText("Kurban Bayramı Mesajları");

        // Mesajları yükle
        loadteacherDayMessages();

        // Butonları tanımla
        button1 = findViewById(R.id.button22);
        button2 = findViewById(R.id.button23);
        button3 = findViewById(R.id.button24);
        button4 = findViewById(R.id.button25);
        button5 = findViewById(R.id.button26);

        // Buton tıklama olaylarını ayarla
        button1.setOnClickListener(v -> openMessageDetail(0));
        button2.setOnClickListener(v -> openMessageDetail(1));
        button3.setOnClickListener(v -> openMessageDetail(2));
        button4.setOnClickListener(v -> openMessageDetail(3));
        button5.setOnClickListener(v -> openMessageDetail(4));
    }

    private void openMessageDetail(int messageIndex) {
        MessageModel selectedMessage = teacherDayMessages.get(messageIndex);

        Intent intent = new Intent(this, message_detail.class);
        intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
        intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
        startActivity(intent);
    }

    private void loadteacherDayMessages() {
        teacherDayMessages= new ArrayList<>();

        teacherDayMessages.add(new MessageModel(
                "Geleceği şekillendiren, yüreklerimize dokunan tüm öğretmenlerimizin günü kutlu olsun. İyi ki varsınız!",
                R.drawable.ogretmengorsel1,
                "ogretmenler_gunu"));

        teacherDayMessages.add(new MessageModel(
                "Bir insanı eğitmek, bir toplumu kurtarmaktır. Emeğinizin kıymetini biliyoruz. Nice güzel günlere, iyi ki varsınız",
                R.drawable.ogretmengorsel2,
                "ogretmenler_gunui"));

        teacherDayMessages.add(new MessageModel(
                "Dünyanın en kutsal mesleğini yapan, bilgiyle bizi donatan tüm öğretmenlere selam olsun. 24 Kasım Öğretmenler Günü kutlu olsun! ",
                R.drawable.ogretmengorsel3,
                "ogretmenler_gunu"));

        teacherDayMessages.add(new MessageModel(
                "Bir harf öğretenin kırk yıl kölesi olurum diyen bir milletin evladı olarak, emekleriniz için minnettarız. Öğretmenler Gününüz kutlu olsun. ",
                R.drawable.ogretmengorsel4,
                "ogretmenler_gunu"));

        teacherDayMessages.add(new MessageModel(
                "Kalbimize dokunan, bize ışık olan öğretmenim... Sizi unutmadım. Öğretmenler Gününüz kutlu olsun.\"",
                R.drawable.ogretmengorsel5,
                "ogretmenler_gunu"));
    }
}
