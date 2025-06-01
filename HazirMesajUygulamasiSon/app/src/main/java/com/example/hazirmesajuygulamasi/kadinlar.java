package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class kadinlar extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5;
    private TextView textViewKadinlar;

    // Mesaj listesi
    private List<MessageModel> womensDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kadinlar);

        // TextView'i tanımla
        textViewKadinlar = findViewById(R.id.textViewKadinlar);
        textViewKadinlar.setText("Kadınlar Günü Mesajları");

        // Mesajları yükle
        loadwomensDayMessages();

        // Butonları tanımla
        button1 = findViewById(R.id.button12);
        button2 = findViewById(R.id.button10);
        button3 = findViewById(R.id.button14);
        button4 = findViewById(R.id.button15);
        button5 = findViewById(R.id.button16);

        // Buton tıklama olaylarını ayarla
        button1.setOnClickListener(v -> openMessageDetail(0));
        button2.setOnClickListener(v -> openMessageDetail(1));
        button3.setOnClickListener(v -> openMessageDetail(2));
        button4.setOnClickListener(v -> openMessageDetail(3));
        button5.setOnClickListener(v -> openMessageDetail(4));
    }

    private void openMessageDetail(int messageIndex) {
        MessageModel selectedMessage = womensDayMessages.get(messageIndex);

        Intent intent = new Intent(this, message_detail.class);
        intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
        intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
        startActivity(intent);
    }

    private void loadwomensDayMessages() {
        womensDayMessages = new ArrayList<>();

        womensDayMessages.add(new MessageModel(
                "Hayatımıza kattığınız sevgi, azim ve güç için teşekkür ederim. Kadınlar Günü'nüz kutlu olsun!",
                R.drawable.kadinlargunugorsel1,
                "kadinlar_gunu"));

        womensDayMessages.add(new MessageModel(
                "Dünya, sizin gibi güçlü ve ilham verici kadınlarla daha güzel. Kadınlar Günü'nüzde tüm kadınları kutlarım!",
                R.drawable.kadinlargunugorsel2,
                "kadinlar_gunu"));

        womensDayMessages.add(new MessageModel(
                "Emeğiniz, özveriniz ve gücünüzle dünyayı daha iyi bir yer haline getiriyorsunuz. Kadınlar Günü'nüz kutlu olsun!",
                R.drawable.kadinlargunugorsel3,
                "kadinlar_gunu"));

        womensDayMessages.add(new MessageModel(
                "Her günü daha parlak kılan, sevgiyle dolu olan tüm kadınlara minnettarız. Kadınlar Günü'nüz kutlu olsun!️",
                R.drawable.kadinlargunugorsel4,
                "kadinlar_gunu"));
       womensDayMessages.add(new MessageModel(
                "Kadın olmak, gücün ve zarafetin bir arada olduğu bir yolculuktur. Her kadının Kadınlar Günü kutlu olsun!",
                R.drawable.kadinlargunugorsel5,
                "kadinlar_gunu"));
    }
}
