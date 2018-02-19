package accademia.lynxspa.com.accademiaapp.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import accademia.lynxspa.com.accademiaapp.R;
import accademia.lynxspa.com.accademiaapp.data.Contatto;
import accademia.lynxspa.com.accademiaapp.data.MainSingleton;
import accademia.lynxspa.com.accademiaapp.logic.DataAccessUtils;

public class CustomArrayAdapter extends ArrayAdapter<Contatto> {

    private final Context context;
    private List<Contatto> contattoList;

    public CustomArrayAdapter(Context context) {
        super(context, R.layout.list_item_layout, MainSingleton.getInstance().getItemList());

        contattoList = MainSingleton.getInstance().getItemList();
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_layout, parent, false);

        TextView nameTextView = (TextView) rowView.findViewById(R.id.name);
        String name = this.contattoList.get(position).getNome();
        nameTextView.setText(name);

        TextView numberTextView = (TextView) rowView.findViewById(R.id.number);
        String number = this.contattoList.get(position).getTelefono();
        numberTextView.setText(number);

        // Set icon
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        imageView.setBackgroundColor(DataAccessUtils.getColorForPosition(context, position));

        return rowView;

    }

    public void setValues(List<Contatto> contatti) {

        Log.d("DATA SET", "Contacts list count changed in " + contatti.size());

        this.contattoList = contatti;

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return contattoList.size();
    }
}
