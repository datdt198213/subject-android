package com.dat.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    ArrayList<Person> personList;
    ArrayAdapter<Person> listAdapter;
    Handler mainHandler = new Handler() {
        @Override
        public void publish(LogRecord logRecord) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };
    ProgressDialog progressDialog;
    ListView lv;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUserList();
        lv.findViewById(R.id.dynamic);
        bt.findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new fetchData().start();
            }
        });

    }

    private void initializeUserList() {
        personList = new ArrayList<Person>();
        listAdapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, personList);
        lv.setAdapter(listAdapter);
    }

    class fetchData extends Thread{
        String data ="";
        public void run(){

            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setMessage("Fetching data");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                }
            });

            try {
                URL url = new URL("https://lebavui.github.io/jsons/users.json");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;

                while ((line = bufferedReader.readLine()) != null){
                    data = data + line;
                }

                if(!data.isEmpty()){
                    JSONObject jsonObject = new JSONObject(data);
                    JSONArray users = jsonObject.getJSONArray(null);
                    for(int i=0; i<users.length(); i++){
                        JSONObject persons = users.getJSONObject(i);
                        personList.clear();

//                        Object address =persons.getJSONObject("address");
                        JSONObject avatar = persons.getJSONObject("avatar");
                        String name = persons.getString("name");
                        String email = persons.getString("email");
                        String phone = persons.getString("phone");
                        JSONObject address = persons.getJSONObject("address");

                        personList.add(name);
                        personList.add(email);
                        personList.add(phone);
                        personList.add(avatar);
                        personList.add(address);

                    }
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    if(progressDialog.isShowing()){
                        progressDialog.dismiss();
                    }
                    listAdapter.notifyDataSetChanged();
                }
            });
        }
    }
}