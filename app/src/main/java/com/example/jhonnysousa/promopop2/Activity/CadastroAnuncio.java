package com.example.jhonnysousa.promopop2.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jhonnysousa.promopop2.DAO.ConfiguracaoFirebase;
import com.example.jhonnysousa.promopop2.Entidades.Anuncio;
import com.example.jhonnysousa.promopop2.R;
import com.google.firebase.database.DatabaseReference;

public class CadastroAnuncio extends AppCompatActivity {

    private ImageView btnCadastrar, btnVoltarPrincipal;
    private EditText edtTitulo, edtDescricao, edtValidade, edtValor;
    private Anuncio anuncio;
    private DatabaseReference firebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_anuncio);

        edtTitulo = (EditText) findViewById(R.id.edtTitulo);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        edtValidade = (EditText) findViewById(R.id.edtValidade);
        edtValor = (EditText) findViewById(R.id.edtValor);
        btnCadastrar = (ImageView) findViewById(R.id.btnCadastrar);
        btnVoltarPrincipal = (ImageView) findViewById(R.id.btnVoltarPrincipal);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anuncio = new Anuncio();
                anuncio.setTitulo(edtTitulo.getText().toString());
                anuncio.setValorAtual(Integer.valueOf(edtValor.getText().toString()));

                salvarAnuncio(anuncio);

                edtTitulo.setText("");
                edtValor.setText("");
                edtValidade.setText("");
                edtDescricao.setText("");


            }
        });

        btnVoltarPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltarPrincipal();
            }
        });

    }

    private boolean salvarAnuncio(Anuncio anuncio){
        try{
            firebase = ConfiguracaoFirebase.getFirebase().child("addanuncios");
            firebase.child(anuncio.getTitulo()).setValue(anuncio);

            Toast.makeText(CadastroAnuncio.this, "Anuncio cadastrado com sucesso!", Toast.LENGTH_LONG).show();

            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private void voltarPrincipal(){
        Intent intent = new Intent(CadastroAnuncio.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
