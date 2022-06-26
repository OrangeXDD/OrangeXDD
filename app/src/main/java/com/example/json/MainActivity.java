package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6;
    ListView list;
    Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        list = findViewById(R.id.list);
        create = findViewById(R.id.create);
        try {
            t1.setText(getString(R.string.simple_json));
            String json_source = getString(R.string.simple_json);
            JSONObject jsonObject = new JSONObject(json_source);
            t2.setText("jsonObject:\n" + jsonObject.toString());
            JSONObject results = jsonObject.getJSONObject("results");
            t3.setText("results:\n" + results.toString());
            String mySiteName = results.getString("site_name");
            String myUrl = results.getString("url");
            t4.setText("Имя сайта:\n" + mySiteName);
            t5.setText("Адрес сайта:\n" + myUrl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try{
            JSONObject jsonObject = new JSONObject(getString(R.string.simple_json2));
            JSONObject results = jsonObject.getJSONObject("results");
            String mySiteName = results.getString("site_name");
            String myUrl = results.getString("url");
            t4.setText("Имя сайта:\n" + mySiteName);
            t5.setText("Адрес сайта:\n" + myUrl);

            JSONArray jsonArray = results.getJSONArray("array");
            String stringArrayElement = "\n";
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject arrayElement = jsonArray.getJSONObject(i);
                stringArrayElement += arrayElement.getString("element") + "\n";
            }
            t6.setText(stringArrayElement);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private JSONArray createJSON() throws JSONException {
        ArrayList<JSONObject> jsonArrayList = new ArrayList<>();
        JSONObject object;
        object = new JSONObject();
        object.put("MemberID", "1");
        object.put("Name", "Константин");
        object.put("Tel", "8-495-4876-107");
        jsonArrayList.add(object);
        JSONArray jsonArray = new JSONArray(jsonArrayList);
        return jsonArray;
    }
    public void onClick(View view) {
        try{
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            JSONArray data = createJSON();
            HashMap<String, String> map;
            for (int i = 0; i < data.length(); i++) {
                JSONObject jsonObject = data.getJSONObject(i);
                map = new HashMap<>();
                map.put("MemberID", jsonObject.getString("MemberID"));
                map.put("Name", jsonObject.getString("Name"));
                map.put("Tel", jsonObject.getString("Tel"));
                arrayList.add(map);
            }
            SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.list, new String[]{"MemberID","Name", "Tel"},  new int[]{R.id.memId, R.id.name, R.id.tel});
            list.setAdapter(simpleAdapter);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}