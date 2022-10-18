package com.cristobalbernal.contactofragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorContacto extends RecyclerView.Adapter<AdaptadorContacto.ContactViewHolder> {
    private final Contacto[] contactos;
    private final IContactoLister listener;


    public AdaptadorContacto(Contacto[] contactos,IContactoLister lister) {
        this.contactos = contactos;
        this.listener = lister;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_contacto,parent,false);
        return new ContactViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contacto contacto = contactos[position];
        holder.bindContacto(contacto);
    }

    @Override
    public int getItemCount() {
        return contactos.length;
    }


    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView nombre;
        private final TextView apellidos;
        private final TextView direcion;
        private final TextView empresa;
        private final TextView fechaNacimiento;
        private final TextView tel1;
        private final TextView tel2;
        private final TextView email;
        private final IContactoLister lister;
        public ContactViewHolder(@NonNull View itemView, IContactoLister lister) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            apellidos = itemView.findViewById(R.id.tvApellidos);
            direcion = itemView.findViewById(R.id.tvDirecion);
            empresa = itemView.findViewById(R.id.tvEmpresa);
            fechaNacimiento = itemView.findViewById(R.id.tvFecha);
            tel1 = itemView.findViewById(R.id.tvTelf1);
            tel2 = itemView.findViewById(R.id.tvTel2);
            email = itemView.findViewById(R.id.tvEmail);
            this.lister = lister;
            itemView.setOnClickListener(this);
        }

        public void bindContacto(Contacto contacto) {
            nombre.setText(contacto.getNombre());
            apellidos.setText(contacto.getPrimerApellido());
            direcion.setText(contacto.getDireccion());
            empresa.setText(contacto.getEmpresa());
            fechaNacimiento.setText(contacto.getFechaNacimiento());
            tel1.setText(contacto.getTelefono1());
            tel2.setText(contacto.getTelefono2());
            email.setText(contacto.getEmail());
        }

        @Override
        public void onClick(View view) {
            if (lister != null){
                lister.onContactoSelecionado(getAdapterPosition());
            }
        }
    }
}
