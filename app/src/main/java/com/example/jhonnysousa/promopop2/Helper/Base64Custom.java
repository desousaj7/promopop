package com.example.jhonnysousa.promopop2.Helper;

import android.util.Base64;

public class Base64Custom {
    public static String codificadorBase64(String texto){
        return Base64.encodeToString(texto.getBytes(), Base64.DEFAULT).replaceAll("(\\n|\\r)", "");
    }

    public static String decodificadorBase64(String textoDecodificado){
        return new String (Base64.decode(textoDecodificado, Base64.DEFAULT));
    }
}
