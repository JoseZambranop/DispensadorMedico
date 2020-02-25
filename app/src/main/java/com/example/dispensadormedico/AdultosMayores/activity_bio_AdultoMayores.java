package com.example.dispensadormedico.AdultosMayores;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dispensadormedico.Horario.Horario;
import com.example.dispensadormedico.Horario.HorarioAdapter;
import com.example.dispensadormedico.Login.Person;
import com.example.dispensadormedico.R;
import com.example.dispensadormedico.VariablesGlobales;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class activity_bio_AdultoMayores extends AppCompatActivity implements Asynchtask {
    private TextView nombrebio;
    private TextView idbio;

    private List<Horario> items=new ArrayList<>();
    private RecyclerView recycle;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    VariablesGlobales vg=VariablesGlobales.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        nombrebio= findViewById(R.id.txtnombreadulto);
        idbio=findViewById(R.id.txtidadulto);
        //imagen=(ImageView)findViewById(R.id.Imagen);

        nombrebio.setText(getIntent().getExtras().getString("ctnombre"));
        idbio.setText(getIntent().getExtras().getString("ctid"));
        //bio.setText(getIntent().getExtras().getString("curBio"));
        //imagen.setImageResource(getIntent().getExtras().getInt("curImagen"));
        //this.setEvents(R.id.donow);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://radiant-thicket-98779.herokuapp.com/wsJSONListaHorarios.php?IdPaciente="+(Integer.parseInt(getIntent().getExtras().getString("ctid")))+"&IdCuidador="+(vg.getId()),
                datos, activity_bio_AdultoMayores.this, activity_bio_AdultoMayores.this);
        ws.execute("");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        Log.i("ProcessFinish",result);

        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray contacts = jsonObject.getJSONArray("data");
            for (int i = 0; i < contacts.length(); i++) {
                JSONObject c = contacts.getJSONObject(i);
                String hora = c.getString("hora");
                String Fecha = c.getString("fecha");
                String Validacion = c.getString("validacion");
                items.add(new Horario(Fecha,hora ));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        recycle = (RecyclerView)findViewById(R.id.rcvHorario);
        recycle.setHasFixedSize(true);

        lManager=new LinearLayoutManager(this);
        recycle.setLayoutManager(lManager);

        adapter= new HorarioAdapter(items);
        recycle.setAdapter(adapter);
    }
/*
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.donow){
            w1(new Integer(10));
            establecer(0);
        }

    }
    public void w1(long v){
        try {
            StrictMode.ThreadPolicy s;
            Thread.sleep(v*1000);
        }catch (Exception e){}
    }
    private void setEvents(int redid ){
        Button btn=findViewById(R.id.donow);
        btn.setOnClickListener(this);
    }
    private void establecer(int when){
        AlarmManager manager=(AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        NotificationCompat.Builder note= new NotificationCompat.Builder(getApplicationContext());
        note.setSmallIcon(android.R.drawable.sym_def_app_icon).setContentTitle("Alarm").setContentText("")
        .setTicker("Alarma").setColor(Color.BLACK);
        NotificationManager man=(NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        man.notify(1,note.build());
    }*/
}
