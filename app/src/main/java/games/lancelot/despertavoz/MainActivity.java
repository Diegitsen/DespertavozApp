package games.lancelot.despertavoz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()  //instalacion del calligraphy
                .setDefaultFontPath("fonts/Infinity.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    public void IniciarSecondActivity (View v) //arranca la segunda activity
    {
        Intent nuevoL = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(nuevoL);
    }

    @Override
    protected void attachBaseContext(Context newBase) //poner el calligraphy en el context
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }



}
