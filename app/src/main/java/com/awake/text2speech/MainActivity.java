package com.awake.text2speech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText write;
    TextToSpeech t1;
    private ImageView player,pauser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        write=(EditText)findViewById(R.id.ewrite);
        player = (ImageView)findViewById(R.id.imgplay);
        pauser =(ImageView)findViewById(R.id.imgpause);
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
             if(status != TextToSpeech.ERROR){
                 t1.setLanguage(Locale.ENGLISH);
             }
            }
        });
        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = write.getText().toString();
                Toast.makeText(MainActivity.this, toSpeak, Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        pauser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t1 != null) {
                    t1.stop();
                }
            }
        });
    }
}
