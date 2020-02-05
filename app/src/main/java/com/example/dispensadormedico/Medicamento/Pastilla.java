package com.example.dispensadormedico.Medicamento;

public class Pastilla {
    private String nombre;
    private String imagen;
    private String gramos;
    private String idPastilla;


    public Pastilla(String nombre, String gramos) {
        this.nombre = nombre;
        this.gramos = gramos;
    }

    public Pastilla(String imagen,String nombre,  String gramos, String idPastilla) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.gramos = gramos;
        this.idPastilla = idPastilla;
    }

    public Pastilla(String nombre, String gramos, String idPastilla) {
        this.nombre = nombre;
        this.gramos = gramos;
        this.idPastilla = idPastilla;
    }

    public String getIdPastilla() {
        return idPastilla;
    }

    public void setIdPastilla(String idPastilla) {
        this.idPastilla = idPastilla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getGramos() {
        return gramos;
    }

    public void setGramos(String gramos) {
        this.gramos = gramos;
    }
}
