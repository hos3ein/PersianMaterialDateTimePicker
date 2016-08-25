package ir.blue_saffron.persiandatetimepickerexample;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class G extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Samim-persian-digits-overwrite.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
