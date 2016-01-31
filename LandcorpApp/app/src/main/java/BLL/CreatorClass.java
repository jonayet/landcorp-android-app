

package BLL;

import android.content.Context;

import helper.DataBase;

/**
 * Created by Amir on 31-Jan-16.
 */
public class CreatorClass {
    public static LinkStore linkStore;
    public static DataBase createDataBase(Context context,int vertion){
        return new DataBase(context,vertion);
    }
    public static void  createLinkStore(DataBase dataBase){
        linkStore=new LinkStore(dataBase);
    }
}
