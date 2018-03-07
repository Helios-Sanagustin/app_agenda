package local.com.agendacontactos.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import local.com.agendacontactos.constants.Constantes;

/**
 * Created by user on 05/03/2018.
 */

public class DatabaseContactos /*DatabaseHelper.java*/ extends SQLiteOpenHelper {

    //  TODO: Constantes para crear y eliminar tabla contactos
    private static final String CREATE_TABLE_CONTACTOS = "CREATE TABLE " +
                        Constantes.CONTACTOS_TABLA + " (" +
                        Constantes.CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        Constantes.CAMPO_NOMBRE + " TEXT NOT NULL, " +
                        Constantes.CAMPO_EMAIL  + " TEXT NOT NULL, " +
                        Constantes.CAMPO_EDAD   + " INTEGER NOT NULL)";

    private static final String DELETE_TABLE_CONTACTOS =
            "DROP TABLE IF EXIST " + Constantes.CONTACTOS_TABLA;


    //  TODO: Constructor de nuestra clase
    //  para crear una referencia a nuestra db
    //  Usamos una variable de tipo Context para poder llamarlo desde otra clase
    public DatabaseContactos(Context context) {
        //  Pasamos el contexto, el nombre de la base de datos, un null para factory y la versión
        //  Super hace referencia a la superclase
        super(context, Constantes.DATABASE_NAME, null, Constantes.DATABASE_VERSION);
    }

    //  TODO: El método onCreate
    // se llama al crear la base de datos(en el constructor)
    @Override
    public void onCreate(SQLiteDatabase db) {
        //  Invocamos al método createTables
        createTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //  Eliminamos la tabla
        deleteTables(db);
        //  Y la volvemos a crear
        createTables(db);
    }

    //  TODO: Usamos un método para crear nuestra tabla
    //  Con el parámetro db "SQLiteDatabase" ejecutamos
    //  una instrucción SQL para crar nuestra tabla.
    public void createTables(SQLiteDatabase db){
        //.exceSQL ejecuta lo que contiene la String(que contiene toda la SQL)
        db.execSQL(CREATE_TABLE_CONTACTOS);
    }

    //  TODO: Usamos este método para eliminar nuestras tablas
    public void deleteTables(SQLiteDatabase db){
        db.execSQL(DELETE_TABLE_CONTACTOS);
    }
}
