package com.example.hazirmesajuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class anneler extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5;
    private TextView textViewAnneler;

    // Mesaj listesi
    private List<MessageModel> mothersDayMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anneler);

        // TextView'i tanımla
        textViewAnneler = findViewById(R.id.textViewAnneler);
        textViewAnneler.setText("Anneler Günü Mesajları");

        // Anneler günü mesajlarını hazırla
        loadMothersDayMessages();

        // Butonları tanımla
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        // Buton tıklama olaylarını ayarla
        button1.setOnClickListener(v -> openMessageDetail(0));
        button2.setOnClickListener(v -> openMessageDetail(1));
        button3.setOnClickListener(v -> openMessageDetail(2));
        button4.setOnClickListener(v -> openMessageDetail(3));
        button5.setOnClickListener(v -> openMessageDetail(4));
    }

    // Detay sayfasına yönlendirme metodu
    private void openMessageDetail(int messageIndex) {
        MessageModel selectedMessage = mothersDayMessages.get(messageIndex);

        Intent intent = new Intent(this, message_detail.class);
        intent.putExtra("MESSAGE_TEXT", selectedMessage.getMessageText());
        intent.putExtra("IMAGE_RESOURCE_ID", selectedMessage.getImageResource());
        startActivity(intent);
    }

    // Anneler günü mesajlarını yükle
    private void loadMothersDayMessages() {
        mothersDayMessages = new ArrayList<>();

        // Anneler günü mesajları ve görselleri
        mothersDayMessages.add(new MessageModel(
                "Anneciğim, sevgin en büyük hediyem! Anneler Günün kutlu olsun. ❤️",
                R.drawable.annelergunugorsel1,
                "anneler_gunu"));

        mothersDayMessages.add(new MessageModel(
                "Dünyadaki en güzel kelime 'anne'! Seni çok seviyorum, iyi ki varsın. 🌸️",
                R.drawable.annelergunugorsel2,
                "anneler_gunu"));

        mothersDayMessages.add(new MessageModel(
                "Senin sevgin bana güç veriyor, Anneler Günün kutlu olsun! 💐",
                R.drawable.annelergunugorsel3,
                "anneler_gunu"));

        mothersDayMessages.add(new MessageModel(
                "Anne sevgisi dünyadaki en saf sevgidir. İyi ki benim annemsin! 💖",
                R.drawable.annelergunugorsel4,
                "anneler_gunu"));

        mothersDayMessages.add(new MessageModel(
                "Sonsuz sevgin ve emeğin için teşekkürler. Seni çok seviyorum anne! 🌼️",
                R.drawable.annelergunugorsel5,
                "anneler_gunu"));
    }
}