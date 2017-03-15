package games.lancelot.despertavoz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ThirdActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tv = (TextView)findViewById(R.id.tvTituloAlarma);

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();

        if(extra != null)
        {
            String dato = extra.getString("DATO");
            tv.setText(dato);
        }

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()  //instalacion del calligraphy
                .setDefaultFontPath("fonts/Infinity.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) //ponerlo en el context
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
