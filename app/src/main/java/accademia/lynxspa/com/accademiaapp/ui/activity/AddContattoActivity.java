package accademia.lynxspa.com.accademiaapp.ui.activity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

import accademia.lynxspa.com.accademiaapp.R;
import accademia.lynxspa.com.accademiaapp.data.Contatto;
import accademia.lynxspa.com.accademiaapp.data.MainSingleton;
import accademia.lynxspa.com.accademiaapp.logic.DataAccessUtils;

/**
 * Created by Simone Cimoli on 19/02/18.
 */

public class AddContattoActivity extends AppCompatActivity {

    EditText nomeEditText;
    EditText numeroEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contatto);

        nomeEditText = (EditText) findViewById(R.id.edit_name);
        numeroEditText = (EditText) findViewById(R.id.edit_number);

        ImageView photo = (ImageView) findViewById(R.id.contattoImageView);
        photo.setBackgroundColor(DataAccessUtils.getColorForPosition(this, MainSingleton.getInstance().getItemList().size()));

        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContatto();
            }
        });

    }


    private void saveContatto() {

        Contatto newContact = new Contatto(nomeEditText.getText().toString(), numeroEditText.getText().toString());

        // Add item to datasource
        List<Contatto> updatedList = DataAccessUtils.addItemToDataSource(getApplicationContext(), newContact);
        finish();
    }


}
