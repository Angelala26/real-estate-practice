package com.example.android.realestatepractice;

/**
 * Created by Angela on 9/26/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "realEstateQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "questionId";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA = "opta"; //option a
    private static final String KEY_OPTB = "optb"; //option b
    private static final String KEY_OPTC = "optc"; //option c
    private static final String KEY_OPTD = "optd"; //option d

    private SQLiteDatabase dbase;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT," + KEY_OPTD + " TEXT)";
        db.execSQL(sql);
        addQuestions(db);
        //db.close();
    }

    private void addQuestions(SQLiteDatabase db) {
        Question q1 = new Question("How many houses can I buy?",
                "one", "two", "three", "four",
                "one");
        this.addQuestion(q1, db);
        Question q2 = new Question("Which of the following is NOT an option ",
                "Apartments", "Houses", "Duplexes", "Rentals",
                "Rentals");
        this.addQuestion(q2, db);
        Question q3 = new Question("Which of the following is the fastest way of buying",
                "Credit card", "Loan", "Cash", "Handshakes",
                "Cash");
        this.addQuestion(q3, db);
        Question q4 = new Question("Should you use an agent or the internet",
                "Agent", "Internet", "Neither", "Both",
                "Agent");
        this.addQuestion(q4, db);
        Question q5 = new Question("Which of the following is not an available language",
                "English", "Italian", "Spanish", "Hungarian",
                "Spanish");
        this.addQuestion(q5, db);
        Question q6 = new Question("Question 6",
                "Answer 1", "Answer 2 - correct", "Answer 3", "Answer 4",
                "Answer 2 - correct");
        this.addQuestion(q6, db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
// Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question quest, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQuestion());
        values.put(KEY_ANSWER, quest.getAnswer());
        values.put(KEY_OPTA, quest.getOpta());
        values.put(KEY_OPTB, quest.getOptb());
        values.put(KEY_OPTC, quest.getOptc());
        values.put(KEY_OPTD, quest.getOptd());

        // Inserting Row
           db.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
            dbase = this.getReadableDatabase();
            Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    quest.setQuestionId(cursor.getInt(0));
                    quest.setQuestion(cursor.getString(1));
                    quest.setAnswer(cursor.getString(2));
                    quest.setOpta(cursor.getString(3));
                    quest.setOptb(cursor.getString(4));
                    quest.setOptc(cursor.getString(5));
                    quest.setOptd(cursor.getString(6));
                    quesList.add(quest);
                } while (cursor.moveToNext());
            }
        // return quest list
                cursor.close();
                dbase.close();
                return quesList;
            }

    public int rowcount() {
        int row = 0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();

        cursor.close();
        return row;
    }
}