package com.example.dispensadormedico.Horario;

import java.sql.Time;
import java.sql.Date;

public class Horario {
    private String Fecha;
    private String Hora;

    public Horario(String fecha, String hora) {
        Fecha = fecha;
        Hora = hora;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }
}