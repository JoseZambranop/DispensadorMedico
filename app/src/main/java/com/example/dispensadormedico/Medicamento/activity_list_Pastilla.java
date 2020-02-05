package com.example.dispensadormedico.Medicamento;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dispensadormedico.Medicamento.Pastilla;
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

public class activity_list_Pastilla extends AppCompatActivity implements Asynchtask {

    private List<Pastilla> items=new ArrayList<>();
    private RecyclerView recycle;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    VariablesGlobales vg=VariablesGlobales.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pastilla);

        /*Map<String, String> datos = new HashMap<String, String>();
            WebService ws= new WebService("http://radiant-thicket-98779.herokuapp.com/wsJSONListaPastilla.php",
                datos, activity_list_Pastilla.this, activity_list_Pastilla.this);
            ws.execute("");*/
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
                String gramos = c.getString("gramos");
                String idpastilla = c.getString("idpastilla");
                //String email = c.getString("correo");
                items.add(new Pastilla( name,gramos, idpastilla));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        recycle = (RecyclerView)findViewById(R.id.recycler_viewListPastilla);
        recycle.setHasFixedSize(true);

        lManager=new LinearLayoutManager(this);
        recycle.setLayoutManager(lManager);

        adapter= new PastillaAdapter(items);
        recycle.setAdapter(adapter);
    }
}
