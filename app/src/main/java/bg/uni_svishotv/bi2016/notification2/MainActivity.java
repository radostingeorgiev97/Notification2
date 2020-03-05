package bg.uni_svishotv.bi2016.notification2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String CHANEL_ID = "bg.uni_svishotv.bi2016.notification2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(
                    CHANEL_ID,
                    "Демонстрация на нотификация",
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

    }
    public void onClick1(View view) {
        NotificationCompat.Builder builder
                = new NotificationCompat.Builder(this, CHANEL_ID)
                .setSmallIcon(R.drawable.ic_attach_money_black_24dp)
                .setContentTitle("Нотификация")
                .setContentText("Текст на съобщението")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, builder.build());
    }
    public void onClick2(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
    public void onClick3(View view){
        Intent intent = new Intent(this,SaySomething.class);
        intent.putExtra("message", "Hello");
        startActivity(intent);
    }
}
