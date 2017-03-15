package games.lancelot.despertavoz;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ThirdActivity extends AppCompatActivity {

    TextView tv;
    TextView tvHora;
    int horaX;
    int minutoX;
    static final int DIALOG_ID = 0;
    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tv = (TextView)findViewById(R.id.tvTituloAlarma);
        tvHora = (TextView)findViewById(R.id.tvFechaHora);
        ib = (ImageButton)findViewById(R.id.ibreloj);

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

    public void ClickBotonReloj(View v)
    {
        showDialog(DIALOG_ID);
    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        if(id == DIALOG_ID)
        {
            return new TimePickerDialog(ThirdActivity.this, kTimePListener, horaX, minutoX, false);
        }
        return null;
    }

    protected TimePickerDialog.OnTimeSetListener kTimePListener = new TimePickerDialog.OnTimeSetListener()
    {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            horaX = hourOfDay;
            minutoX = minute;

            tvHora.setText(horaX + " : " + minutoX);
        }
    };

    @Override
    protected void attachBaseContext(Context newBase) //ponerlo en el context
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
