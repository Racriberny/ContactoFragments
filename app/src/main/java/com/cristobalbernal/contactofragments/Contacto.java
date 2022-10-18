package com.cristobalbernal.contactofragments;

public class Contacto {
    private int id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String direccion;
    private String empresa;
    private String fechaNacimiento;
    private String telefono1;
    private String telefono2;
    private String email;




    public Contacto(int id, String nombre, String primerApellido, String segundoApellido, String direccion, String empresa, String fechaNacimiento, String telefono1, String telefono2, String email) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.empresa = empresa;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public String getEmail() {
        return email;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", empresa='" + empresa + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", telefono1='" + telefono1 + '\'' +
                ", telefono2='" + telefono2 + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
