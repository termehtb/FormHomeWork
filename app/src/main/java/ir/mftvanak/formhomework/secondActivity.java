package ir.mftvanak.formhomework;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent= getIntent();
        final String name= intent.getStringExtra("name");
        final String lastname= intent.getStringExtra("lastname");
        final int age= intent.getIntExtra("age", -1);
        final String email= intent.getStringExtra("email");
        final int number= intent.getIntExtra("number", -1);

        TextView showName= findViewById(R.id.showName);
        TextView showLastName= findViewById(R.id.showLastName);
        TextView showAge= findViewById(R.id.showAge);
        TextView showEmail= findViewById(R.id.showEmail);
        TextView showNumber= findViewById(R.id.showNumber);
        Button ok= findViewById(R.id.btnok);

        showName.setText(name);
        showLastName.setText(lastname);
        showAge.setText(age);
        showEmail.setText(email);
        showNumber.setText(number);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(secondActivity.this).edit().putString("name", name);
                PreferenceManager.getDefaultSharedPreferences(secondActivity.this).edit().putString("lastname", lastname);
                PreferenceManager.getDefaultSharedPreferences(secondActivity.this).edit().putString("age", String.valueOf(age));
                PreferenceManager.getDefaultSharedPreferences(secondActivity.this).edit().putString("email", email);
                PreferenceManager.getDefaultSharedPreferences(secondActivity.this).edit().putString("number", String.valueOf(number));
                Intent returnIntent= new Intent();
                returnIntent.putExtra("result", "all the inputs are correct");
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });






    }
}
