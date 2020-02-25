package com.example.dispensadormedico.Medicamento;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dispensadormedico.AdultosMayores.activity_list_adult;
import com.example.dispensadormedico.Paciente.activity_CrearPaciente;
import com.example.dispensadormedico.R;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class activity_CrearPastilla extends AppCompatActivity implements Asynchtask {

    private TextView nombre,gramos;
    private Button btnCrearPastilla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__crear_pastilla);
        nombre=findViewById(R.id.txtNombrePast);
        gramos=findViewById(R.id.txtGramosPast);

        btnCrearPastilla=findViewById(R.id.btnCrearPastilla);

        btnCrearPastilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://radiant-thicket-98779.herokuapp.com/wsJSONCrearPastilla.php?nombre="+
                        nombre.getText().toString()+"&gramos="+gramos.getText().toString();
                Map<String, String> datos = new HashMap<String, String>();
                WebService ws= new WebService(url,datos, activity_CrearPastilla.this, activity_CrearPastilla.this);
                ws.execute("");

                startActivity(new Intent(activity_CrearPastilla.this, activity_list_Pastilla.class));
            }
        });


    }
    @Override
    public void processFinish(String result) throws JSONException {

    }
}
