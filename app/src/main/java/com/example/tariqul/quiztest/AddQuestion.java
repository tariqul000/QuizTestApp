package com.example.tariqul.quiztest;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.tariqul.quiztest.DBHandler.DBHandler;


public class AddQuestion extends ActionBarActivity {

    EditText etQuestionId, etQuestion, etOption1, etOption2, etOption3, etOption4, etAnswer;

    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        init();
    }

    private void init() {

        db=new DBHandler(this);

        etQuestionId= (EditText) findViewById(R.id.etQuestionId);
        etQuestion= (EditText) findViewById(R.id.etQuestion);
        etOption1= (EditText) findViewById(R.id.etOption1);
        etOption2= (EditText) findViewById(R.id.etOption2);
        etOption3= (EditText) findViewById(R.id.etOption3);
        etOption4= (EditText) findViewById(R.id.etOption4);
        etAnswer= (EditText) findViewById(R.id.etAnswer);
   }
public void submit(View view){

    String questionId=etQuestionId.getText().toString();
    String question=etQuestion.getText().toString();
    String option1=etOption1.getText().toString();
    String option2=etOption2.getText().toString();
    String option3=etOption3.getText().toString();
    String option4=etOption4.getText().toString();
    String answer=etAnswer.getText().toString();

    Question question1= new Question(questionId, question, option1, option2, option3, option4, answer);

    db.addQuestion(question1);
    db.close();

    Intent intent= new Intent(this, MainActivity.class);
    startActivity(intent);

}
}
