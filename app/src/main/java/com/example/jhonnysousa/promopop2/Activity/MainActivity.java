package com.example.jhonnysousa.promopop2.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.jhonnysousa.promopop2.R;

public class MainActivity extends AppCompatActivity {
    private ImageButton imgBtnCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtnCadastrar = (ImageButton) findViewById(R.id.imgBtnCad);

        imgBtnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroAnuncio.class);
                startActivity(intent);
            }
        });

    }
}
