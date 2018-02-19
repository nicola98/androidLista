package accademia.lynxspa.com.accademiaapp.logic;

import android.content.Context;

import java.util.List;

import accademia.lynxspa.com.accademiaapp.R;
import accademia.lynxspa.com.accademiaapp.data.Contatto;
import accademia.lynxspa.com.accademiaapp.data.MainSingleton;

public class DataAccessUtils {



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
        Contatto firstContact = new Contatto("Canna", "0000");
        addItemToDataSource(context, firstContact);
    }

}
