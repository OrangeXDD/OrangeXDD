package com.example.victorina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    public static String[] txtQue = {"Сколько существует поколений покемонов?", "Сколько регионов в покемонах?", "Сколько лет Эшу", "Как зовут первого человека кто стал путешествывать с Эшем?",
    "Кто из девочек дольше всего путешествывал с Эшем?", "Сколько стартовиков есть к каждом регионе? Какие у них типы?", "Сколько эволюций у иви?", "Сколько типов может иметь один покемон?",
    "Сколько всего сезонов по понемонам?", "Какого покемона выбрал Эш в самом начале?"};

    public static String[] txtAns1 = {"6", "8", "8", "Брок", "Доун", "Четыре. Землянной, водяной, летающий и огненный", "8", "2", "19", "Бульбазавра"};
    public static String[] txtAns2 = {"4", "4", "10", "Мэй", "Серена", "Два. Нормальный и нормальный.", "9", "3", "6", "Чармандера"};
    public static String[] txtAns3 = {"3", "5", "12", "Минси", "Айрис", "Два. Боевой и призрачный.", "7", "1", "8", "Сквиртла"};
    public static String[] txtAns4 = {"8", "3", "14", "Мисти", "Не правильного", "Три. Огненный, водяной и травянной.", "6", "4", "15", "Пикачу"};

    public static String[] rightAnswer = {"6", "8", "10", "Мисти"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Викторина");
        Collections.shuffle(Collections.singletonList(txtQue));

        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TextQuestions.class);
                startActivity(intent);
            }
        });
    }
}