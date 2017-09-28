package com.example.android.realestatepractice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.widget.Toast.makeText;
import static com.example.android.realestatepractice.R.id.question;

public class PracticeTest extends AppCompatActivity {

    List<Question> quesList;
    TextView mQuestionTextView;
    Button buttonChoice1;
    Button buttonChoice2;
    Button buttonChoice3;
    Button buttonChoice4;
    Button nextButton;
    Question currentQuestion;
    int mQuestionId;
    int mIndex;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_test);

        //access the database and get the questions
        DbHelper db = new DbHelper(this);
        quesList = db.getAllQuestions();
        currentQuestion = quesList.get(mQuestionId);


        //load the saved instance state if the app is closed or flipped to landscape mode
        if (savedInstanceState != null) {
            //load the score and index of question
            mIndex = savedInstanceState.getInt("IndexKey");
        } else {
            //user starting from scratch, so...
            mIndex = 0;
        }

        mQuestionTextView = (TextView) findViewById(question);
        buttonChoice1 = (Button) findViewById(R.id.answer1);
        buttonChoice2 = (Button) findViewById(R.id.answer2);
        buttonChoice3 = (Button) findViewById(R.id.answer3);
        buttonChoice4 = (Button) findViewById(R.id.answer4);
        nextButton = (Button) findViewById(R.id.next_button);

        //link the question with the text view
        setQuestionView();

        //when the next button is clicked, check the answer
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });
    }

    private void checkAnswer() {
        //find the group of potential answers and link it to the id
        RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
        //if the current question's answer equals the user's answer, make a toast that says correct,
        //  add 1 point to the score, and set the boolean setAnsweredCorrectly as true
        if (currentQuestion.getAnswer().equals(answer.getText().toString())) {
            //make the boolean true for setAnsweredCorrectly() so we can pull the wronly answered
            // questions later
            currentQuestion.setAnsweredCorrectly();

            Toast toast = makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

            score++;
            Log.d("score", "Your score"+score);
        } else {
            //otherwise, create an alert that shows the questions with the correct answer
            AlertDialog.Builder builder = new AlertDialog.Builder(PracticeTest.this);
            builder.setTitle("Incorrect");
            builder.setMessage(currentQuestion.getQuestion() +
                    "\n\nYour answer: " + answer.getText().toString() +
                    "\n Correct answer: " + currentQuestion.getAnswer());
            builder.setCancelable(false);
            builder.setPositiveButton("Continue",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();

            //TODO: if the answer is incorrect, save this question with the correct answer
            //TODO: and print something telling the user that it's wrong and the correct answer


            //if there are no more questions, go to the result activity with the score
            // and wrongly answered questions
        } if (mQuestionId < quesList.size()) {
            currentQuestion = quesList.get(mQuestionId);
            setQuestionView();
            Log.d("debug ", "mQuestionId: " + currentQuestion);
            Log.d("debug ", "questList.size: " + quesList.size());
        } else {
            Log.d("debug ", "mQuestionId: " + currentQuestion);
            Log.d("debug ", "questList.size: " + quesList.size());
            //go to result activity with the score
            Intent intent = new Intent(PracticeTest.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            b.putInt("questListSize", quesList.size());
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        }

    }

    //We need this method so we can load it when someone switches to landscape mode
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("IndexKey", mIndex);
    }

    private void setQuestionView() {
        mQuestionTextView.setText(currentQuestion.getQuestion());
        buttonChoice1.setText(currentQuestion.getOpta());
        buttonChoice2.setText(currentQuestion.getOptb());
        buttonChoice3.setText(currentQuestion.getOptc());
        buttonChoice4.setText(currentQuestion.getOptd());
        mQuestionId++;
    }

}
