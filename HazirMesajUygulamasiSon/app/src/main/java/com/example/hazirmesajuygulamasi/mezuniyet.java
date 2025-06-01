package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class mezuniyet extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5;
    private TextView textViewMezuniyet;

    // Mesaj listesi
    private List<MessageModel>mezuniyetDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mezuniyet);

        // TextView'i tanımla
        textViewMezuniyet = findViewById(R.id.textViewMezuniyet);
        textViewMezuniyet.setText("Mezuniyet Tebrik Mesajları");

        // Mesajları yükle
        loadmezuniyetDayMessages();

        // Butonları tanımla
        button1 = findViewById(R.id.button67);
        button2 = findViewById(R.id.button68);
        button3 = findViewById(R.id.button69);
        button4 = findViewById(R.id.button70);
        button5 = findViewById(R.id.button71);

        // Buton tıklama olaylarını ayarla
        button1.setOnClickListener(v -> openMessageDetail(0));
        button2.setOnClickListener(v -> openMessageDetail(1));
        button3.setOnClickListener(v -> openMessageDetail(2));
        button4.setOnClickListener(v -> openMessageDetail(3));
        button5.setOnClickListener(v -> openMessageDetail(4));
    }

    private void openMessageDetail(int messageIndex) {
        MessageModel selectedMessage = mezuniyetDayMessages.get(messageIndex);

        Intent intent = new Intent(this, message_detail.class);
        intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
        intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
        startActivity(intent);
    }

    private void loadmezuniyetDayMessages() {
        mezuniyetDayMessages = new ArrayList<>();

        mezuniyetDayMessages.add(new MessageModel(
                " Bugün emeklerinin karşılığını aldığın gündür. Mezuniyetin kutlu olsun, başarıların daim olsun!",
                R.drawable.mezuniyetgorsel1,
                "mezuniyet_tebrik"));

        mezuniyetDayMessages.add(new MessageModel(
                "Bir kapı kapanıyor, yepyeni yollar açılıyor. Hayat yolculuğunda daima ışığın parlasın. Tebrikler mezun!",
                R.drawable.mezuniyetgorsel2,
                "mezuniyet_tebrik"));

        mezuniyetDayMessages.add(new MessageModel(
                " Zorlukları aşarak bugüne geldin, şimdi sıra hayallerini gerçekleştirmekte. Mezuniyetin hayırlı olsun!",
                R.drawable.mezuniyetgorsel3,
                "mezuniyet_tebrik"));

        mezuniyetDayMessages.add(new MessageModel(
                " Her son yeni bir başlangıçtır. Bugün gurur günü, yarın başarılarla dolu bir gelecek seninle olsun!",
                R.drawable.mezuniyetgorsel4,
                "mezuniyet_tebrik"));

        mezuniyetDayMessages.add(new MessageModel(
                " Mezuniyet, azminin ve kararlılığının bir göstergesi. Geleceğin senin ellerinde, yolun açık olsun!",
                R.drawable.mezuniyetgorsel5,
                "mezuniyet_tebrik"));
    }
}
