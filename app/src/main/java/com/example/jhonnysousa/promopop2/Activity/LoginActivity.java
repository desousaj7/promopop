package com.example.jhonnysousa.promopop2.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jhonnysousa.promopop2.DAO.ConfiguracaoFirebase;
import com.example.jhonnysousa.promopop2.Entidades.Usuario;
import com.example.jhonnysousa.promopop2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;
    private Usuario usuario;

    private EditText edtemail;
    private EditText edtsenha;
    private Button btnlogin;
    private Button btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        edtemail = (EditText) findViewById(R.id.editEmail);
        edtsenha = (EditText) findViewById(R.id.editSenha);
        btnlogin = (Button) findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtemail.getText().toString().equals("") && !edtsenha.getText().toString().equals("")){
                    usuario = new Usuario();
                    usuario.setEmail(edtemail.getText().toString());
                    usuario.setSenha(edtsenha.getText().toString());

                    validarLogin();
                }else{
                    Toast.makeText(LoginActivity.this, "Preencha os campos", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnCadastro = (Button) findViewById(R.id.btnCadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCad = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intentCad);
            }
        });
    }

    private void validarLogin(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    abrirTelaPrincipal();
                    Toast.makeText(LoginActivity.this, "Feito!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Não é possível", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void abrirTelaPrincipal(){
        Intent intentAbrirTela = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intentAbrirTela);
    }

}
