package com.cristobalbernal.contactofragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class DetallerActivity extends AppCompatActivity {
    public static final String EXTRA_TEXTO = "com.cristobalbernal.fragments.EXTRA_TEXTO";

    public DetallerActivity() {
        super(R.layout.activity_detalle);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            Contacto contacto = (Contacto) getIntent().getSerializableExtra(EXTRA_TEXTO);
            Bundle bundle = new Bundle();
            bundle.putString(FragmentDetall.TEXTO_CONTACTO, String.valueOf(contacto));
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.frDetalles, FragmentDetall.class, bundle)
                    .commit();

        }
    }
}
