package com.example.tariqul.quiztest.DBHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tariqul.quiztest.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tariqul on 5/21/2015.
 */
public class DBHandler extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME = "db_quiz_test";
    public static final String TABLE_MATH="tb1_math";

    private static final String KEY_ID="id";
    private static final String KEY_QUESTION_ID="question_id";
    private static final String KEY_QUESTION="question";
    private static final String KEY_ANSWER_OPTION1="option1";
    private static final String KEY_ANSWER_OPTION2="option2";
    private static final String KEY_ANSWER_OPTION3="option3";
    private static final String KEY_ANSWER_OPTION4="option4";
    private static final String KEY_ANSWER="answer";

    SQLiteDatabase sqLiteDatabase;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_QUIZ_TABLE = "CREATE TABLE " +
                TABLE_MATH + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_QUESTION_ID
                + " TEXT," + KEY_QUESTION
                + " TEXT," + KEY_ANSWER_OPTION1
                + " TEXT," + KEY_ANSWER_OPTION2
                + " TEXT," + KEY_ANSWER_OPTION3
                + " TEXT," + KEY_ANSWER_OPTION4
                + " TEXT," + KEY_ANSWER
                + " TEXT" + ")";


        db.execSQL(CREATE_QUIZ_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATH);
        onCreate(db);
    }

    public void addQuestion(Question employee ){

        SQLiteDatabase sqLiteDatabase= super.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(KEY_QUESTION_ID, employee.getQuestionId());
        values.put(KEY_QUESTION, employee.getQuestion());
        values.put(KEY_ANSWER_OPTION1, employee.getOption1());
        values.put(KEY_ANSWER_OPTION2, employee.getOption2());
        values.put(KEY_ANSWER_OPTION3, employee.getOption3());
        values.put(KEY_ANSWER_OPTION4, employee.getOption4());
        values.put(KEY_ANSWER, employee.getAnswer());


        sqLiteDatabase.insert(TABLE_MATH, null, values);
        sqLiteDatabase.close();

    }
    public List<Question> getAllQuestion() {
        List<Question> questions = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_MATH;
        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setKey(Integer.parseInt(cursor.getString(0)));
                question.setQuestionId(cursor.getString(1));
                question.setQuestion(cursor.getString(2));
                question.setOption1(cursor.getString(3));
                question.setOption2(cursor.getString(4));
                question.setOption3(cursor.getString(5));
                question.setOption4(cursor.getString(6));
                question.setAnswer(cursor.getString(7));

                questions.add(question);

            } while (cursor.moveToNext());

        }
        return questions;
    }


}
