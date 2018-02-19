package accademia.lynxspa.com.accademiaapp.data;

import java.util.ArrayList;
import java.util.List;

public class MainSingleton {
    private static MainSingleton ourInstance = new MainSingleton();

    public static MainSingleton getInstance() {
        return ourInstance;
    }

    private List<Contatto> itemList;

    private MainSingleton() {
        this.itemList = new ArrayList<Contatto>();
    }

    public List<Contatto> getItemList() {
        return itemList;
    }

    public void setItemList(List<Contatto> itemList) {
        this.itemList = itemList;
    }
}
