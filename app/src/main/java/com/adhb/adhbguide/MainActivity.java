package com.adhb.adhbguide;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    public final static String PIN = "123";
    public final static String PIN_ERROR = "The inout pin is not authorized. Please try again.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Called when the user clicks the submit button.
    //Check if the pin is authorized.
    public void checkPin(View view){

        EditText editText = (EditText)findViewById(R.id.main_inputPin);
        String inputPin = editText.getText().toString();
        if(inputPin.equalsIgnoreCase(PIN)) {
            Intent intent = new Intent(this, DisplayHomePageActivity.class);
            startActivity(intent);
        }
        else {
            showError(PIN_ERROR);
        }
    }

    private void showError(String error){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(error);
        alertDialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id){
                dialog.cancel();
            }
        });
        alertDialog.show();
    }
}
