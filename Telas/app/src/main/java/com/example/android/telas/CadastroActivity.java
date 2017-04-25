package com.example.android.telas;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.financesm.core.db.Identificavel;
import com.financesm.dao.AbstractDao;
import com.financesm.dao.MovimentacaoDao;
import com.financesm.model.Movimentacao;
import com.financesm.model.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public abstract class CadastroActivity<T extends Identificavel> extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    private Class clazz;
    private AbstractDao dao;
    private ArrayAdapter<T> listaAdapter;
    private T registro;

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

        List<T> lista = new ArrayList<>();
        try {

            lista = dao.getAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
        listaAdapter = new ArrayAdapter<T>(this,android.R.layout.simple_list_item_1, lista);

        ListView listView = (ListView)findViewById(R.id.lista_objetos);
        listView.setAdapter(listaAdapter);
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                registro = (T) adapterView.getItemAtPosition(i);
                abrirFormulario(view);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                registro = null;
            }
        });

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

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BlankFragment<T> fragment = BlankFragment.newInstance(dao, registro);
        fragmentTransaction.add(R.id.viewer, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onFragmentInteraction(Identificavel registro) {
    }
}
