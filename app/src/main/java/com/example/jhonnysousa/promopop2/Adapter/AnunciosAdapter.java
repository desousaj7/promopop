package com.example.jhonnysousa.promopop2.Adapter;

import android.app.Notification;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jhonnysousa.promopop2.Entidades.Anuncio;
import com.example.jhonnysousa.promopop2.R;

import java.util.ArrayList;

public class AnunciosAdapter extends ArrayAdapter<Anuncio> {

    private Context context;
    private ArrayList<Anuncio> anuncios;

    public AnunciosAdapter(Context c, ArrayList<Anuncio> objects) {
        super(c, 0, objects);
        this.context = c;
        this.anuncios = objects;
        
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if (anuncios != null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.listaanuncios, parent, false);

            TextView edtTiulo = (TextView) view.findViewById(R.id.edtTitulo);
            TextView edtValor = (TextView) view.findViewById(R.id.edtValor);

            Anuncio anuncios2 = anuncios.get(position);

            edtTiulo.setText(anuncios2.getTitulo());
            edtValor.setText(anuncios2.getValorAtual(Double.valueOf(edtValor.getText().toString())));

        }

        return view;
    }
}
