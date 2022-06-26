package com.example.victorina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;

public class TextQuestions extends AppCompatActivity {
    ListView answer;
    TextView que1;
    String[] ans = new String[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_textquestions);
        answer = findViewById(R.id.answer);
        que1 = findViewById(R.id.que1);

        que1.setText(MainActivity.txtQue[0]);

        ans[0] = MainActivity.txtAns1[0];
        ans[1] = MainActivity.txtAns2[0];
        ans[2] = MainActivity.txtAns3[0];
        ans[3] = MainActivity.txtAns4[0];

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ans);
        answer.setAdapter(adapter);


        answer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int j = 0;
            }
        });
    }
}