package com.cristobalbernal.contactofragments;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class FragmentLListat extends Fragment {
    private Contacto[] contactos;
    private IContactoLister listener;

    public FragmentLListat(){
        super(R.layout.fragment_llistat);
    }

    public void setContactosListener(Contacto[] contactos, IContactoLister listener){
        this.contactos = contactos;
        this.listener = listener;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert  contactos !=null && listener !=null;
        RecyclerView recyclerView = view.findViewById(R.id.rvLListat);
        recyclerView.setAdapter(new AdaptadorContacto(contactos,listener));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));


    }

}
