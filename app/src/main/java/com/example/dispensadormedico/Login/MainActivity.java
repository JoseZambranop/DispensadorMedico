package com.example.dispensadormedico.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dispensadormedico.R;
import com.example.dispensadormedico.VariablesGlobales;
import com.example.dispensadormedico.Menu.activity_menu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    VariablesGlobales vg = VariablesGlobales.getInstance();

    Button btnIniciar;
    EditText txtusuario, txtclave;
    TextView btnCrearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        btnIniciar = findViewById(R.id.btnIngresar);
        txtusuario = findViewById(R.id.txtUsuario);
        txtclave = findViewById(R.id.txtClave);

        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activity_CrearCuidador.class));
            }
        });
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Map<String, String> datos = new HashMap<String, String>();
                WebService ws= new WebService("https://radiant-thicket-98779.herokuapp.com/wsJSONLogin.php?correo="+txtusuario.getText().toString().trim()+"&clave="+txtclave.getText().toString(),
                        datos, MainActivity.this, MainActivity.this);
                ws.execute("");
                //String url = "https://radiant-thicket-98779.herokuapp.com/wsJSONLogin.php?correo="+txtusuario.getText().toString().trim()+"&clave="+txtclave.getText().toString();
                //Map<String, String> datos = new HashMap<String, String>();
                //WebService ws = new WebService(url, datos, MainActivity.this, MainActivity.this);
                //datos.put("correo",
                //datos.put("clave",txtclave.getText().toString());
                //ws.setDatos(datos);
                //ws.execute("");
            }
        });
    }

    @Override
    public void processFinish(String result) throws JSONException {

        Log.i("ProcessFinish",result);
        JSONObject jsonObject = new JSONObject(result);
        JSONArray objPacientes = jsonObject.getJSONArray("data");
        ArrayList<VariablesGlobales> Cuidador = new ArrayList<VariablesGlobales>();
        for (int i = 0; i < objPacientes.length(); i++) {
            JSONObject c = objPacientes.getJSONObject(i);
            VariablesGlobales ps = new VariablesGlobales();
            ps.setNombre(c.getString("nombre"));
            ps.setApellido(c.getString("apellido"));
            ps.setEdad(Integer.parseInt(c.getString("edad")));
            ps.setCorreo(c.getString("correo"));
            ps.setClave(c.getString("clave"));
            ps.setId(Integer.parseInt(c.getString("id")));
            Cuidador.add(ps);
        }
        startActivity(new Intent(MainActivity.this, activity_menu.class));
    }
}
   /* public void InicioSesion(String usuario,String clave){
        try {
            String storeProcedureCall="CALL sp_logg_android(?,?,?,?,?)";
            CallableStatement cStat=cnn.conexion().prepareCall(storeProcedureCall);
            // Parametros de entrada
            cStat.setString(1,usuario);
            cStat.setString(2,clave);
            //Parametros de salida
            cStat.registerOutParameter(3, Types.VARCHAR);
            cStat.registerOutParameter(4, Types.VARCHAR);
            //cStat.registerOutParameter(5, Types.INTEGER);
            cStat.registerOutParameter(5, Types.VARCHAR);

            cStat.executeUpdate();

            //variables declaradas que se recibe de la funcio postgresql
            String Nombre=cStat.getString(3);
            String Apellido=cStat.getString(4);
            //Integer edad=cStat.getInt(5);
            String msj=cStat.getString(5);
            if(msj.equals("OK")){
                vg.setNombre(Nombre);
                vg.setApellido(Apellido);
                //vg.setEdad(edad);
                Intent menu=new Intent(this,activity_menu.class);
                startActivity(menu);
            }else{
                Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
            }

        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }*/
