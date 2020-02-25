package com.example.dispensadormedico.Login;

public class Person {
    private String nombre;
    private String edad;
    private String imagen;
    private String correo;
    private String id;


    public Person(String imagen, String nombre, String correo, String edad,String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.imagen = imagen;
        this.correo=correo;
        this.id=id;
    }

    public Person(String nombre, String edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.imagen = imagen;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }


    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
/* public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }*/
}
