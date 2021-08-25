package com.example.waterfilter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener {
    TextView tv1, tv2;
    EditText un,ps;
    Button lgbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv1= (TextView)findViewById(R.id.textView);
        tv2= (TextView)findViewById(R.id.textView2);

        un= (EditText)findViewById(R.id.username);
        ps= (EditText)findViewById(R.id.password);

        lgbtn= (Button)findViewById(R.id.loginbtn);
        lgbtn.setOnClickListener(this);


    }

    private void addUserToSheet() {


        final ProgressDialog loading = ProgressDialog.show(this, "Adding User...", "Please wait.");

        final String name = un.getText().toString().trim();
        final String pass = ps.getText().toString().trim();

    }
   StringRequest stringRequest=new StringRequest(Request.Method.POST, "https://docs.google.com/spreadsheets/d/1lSBaJC-9I5jOVoUzCRyhi82cIIKCycDZ6hIK3lqOpns/edit#gid=0", new Response.Listener<String>() {
       @Override
       public void onResponse(String response) {
           loading.dismiss();
           Toast.makeText(Login.this, response, Toast.LENGTH_LONG).show();
           Intent intent = new Intent(getApplicationContext(), MainActivity.class);
           startActivity(intent);

   }
},new Response.ErrorListener() {
@Override
public void onErrorResponse(VolleyError error) {

        }
        }
        ) {
@Override
protected Map<String, String> getParams() {
        Map<String, String> parmas = new HashMap<>();

        //here we pass params
        parmas.put("action","addUser");
        parmas.put("username",un);
        parmas.put("password",ps);

        return parmas;
        }
        };

        int socketTimeOut = 50000;// u can change this .. here it is 50 seconds





@Override
public void onClick(View v) {

        if(v==loginbtn){
        addUserToSheet();

        //Define what to do when button is clicked
        }
        }
        }
