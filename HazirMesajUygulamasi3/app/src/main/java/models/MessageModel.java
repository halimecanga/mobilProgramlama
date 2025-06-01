package models;

/**
 * Mesaj verilerini tutan model sınıfı
 * Her mesaj için metin, görsel ve kategori bilgisi saklar
 */
public class MessageModel {
    private String messageText;
    private int imageResource;
    private String category;

    /**
     * MessageModel constructor
     * @param messageText Mesaj metni
     * @param imageResource Drawable resource ID
     * @param category Mesaj kategorisi (annelaer, babalar, vb.)
     */
    public MessageModel(String messageText, int imageResource, String category) {
        this.messageText = messageText;
        this.imageResource = imageResource;
        this.category = category;
    }

    // Getter methods
    public String getMessageText() {
        return messageText;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getCategory() {
        return category;
    }

    // Setter methods
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Debug için toString metodu
     */
    @Override
    public String toString() {
        return "MessageModel{" +
                "messageText='" + messageText + '\'' +
                ", imageResource=" + imageResource +
                ", category='" + category + '\'' +
                '}';
    }
}