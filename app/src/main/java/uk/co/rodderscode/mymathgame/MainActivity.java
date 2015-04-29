package uk.co.rodderscode.mymathgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_play = (Button)findViewById(R.id.btn_play);
        btn_play.setOnClickListener(this);
    }


    @Override
    public void onClick(View view){
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }



}
