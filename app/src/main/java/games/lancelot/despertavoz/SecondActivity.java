package games.lancelot.despertavoz;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Aldo on 12/03/2017.
 */
public class SecondActivity extends AppCompatActivity
{
    EditText edit;
    String []aux = new String[10]; // el aux va a coger el nombre de la alarma. Van a haber un maximo de 10 alarmas, por eso 10 nombres
    ImageButton iBoton;
    ListView list;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;
    int i = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Elementos del layout
        edit = (EditText)findViewById(R.id.etNombreAlarma);
        iBoton = (ImageButton)findViewById(R.id.ibAdd);
        list = (ListView)findViewById(R.id.lvAlarmas);
        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        list.setAdapter(arrayAdapter);
        //cuando se haga click en un item de ListV , pase a otro activity
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String dato = null;
                //en total van a ser 10 alarmas, osea maximo 10 nombres de alarma
                switch (position)
                {
                    case 0:
                        dato = aux[0];
                        break;
                    case 1:
                        dato = aux[1];
                        break;
                    case 2:
                        dato = aux[2];
                        break;
                    case 3:
                        dato = aux[3];
                        break;
                    case 4:
                        dato = aux[4];
                        break;
                    case 5:
                        dato = aux[5];
                        break;
                    case 6:
                        dato = aux[6];
                        break;
                    case 7:
                        dato = aux[7];
                        break;
                    case 8:
                        dato = aux[8];
                        break;
                    case 9:
                        dato = aux[9];
                        break;
                }

                Intent nuevoLayout = new Intent(SecondActivity.this, ThirdActivity.class);
                nuevoLayout.putExtra("DATO", dato);   // (nombre, variable)
                startActivity(nuevoLayout);

            }
        });

        //Cambiar fuente :D
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()  //instalacion del calligraphy
                .setDefaultFontPath("fonts/Infinity.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }

   /* public void IniciarThirdActivity (View v)
    {
        Intent nuevoLayout = new Intent(SecondActivity.this, ThirdActivity.class);
        startActivity(nuevoLayout);
    }*/

    public void agrgarAlarmas(View v)
    {
        arrayList.add(edit.getText().toString());
        arrayAdapter.notifyDataSetChanged();


        aux[i] = edit.getText().toString();

        edit.setText("");

        InputMethodManager miteclado = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE); //para que se oculte el teclado

        miteclado.hideSoftInputFromWindow(edit.getWindowToken(),0);  //despues de presionar el boton

        i++;
    }

    @Override
    protected void attachBaseContext(Context newBase) //ponerlo en el context
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


}