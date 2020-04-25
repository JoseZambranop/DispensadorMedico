package com.example.dispensadormedico.Paciente;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dispensadormedico.AdultosMayores.activity_list_adult;
import com.example.dispensadormedico.R;
import com.example.dispensadormedico.VariablesGlobales;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class activity_CrearPaciente extends AppCompatActivity implements Asynchtask {
    private TextView nombre,apellido,edad,correo,clave;
    private Button btnCrearPaciente;
    VariablesGlobales vg=VariablesGlobales.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__crear_paciente);
        getSupportActionBar().hide();

        nombre=findViewById(R.id.txtNombrePac);
        apellido=findViewById(R.id.txtApellidoPac);
        edad=findViewById(R.id.txtEdadPac);
        correo=findViewById(R.id.txtCorreoPac);
        clave=findViewById(R.id.txtClavePac);
        btnCrearPaciente=findViewById(R.id.btnCrearPac);

        btnCrearPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://radiant-thicket-98779.herokuapp.com/wsJSONCrearPaciente.php?nombre="+
                        nombre.getText().toString()+"&apellido="+apellido.getText().toString()+"&edad="+45
                        +"&correo="+correo.getText().toString()+"&clave="+clave.getText().toString()+"&idCuidador="+vg.getId();
                Map<String, String> datos = new HashMap<String, String>();
                WebService ws= new WebService(url,
                        datos, activity_CrearPaciente.this, activity_CrearPaciente.this);
                ws.execute("");

                startActivity(new Intent(activity_CrearPaciente.this, activity_list_adult.class));
            }
        });

    }

    @Override
    public void processFinish(String result) throws JSONException {

    }
}
