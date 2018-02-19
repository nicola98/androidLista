package accademia.lynxspa.com.accademiaapp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import accademia.lynxspa.com.accademiaapp.R;
import accademia.lynxspa.com.accademiaapp.data.MainSingleton;
import accademia.lynxspa.com.accademiaapp.logic.DataAccessUtils;

public class DetailActivity extends Activity {

    private int currentItemValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int selectedItem = intent.getIntExtra(MainActivity.EXTRA_SELECTED_ITEM, 0);

        currentItemValue = selectedItem;

        // Set TextView
        TextView resultTextView = (TextView) findViewById(R.id.detailTextView);
        resultTextView.setText(DataAccessUtils.getItemAtIndex(this, selectedItem).getNome());

        // Set ImageView
        ImageView imageView = (ImageView) findViewById(R.id.detailImageView);
        imageView.setBackgroundColor(DataAccessUtils.getColorForPosition(this, selectedItem));

        // Set onclick listener
        Button detailButton = (Button) findViewById(R.id.detailButton);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}