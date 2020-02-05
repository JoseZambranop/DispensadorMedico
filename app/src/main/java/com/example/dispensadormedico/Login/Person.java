package com.example.dispensadormedico.Login;

public class Person {
    private String nombre;
    private String dni;
    private String edad;
    private String bio;
    private String imagen;
    private String correo;

    public Person(String imagen, String nombre, String correo, String edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.imagen = imagen;
        this.correo=correo;
    }

    public Person(String nombre, String edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.imagen = imagen;
        this.correo = correo;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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
