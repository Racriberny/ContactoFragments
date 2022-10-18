package com.cristobalbernal.contactofragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetall extends Fragment {
    public static final String TEXTO_CONTACTO = "com.cristobalbernal.fragments.TEXTO_CORREO";
    private TextView nombre;
    private TextView apellidos;
    private TextView segundoApellido;
    private TextView direcion;
    private TextView empresa;
    private TextView fecha;
    private TextView tel1;
    private TextView tel2;
    private TextView email;
    private Contacto contacto;

    public FragmentDetall(){
        super(R.layout.fragment_detall);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contacto = (Contacto) getArguments().getSerializable(TEXTO_CONTACTO);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nombre = view.findViewById(R.id.tvNombre);
        apellidos = view.findViewById(R.id.tvApellidos);
        segundoApellido = view.findViewById(R.id.tvSegundo);
        direcion = view.findViewById(R.id.tvDirecion);
        empresa = view.findViewById(R.id.tvEmpresa);
        fecha = view.findViewById(R.id.tvFecha);
        tel1 = view.findViewById(R.id.tvTelf1);
        tel2 = view.findViewById(R.id.tvTel2);
        email = view.findViewById(R.id.tvEmail);

        mostrarDetalle(contacto);

    }

    public void mostrarDetalle(Contacto contacto) {
        nombre.setText(contacto.getNombre());
        apellidos.setText(contacto.getPrimerApellido());
        segundoApellido.setText(contacto.getSegundoApellido());
        direcion.setText(contacto.getDireccion());
        empresa.setText(contacto.getEmpresa());
        fecha.setText(contacto.getFechaNacimiento());
        tel1.setText(contacto.getTelefono1());
        tel2.setText(contacto.getTelefono2());
        email.setText(contacto.getEmail());
    }
}
