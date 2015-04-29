package uk.co.rodderscode.mymathgame;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class GameActivity extends Activity implements View.OnClickListener {

    int correctAnswer;
    int correctAnswers, wrongAnswers = 0;

    Button btnObjectChoice1;
    Button btnObjectChoice2;
    Button btnObjectChoice3;
    TextView result;
    TextView number1;
    TextView number2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //grabbing the views
        result = (TextView) findViewById(R.id.result);
        number1 = (TextView) findViewById(R.id.number1);
        number2 = (TextView) findViewById(R.id.number2);
        btnObjectChoice1 = (Button) findViewById(R.id.buttonChoice1);
        btnObjectChoice2 = (Button) findViewById(R.id.buttonChoice2);
        btnObjectChoice3 = (Button) findViewById(R.id.buttonChoice3);

        //setting the listeners for these buttons to callback this class
        btnObjectChoice1.setOnClickListener(this);
        btnObjectChoice2.setOnClickListener(this);
        btnObjectChoice3.setOnClickListener(this);

        this.reset();
    }

    private void reset(){
        Random random = new Random();
        int partA = random.nextInt(9)+1;
        int partB = random.nextInt(9)+1;
        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 1;
        int wrongAnswer2 = correctAnswer + 1;

        result.setText("");
        number1.setText(""+partA);
        number2.setText(""+partB);
        btnObjectChoice1.setText(""+wrongAnswer1);
        btnObjectChoice2.setText(""+correctAnswer);
        btnObjectChoice3.setText(""+wrongAnswer2);

        Log.i("correctAnswer", ""+correctAnswer);
    }

    @Override
    public void onClick(View view){
        int answerGiven = 0;

        switch (view.getId()){
            case R.id.buttonChoice1:
                answerGiven = Integer.parseInt((String)btnObjectChoice1.getText() );
                break;
            case R.id.buttonChoice2:
                answerGiven = Integer.parseInt((String)btnObjectChoice2.getText() );
                break;
            case R.id.buttonChoice3:
                answerGiven = Integer.parseInt((String)btnObjectChoice3.getText() );
                break;
        }

        if (answerGiven == correctAnswer){
            result.setText("Correct!");
            correctAnswers++;
        }else {
            result.setText("No... sorry");
            wrongAnswers++;
        }

        this.reset();
    }



}
