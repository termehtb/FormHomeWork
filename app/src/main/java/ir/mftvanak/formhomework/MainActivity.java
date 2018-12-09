package ir.mftvanak.formhomework;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button= findViewById(R.id.submit);
    TextView exit= findViewById(R.id.btnexit);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText FirstName=findViewById(R.id.firstName);
        final EditText LastName=findViewById(R.id.lastName);
        EditText Age=findViewById(R.id.age);
        EditText Email=findViewById(R.id.email);
        EditText Number=findViewById(R.id.number);
        TextView exit= findViewById(R.id.btnexit);



        final String firstName= FirstName.getText().toString();
        final String lastName= LastName.getText().toString();
        final int age= Integer.parseInt(Age.getText().toString());
        final String email= Email.getText().toString();
        final int number=Integer.parseInt( Number.getText().toString());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                intent.putExtra("nameinput", firstName);
                intent.putExtra("lastnameinput", lastName);
                intent.putExtra("age",age );
                intent.putExtra("email", email);
                intent.putExtra("number", number);
                startActivityForResult(intent,150);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog= new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("attention");
                alertDialog.setMessage("all the information will be gone");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==150){
            if(resultCode== Activity.RESULT_OK){
                String result= data.getStringExtra("result");
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

            }
        }
    }
}
