package com.example.securestorageandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import de.adorsys.android.securestoragelibrary.SecurePreferences;
import de.adorsys.android.securestoragelibrary.SecureStorageException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SecurePreferences.setValue(this, "SecretKey", "TareqKey");
           String k=  SecurePreferences.getStringValue(this, "SecretKey", "");
            Toast.makeText(this, k, Toast.LENGTH_LONG).show();

        } catch (SecureStorageException e) {
            e.printStackTrace();
            switch (e.type){
                case KEYSTORE_NOT_SUPPORTED_EXCEPTION:
                    Toast.makeText(this, "Oh", Toast.LENGTH_LONG).show();
                    break;
                case KEYSTORE_EXCEPTION:
                    Toast.makeText(this, "Fetal - YARK", Toast.LENGTH_LONG).show();

                    break;
                case CRYPTO_EXCEPTION:
                    Toast.makeText(this, "Crypto - YARK", Toast.LENGTH_LONG).show();

                    break;
                case INTERNAL_LIBRARY_EXCEPTION:
                    Toast.makeText(this, "Internal Library Error!", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    }
}