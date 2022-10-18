package com.cristobalbernal.contactofragments;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class ParseJSON {
    private Contacto[] contactos;
    private final InputStream archivosContacto;

    public ParseJSON(Context context){
        this.archivosContacto = context.getResources().openRawResource(R.raw.contacts);
    }

    public boolean parse() throws IOException, JSONException {
        boolean parsed;
        contactos = null;
        StringBuilder stringBuilder = new StringBuilder();
        String json;
        int size = archivosContacto.available();
        byte[] buffer = new byte[size];
        archivosContacto.read(buffer);
        archivosContacto.close();
        json = new String(buffer,"UTF-8");
        JSONTokener tokener = new JSONTokener(json);
        JSONArray array = new JSONArray(tokener);
        contactos = new Contacto[array.length()];

        for (int i = 0; i <array.length() ; i++) {
            stringBuilder.setLength(0);
            String nombre = array.getJSONObject(i).getString("name");
            String firstSurname = array.getJSONObject(i).getString("firstSurname");
            String secondSurname = array.getJSONObject(i).getString("secondSurname");
            String birth = array.getJSONObject(i).getString("birth");
            String company = array.getJSONObject(i).getString("company");
            String email = array.getJSONObject(i).getString("email");
            String phone1 = array.getJSONObject(i).getString("phone1");
            String phone2 = array.getJSONObject(i).getString("phone2");
            String address = array.getJSONObject(i).getString("address");
            contactos[i] = new Contacto(i,nombre,firstSurname,secondSurname,address,company,birth,phone1,phone2,email);
        }
        parsed = true;
        return parsed;
    }

    public Contacto[] getContactos() {
        return this.contactos;
    }
}
