package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hazirmesajuygulamasi.R;
import com.example.hazirmesajuygulamasi.message_detail; // Detay sayfanın adı buysa

import java.util.List;

import models.MessageModel;
import utils.ShareUtils;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private Context context;
    private List<MessageModel> messageList;

    public MessageAdapter(Context context, List<MessageModel> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        MessageModel message = messageList.get(position);

        holder.textMessage.setText(message.getMessageText());
        holder.imageView.setImageResource(message.getImageResource());

        // WhatsApp butonu
        holder.btnShare.setOnClickListener(v -> {
            ShareUtils.shareText(context, message.getMessageText());
        });

        // 🔥 BURASI: Kartın tamamına tıklanınca detay ekranına git
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, message_detail.class);
            intent.putExtra("MESSAGE_TEXT", message.getMessageText());
            intent.putExtra("IMAGE_RESOURCE_ID", message.getImageResource());
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        TextView textMessage;
        ImageView imageView;
        Button btnShare;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textMessage = itemView.findViewById(R.id.tv_message_content);
            imageView = itemView.findViewById(R.id.iv_message_image);
            btnShare = itemView.findViewById(R.id.btn_share_whatsapp);
        }
    }
}
