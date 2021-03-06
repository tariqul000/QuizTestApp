package com.example.tariqul.quiztest;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tariqul.quiztest.DBHandler.DBHandler;
import com.example.tariqul.quiztest.GamePlay.FunctionGamePlay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    TextView tvQuestion, tvCorrectAnswer;
    RadioButton r1, r2, r3, r4;

    RadioGroup radioGroup;
    ListView lv;

    DBHandler db;
    List<Question> values;
    String correctAnswer;
    private Question currentQ;
    private FunctionGamePlay currentGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E35E35")));

        init();

        db= new DBHandler(this);
        lv=(ListView)findViewById(R.id.Lv);

        values = db.getAllQuestion();

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Question> adapter = new ArrayAdapter<Question>(this,
                android.R.layout.simple_list_item_1, values);
        lv.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        questionResize();

   }

    private void init() {
        tvQuestion=(TextView)findViewById(R.id.question);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);


        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        r4=(RadioButton)findViewById(R.id.r4);

        tvCorrectAnswer=(TextView)findViewById(R.id.tvCorrectAnswer);


        currentGame=new FunctionGamePlay();

    }


    public void questionResize(){

        values=db.getAllQuestion();
        currentGame.setQuestions(values);


        for (int i = 0; i < values.size(); i++) {

            tvQuestion.setText(values.get(i).getQuestion());

            r1.setText(values.get(i).getOption1().trim());
            r2.setText(values.get(i).getOption2().trim());
            r3.setText(values.get(i).getOption3().trim());
            r4.setText(values.get(i).getOption4().trim());

            correctAnswer=values.get(i).getAnswer().trim();

            }
    }

    public void ShowResult(View view){



        int selectedId= radioGroup.getCheckedRadioButtonId();
        if (selectedId==r1.getId())
        {


            if (r1.getText().toString().equalsIgnoreCase(correctAnswer)){

                tvCorrectAnswer.setText("Your Answer is Correct:"+r1.getText());
            }  else {
                Toast.makeText(getApplicationContext(),"Your Answer is wrong:", Toast.LENGTH_LONG).show();
                tvCorrectAnswer.setText("Your Answer is wrong:" + r1.getText());
            }

        }else  if (selectedId==r2.getId())
        {


            if (r2.getText().toString().equalsIgnoreCase(correctAnswer)){
                tvCorrectAnswer.setText("Your Answer is Correct:"+r2.getText());
            }
            else {
                Toast.makeText(getApplicationContext(),"Your Answer is wrong:", Toast.LENGTH_LONG).show();
                tvCorrectAnswer.setText("Your Answer is wrong:"+r2.getText());
            }
        }
        else  if (selectedId==r3.getId())
        {


            if (r3.getText().toString().equalsIgnoreCase(correctAnswer)){
                tvCorrectAnswer.setText("Your Answer is Correct:"+r3.getText());
            }
            else {
                Toast.makeText(getApplicationContext(),"Your Answer is wrong:", Toast.LENGTH_LONG).show();
                tvCorrectAnswer.setText("Your Answer is wrong:"+r3.getText());
            }
        }
        else  if (selectedId==r4.getId())
        {


            if (r4.getText().toString().equalsIgnoreCase(correctAnswer)){
                tvCorrectAnswer.setText("Your Answer is Correct:"+r4.getText());
            }
            else {
                Toast.makeText(getApplicationContext(),"Your Answer is wrong:", Toast.LENGTH_LONG).show();
                tvCorrectAnswer.setText("Your Answer is wrong:"+r4.getText());
            }
        }

    }
      public void Next(View view) {


          switch (view.getId()) {
              case R.id.next:

                  int round=0;
                  values= db.getAllQuestion();
                  Question question= values.get(round);
                  round++;
                  tvQuestion.setText(question.getQuestion());
               /*values=db.getAllQuestion();
                  //for (int i = 0; i < values.size(); i++) {*//*
               *//*       Random random = new Random();
                   String[] question= values.get(i).getQuestion().length();
                     int questi=random.nextInt(question);*//*

                      currentGame=new FunctionGamePlay();

                  for (int i = 0; i < values.size(); i++) {
                      int j=i-1;

                      currentQ = currentGame.getNextQuestion(values);


                      tvQuestion.setText(currentQ.getQuestion());

                      r1.setText(currentQ.getOption1().trim());
                      r2.setText(currentQ.getOption2().trim());
                      r3.setText(currentQ.getOption3().trim());
                      r4.setText(values.get(j).getOption4());

                      correctAnswer = currentQ.getAnswer().trim();
                  }
               *//*   List<Question> questions = new ArrayList<>();*/

                  Random random1 = new Random();
                  String[] mTestArray  =   getResources().getStringArray(R.array.planets_array);
                  TextView textView = (TextView)findViewById(R.id.tvCorrectAnswer);
                  int maxIndex = mTestArray.length;
                  int generatedIndex = random1.nextInt(maxIndex);

                  textView.setText(mTestArray[generatedIndex]);

          }
      }
    private void DisplayContact(Cursor c) {
        tvQuestion.setText(c.getString(2));
        r1.setText(c.getString(3));
        r2.setText(c.getString(3));
        r3.setText(c.getString(4));
        r4.setText(c.getString(5));
    }

       @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(this, AddQuestion.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
