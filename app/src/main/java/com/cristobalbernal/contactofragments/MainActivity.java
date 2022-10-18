package com.cristobalbernal.contactofragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements IContactoLister, FragmentOnAttachListener {
    private FragmentDetall frgDetalle;
    private FragmentLListat frgListado;
    private boolean tabletLayout;
    private Contacto[] contactos;

    public MainActivity() {
        super(R.layout.activity_main);
        frgListado = null;
        frgDetalle = null;
        tabletLayout = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabletLayout = findViewById(R.id.frDetalle) != null;
        ParseJSON parser = new ParseJSON(this);

        try {
            if(parser.parse()) {
                this.contactos = parser.getContactos();
            } else {
                Toast.makeText(this, "Error al obtener los contactos", Toast.LENGTH_LONG).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.frListado, FragmentLListat.class, null)
                .commit();
        manager.addFragmentOnAttachListener((this));

    }


    @Override
    public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        if (fragment.getId() == R.id.frListado) {
            frgListado = (FragmentLListat) fragment;
            frgListado.setContactosListener(contactos,this);
            if (tabletLayout) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(FragmentDetall.TEXTO_CONTACTO,contactos);
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.frDetalle, FragmentDetall.class, bundle)
                        .commit();
            }
        }
        if (fragment.getId() == R.id.frDetalle) {
            frgDetalle = (FragmentDetall) fragment;
        }
    }

    @Override
    public void onContactoSelecionado(int id) {
        Contacto contacto = contactos[id];
        if (tabletLayout) {
            frgDetalle.mostrarDetalle(contacto);
        } else {
            Intent i = new Intent(this,DetallerActivity.class);
            i.putExtra(DetallerActivity.EXTRA_TEXTO, contactos[id].getNombre());
            startActivity(i);
        }
    }
}