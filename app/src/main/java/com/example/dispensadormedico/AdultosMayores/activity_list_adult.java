package com.example.dispensadormedico.AdultosMayores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dispensadormedico.Login.Person;
import com.example.dispensadormedico.Paciente.activity_CrearPaciente;
import com.example.dispensadormedico.R;
import com.example.dispensadormedico.VariablesGlobales;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class activity_list_adult extends AppCompatActivity implements Asynchtask {

    private List<Person> items=new ArrayList<>();
    private RecyclerView recycle;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private Button btnAgregarPac;
    VariablesGlobales vg=VariablesGlobales.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adult);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("http://radiant-thicket-98779.herokuapp.com/wsJSONListaPacientes.php?correo="+vg.getCorreo().toString()+"&clave="+vg.getClave().toString(),
                datos, activity_list_adult.this, activity_list_adult.this);
        ws.execute("");
        btnAgregarPac=findViewById(R.id.btnAgregarPaciente);
        btnAgregarPac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_list_adult.this, activity_CrearPaciente.class));
            }
        });
    }

    @Override
    public void processFinish(String result) throws JSONException {
        Log.i("ProcessFinish",result);

        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray contacts = jsonObject.getJSONArray("data");
            for (int i = 0; i < contacts.length(); i++) {
                JSONObject c = contacts.getJSONObject(i);
                String name = c.getString("nombre");
                String apellido = c.getString("apellido");
                String edad = c.getString("edad");
                String email = c.getString("correo");
                String idP=c.getString("idpac");
                    items.add(new Person("https://i.pinimg.com/originals/b9/af/76/b9af76545802b866b580a3db059fb8c8.png", name+" "+apellido, email, edad,idP));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        recycle = (RecyclerView)findViewById(R.id.recycler_viewList);
        recycle.setHasFixedSize(true);

        lManager=new LinearLayoutManager(this);
        recycle.setLayoutManager(lManager);

        adapter= new ContactosAdapter(items);
        recycle.setAdapter(adapter);
    }
}
