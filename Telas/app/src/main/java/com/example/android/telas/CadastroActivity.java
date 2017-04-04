package com.example.android.telas;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.financesm.dao.MovimentacaoDao;
import com.financesm.model.Movimentacao;

import java.util.List;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        MovimentacaoDao dao = new MovimentacaoDao(getBaseContext());

        List<Movimentacao> lista = dao.getAll();
        ArrayAdapter<Movimentacao> adapter = new ArrayAdapter<Movimentacao>(this,
                android.R.layout.simple_list_item_1, lista);

        ListView listView = (ListView)findViewById(R.id.lista_objetos);
        listView.setAdapter(adapter);

    }


    public void abrirFormulario(View view){

    }
}
