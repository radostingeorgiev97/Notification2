package bg.uni_svishotv.bi2016.notification2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SaySomething extends AppCompatActivity {

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say_something);
        textView1 = findViewById(R.id.textView1);
    }
    @Override
    protected void onStart(){
        super.onStart();
        Intent intent = getIntent();
        textView1.setText(intent.getStringExtra("message"));
    }
}
