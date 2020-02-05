package com.example.dispensadormedico;

public class VariablesGlobales {
    private static VariablesGlobales instance;

    private static String Nombre,Apellido, Correo, Clave;
    private static int Edad;

    public String getNombre() {
        return Nombre;
    }

    public static String getCorreo() {
        return Correo;
    }

    public static void setCorreo(String correo) {
        VariablesGlobales.Correo = correo;
    }

    public static String getClave() {
        return Clave;
    }

    public static void setClave(String clave) {
        Clave = clave;
    }

    public void setNombre(String nombre) {
        VariablesGlobales.Nombre = nombre;
    }

    public  String getApellido() {
        return Apellido;
    }

    public  void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        VariablesGlobales.Edad = edad;
    }
    public static  synchronized VariablesGlobales getInstance(){
        if(instance==null){
            instance=new VariablesGlobales();
        }
        return instance;
    }
}
