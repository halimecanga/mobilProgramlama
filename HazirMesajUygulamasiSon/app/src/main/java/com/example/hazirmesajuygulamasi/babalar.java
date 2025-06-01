package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class babalar extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5;
    private TextView textViewBabalar;

    // Mesaj listesi
    private List<MessageModel> fathersDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_babalar);

        // TextView'i tanımla
        textViewBabalar = findViewById(R.id.textViewBabalar);
        textViewBabalar.setText("Babalar Günü Mesajları");

        // Mesajları yükle
        loadFathersDayMessages();

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
        MessageModel selectedMessage = fathersDayMessages.get(messageIndex);

        Intent intent = new Intent(this, message_detail.class);
        intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
        intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
        startActivity(intent);
    }

    private void loadFathersDayMessages() {
        fathersDayMessages = new ArrayList<>();

        fathersDayMessages.add(new MessageModel(
                "Hayattaki en büyük kahramanıma: Babalar Günün kutlu olsun!️",
                R.drawable.babalargunugorsel1,
                "babalar_gunu"));

        fathersDayMessages.add(new MessageModel(
                "Sevgin ve desteğin için teşekkür ederim baba! Mutlu günler seninle olsun!️",
                R.drawable.babalargunugorsel2,
                "babalar_gunu"));

        fathersDayMessages.add(new MessageModel(
                "Babam, iyi ki varsın! Babalar Günün kutlu olsun💐",
                R.drawable.babalargunugorsel3,
                "babalar_gunu"));

        fathersDayMessages.add(new MessageModel(
                "Senin gibi bir baba herkese nasip olmaz! İyi ki benim babamsın!!️",
                R.drawable.babalargunugorsel4,
                "babalar_gunu"));

        fathersDayMessages.add(new MessageModel(
                "Senin evladın olmak en büyük şansım! Babalar Günün kutlu olsun!",
                R.drawable.babalargunugorsel5,
                "babalar_gunu"));
    }
}
