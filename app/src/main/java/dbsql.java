import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLClientInfoException;

public class dbsql  extends SQLiteOpenHelper {

    public  static  final String DBNAME="myDB";
    public  static  final  String id="id";
    public  static  final  String nom="nom";
    public  static  final  String ville="ville";
    public  static  final  String naissance="naissance";
    public  static  final  String fr="fr";
    public  static  final  String math="math";
    public  static  final  String hist="hist";
    public  static  final  String phys="phys";


    public dbsql(@Nullable Context c) {
        super(c, DBNAME , null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
