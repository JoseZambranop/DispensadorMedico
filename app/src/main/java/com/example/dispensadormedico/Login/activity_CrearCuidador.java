package com.example.dispensadormedico.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dispensadormedico.AdultosMayores.activity_list_adult;
import com.example.dispensadormedico.R;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class activity_CrearCuidador extends AppCompatActivity implements Asynchtask {

    private TextView nombre,apellido,edad,correo,clave;
    private Button btnCrearCuidador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__crear_cuidador);

        nombre=findViewById(R.id.txtNombreCcuidador);
        apellido=findViewById(R.id.txtApellidoCcuidador);
        edad=findViewById(R.id.txtEdadCcuidador);
        correo=findViewById(R.id.txtCorreoCcuidador);
        clave=findViewById(R.id.txtClaveCcuidador);
        btnCrearCuidador=findViewById(R.id.btnCrearCuidadorA);

        btnCrearCuidador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://radiant-thicket-98779.herokuapp.com/wsJSONCrearCuidador.php?nombre="+
                nombre.getText().toString()+"&apellido="+apellido.getText().toString()+"&edad="+45
                        +"&correo="+correo.getText().toString()+"&clave="+clave.getText().toString();
                Map<String, String> datos = new HashMap<String, String>();
                WebService ws= new WebService(url,
                        datos, activity_CrearCuidador.this, activity_CrearCuidador.this);
                ws.execute("");

                startActivity(new Intent(activity_CrearCuidador.this, MainActivity.class));
            }
        });

    }

    @Override
    public void processFinish(String result) throws JSONException {

    }
}
