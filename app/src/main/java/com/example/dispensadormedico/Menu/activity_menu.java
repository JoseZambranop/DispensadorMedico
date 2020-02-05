package com.example.dispensadormedico.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dispensadormedico.Medicamento.activity_list_Pastilla;
import com.example.dispensadormedico.R;
import com.example.dispensadormedico.VariablesGlobales;
import com.example.dispensadormedico.Login.activity_CrearCuidador;
import com.example.dispensadormedico.AdultosMayores.activity_list_adult;

public class activity_menu extends AppCompatActivity {
    VariablesGlobales vg=VariablesGlobales.getInstance();
    TextView txtNombre,txtApellido,txtEdad;
    LinearLayout btnAdultoMayor;
    LinearLayout btnPastillero;
    LinearLayout btnMedicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnAdultoMayor = findViewById(R.id.btn_AdultosMayor);
        btnPastillero=findViewById(R.id.btn_Dispenser);
        btnMedicine=findViewById(R.id.btn_medicines);

        txtNombre=findViewById(R.id.IdUsuario);
        txtNombre.setText(vg.getNombre()+" "+vg.getApellido());
       /* txtApellido=findViewById(R.id.txtpApellido);
        txtEdad=findViewById(R.id.txtpEdad);


        txtApellido.setText(vg.getApellido().toString());
        txtEdad.setText(String.valueOf(vg.getEdad()));*/

        btnPastillero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_menu.this, activity_CrearCuidador.class));
            }
        });
        btnAdultoMayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_menu.this, activity_list_adult.class));
            }
        });
        btnMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_menu.this, activity_list_Pastilla.class));
            }
        });

    }

}
