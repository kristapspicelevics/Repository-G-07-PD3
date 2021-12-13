package lv.kristaps.preferences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btnBack;
    Button btnRead;
    TextView savedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnRead = (Button) findViewById(R.id.btnRead);
        savedText = (TextView) findViewById(R.id.savedText);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
                finish();
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.preference, MODE_PRIVATE);
                String text = sharedpreferences.getString(MainActivity.key, "");
                if (text.equals("")) {
                    Toast.makeText(MainActivity2.this, "Nothing found", Toast.LENGTH_SHORT).show();
                } else {
                    savedText.setText(text);
                }
            }
        });
    }
}