package lv.kristaps.preferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnRedirect;
    Button btnSave;
    EditText txtInput;
    Spinner themes;
    SharedPreferences sharedpreferences;
    public static final String preference = "pref";
    public static final String key = "txtKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRedirect = (Button) findViewById(R.id.btnRedirect);
        btnSave = (Button) findViewById(R.id.btnSave);
        themes = (Spinner) findViewById(R.id.spinner);
        txtInput = (EditText) findViewById(R.id.txtInput);
        sharedpreferences = getSharedPreferences(preference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(key, txtInput.getText().toString());
                editor.apply();
                Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();
            }
        });
        themes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                switch (pos){
                    case 0:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                        break;
                    case 1:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                    case 2:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                    default:
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        btnRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
    }
}