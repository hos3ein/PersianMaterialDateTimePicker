package ir.blue_saffron.persiandatetimepickerexample;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

import ir.blue_saffron.persianmaterialdatetimepicker.date.DatePickerDialog;
import ir.blue_saffron.persianmaterialdatetimepicker.time.RadialPickerLayout;
import ir.blue_saffron.persianmaterialdatetimepicker.time.TimePickerDialog;
import ir.blue_saffron.persianmaterialdatetimepicker.utils.PersianCalendar;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        PersianCalendar persianCalendar = new PersianCalendar();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                MainActivity.this,
                persianCalendar.getPersianYear(),
                persianCalendar.getPersianMonth(),
                persianCalendar.getPersianDay()
        );
        dpd.show(getFragmentManager(), "datePicker");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String s = year + "/" + monthOfYear + "/" + dayOfMonth;
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    public void onClick2(View view) {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(MainActivity.this, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        tpd.show(getFragmentManager(), "timePicker");
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
        String s = hourOfDay + ":" + minute;
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        setLocale(newBase);
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private static void setLocale(Context context) {
        Resources resources = context.getResources();
        Locale locale = new Locale("fa");
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLayoutDirection(locale);
        }
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
