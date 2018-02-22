package accademia.lynxspa.com.accademiaapp.logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import accademia.lynxspa.com.accademiaapp.R;
import accademia.lynxspa.com.accademiaapp.data.Contatto;
import accademia.lynxspa.com.accademiaapp.data.MainSingleton;

public class DataAccessUtils {

    public final static String PREFS_FILENAME = "favoriteFile";
    public final static String PREFS_FAVORITE_KEY = "favoriteKey";

    public static List<Contatto> getDataSourceItemList(Context context) {

        return MainSingleton.getInstance().getItemList();
    }

    public static List<Contatto> addItemToDataSource(Context context, Contatto itemToAdd) {
        List<Contatto> datasource = DataAccessUtils.getDataSourceItemList(context);
        datasource.add(itemToAdd);

        MainSingleton.getInstance().setItemList(datasource);
        return datasource;
    }

    public static Contatto getItemAtIndex(Context context, int index) {
        List<Contatto> datasource = DataAccessUtils.getDataSourceItemList(context);
        return datasource.get(index);
    }

    public static List<Contatto> removeItemAtIndex(Context context, int index) {
        List<Contatto> datasource = DataAccessUtils.getDataSourceItemList(context);
        datasource.remove(index);

        MainSingleton.getInstance().setItemList(datasource);
        return datasource;
    }

    public static int getColorForPosition(Context context, int position){

        if(position % 2 == 0){
            return context.getColor(R.color.light_blu);
        }else{
            return context.getColor(R.color.light_gray);
        }

    }

    public static void initDataSource(Context context) {
        if(getDataSourceItemList(context) == null || getDataSourceItemList(context).size() == 0){
            addItemToDataSource(context, new Contatto("Simone Cimoli", "+39 1234567"));
            addItemToDataSource(context, new Contatto("Mario Rossi", "+39 1111111"));
            addItemToDataSource(context, new Contatto("Matteo Bianchi", "+39 2222222"));
            addItemToDataSource(context, new Contatto("Rosa Tulipano", "+39 3333333"));
        }
    }

    /* SharedPrefereces methods */

    public static void setFavoriteValueInPreferences(Context context, String favoriteValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREFS_FAVORITE_KEY, favoriteValue);
        editor.commit();
    }

    public static String getFavoriteValueInPreferences(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE);
        String favoriteValue = sharedPreferences.getString(PREFS_FAVORITE_KEY, null);
        return favoriteValue;
    }

}
