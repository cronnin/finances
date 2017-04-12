package com.example.android.telas;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.financesm.dao.AbstractDao;
import com.financesm.dao.MovimentacaoDao;
import com.financesm.model.Movimentacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class CadastroActivity<T extends Serializable> extends AppCompatActivity {

    private Class clazz;
    private AbstractDao dao;

    public CadastroActivity(Class clazz, AbstractDao dao){

        this.clazz = clazz;
        this.dao = dao;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        try {

            dao.iniciarDbHelper(getBaseContext());

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Movimentacao> lista = new ArrayList<>();
        try {

            lista = dao.getAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayAdapter<Movimentacao> adapter = new ArrayAdapter<Movimentacao>(this,
                android.R.layout.simple_list_item_1, lista);

        ListView listView = (ListView)findViewById(R.id.lista_objetos);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        try {
            dao.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        super.onDestroy();
    }

    public void abrirFormulario(View view){

    }
}
