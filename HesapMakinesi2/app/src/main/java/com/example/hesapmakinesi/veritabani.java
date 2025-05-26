package com.example.hesapmakinesi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class veritabani extends SQLiteOpenHelper {

    private static final String VERITABANI_ADI = "OgrenciDB";
    private static final int VERSION = 1;
    private static final String TABLO_ADI = "OgrenciBilgi";
    private static final String TAG = "veritabani";

    public veritabani(Context context) {
        super(context, VERITABANI_ADI, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLO_ADI + " (ad TEXT PRIMARY KEY, soyad TEXT, yas INTEGER, sehir TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_ADI);
        onCreate(db);
    }

    public void KayitEkle(String ad, String soyad, String yas, String sehir) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues veriler = new ContentValues();
            veriler.put("ad", ad);
            veriler.put("soyad", soyad);
            veriler.put("yas", Integer.parseInt(yas));
            veriler.put("sehir", sehir);
            db.insertOrThrow(TABLO_ADI, null, veriler);
            db.close();
            Log.d(TAG, "Kayıt başarıyla eklendi.");
        } catch (Exception e) {
            Log.e(TAG, "Kayıt eklenirken hata oluştu: " + e.getMessage());
        }
    }

    public String KayitGetir() {
        StringBuilder builder = new StringBuilder();
        Cursor goster = null;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            goster = db.query(TABLO_ADI, new String[]{"ad", "soyad", "yas", "sehir"}, null, null, null, null, null);
            while (goster.moveToNext()) {
                String ad = goster.getString(goster.getColumnIndexOrThrow("ad"));
                String soyad = goster.getString(goster.getColumnIndexOrThrow("soyad"));
                String yas = goster.getString(goster.getColumnIndexOrThrow("yas"));
                String sehir = goster.getString(goster.getColumnIndexOrThrow("sehir"));

                builder.append("Ad: ").append(ad).append("\n")
                        .append("Soyad: ").append(soyad).append("\n")
                        .append("Yaş: ").append(yas).append("\n")
                        .append("Şehir: ").append(sehir).append("\n\n");
            }
        } catch (Exception e) {
            Log.e(TAG, "Kayıt gösterilirken hata oluştu: " + e.getMessage());
        } finally {
            if (goster != null) goster.close();
        }
        return builder.toString();
    }

    public void KayitSil(String ad) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            int rows = db.delete(TABLO_ADI, "ad=?", new String[]{ad});
            db.close();
            Log.d(TAG, rows + " kayıt silindi.");
        } catch (Exception e) {
            Log.e(TAG, "Kayıt silinirken hata oluştu: " + e.getMessage());
        }
    }

    public void KayitGuncelle(String ad, String soyad, String yas, String sehir) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("soyad", soyad);
            cv.put("yas", Integer.parseInt(yas));
            cv.put("sehir", sehir);

            int rows = db.update(TABLO_ADI, cv, "ad=?", new String[]{ad});
            db.close();
            Log.d(TAG, rows + " kayıt güncellendi.");
        } catch (Exception e) {
            Log.e(TAG, "Kayıt güncellenirken hata oluştu: " + e.getMessage());
        }
    }
}













