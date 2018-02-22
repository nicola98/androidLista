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

        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext() .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.nameTextView = (TextView)convertView.findViewById(R.id.name);
            viewHolder.numberTextView = (TextView)convertView.findViewById(R.id.number); convertView.setTag(viewHolder);
            viewHolder.logoImageView = (ImageView)convertView.findViewById(R.id.logo);
            viewHolder.starImageView = (ImageView)convertView.findViewById(R.id.starImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String name = this.contattoList.get(position).getNome();
        viewHolder.nameTextView.setText(name);

        String number = this.contattoList.get(position).getTelefono();
        viewHolder.numberTextView.setText(number);

        // Set icon
        viewHolder.logoImageView.setBackgroundColor(DataAccessUtils.getColorForPosition(context, position));

        // Set correct star image visibility
        String favoriteValue = DataAccessUtils.getFavoriteValueInPreferences(getContext());

        if (favoriteValue != null && favoriteValue.equals(number)) {
            viewHolder.starImageView.setVisibility(View.VISIBLE);
        } else {
            viewHolder.starImageView.setVisibility(View.GONE);
        }

        return convertView;

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

    private class ViewHolder {
        public TextView nameTextView;
        public TextView numberTextView;
        public ImageView logoImageView;
        public ImageView starImageView;
    }

}
