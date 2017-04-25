package com.example.android.telas;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.financesm.core.CampoForm;
import com.financesm.core.Util;
import com.financesm.core.db.Identificavel;
import com.financesm.dao.AbstractDao;
import com.financesm.model.Usuario;

import java.io.Serializable;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment<T extends Identificavel> extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "dao";
    private static final String ARG_PARAM2 = "objeto";

    private AbstractDao<T> abstractDao;
    private T registro;

    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(AbstractDao abstractDao, Object o) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, (Serializable) abstractDao);
        args.putSerializable(ARG_PARAM2, (Serializable) o);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            abstractDao = (AbstractDao<T>) getArguments().getSerializable(ARG_PARAM1);
            registro = (T) getArguments().getSerializable(ARG_PARAM2);
            LinearLayout layout = (LinearLayout) getActivity().findViewById(R.id.conteudoFrame);
            montarLaout(layout);
        }
    }

    private void montarLaout(LinearLayout layout) {

        List<CampoForm> campos = Util.getCampos( abstractDao.getClass() );

        for(CampoForm cf : campos) {

            switch (cf.getCampoDB().tipo()){
                case DATE:
                    break;
                case DECIMAL:
                    break;
                case INTEIRO:
                    break;
                case TEXT:
                default:
                    criarTextField(layout, cf);
            }

        }


    }

    private void criarTextField(LinearLayout layout, CampoForm cf) {

        TextView tv = new TextView(getActivity().getBaseContext());

        layout.addView(tv);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(new Usuario());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Identificavel obj);
    }
}
