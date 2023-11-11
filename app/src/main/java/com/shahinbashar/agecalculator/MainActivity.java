package com.shahinbashar.agecalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Button btnCalculateAge;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        btnCalculateAge = findViewById(R.id.btnCalculateAge);
        textViewResult = findViewById(R.id.textViewResult);

        btnCalculateAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAge();
            }
        });
    }

    private void calculateAge() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar birthDate = Calendar.getInstance();
        birthDate.set(year, month, day);

        Calendar currentDate = Calendar.getInstance();

        int age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        if (currentDate.get(Calendar.DAY_OF_YEAR) < birthDate.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        String formattedBirthDate = sdf.format(birthDate.getTime());

        String result = "Your age is " + age + " years.\n"
                + "Date of Birth: " + formattedBirthDate;

        textViewResult.setText(result);
    }
}
