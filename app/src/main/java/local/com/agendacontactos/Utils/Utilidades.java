package local.com.agendacontactos.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by user on 06/03/2018.
 */

public class Utilidades {

    /**
     * Muestra un toast con un mensaje para el usuario
     *
     * @param context (Representa el contexto donde va a mostrar el mensaje)
     * @param mensaje
     */

    public void mostrarMensaje(Context context, String mensaje){

        //Introducimos los parámetros context y mensaje para poder utilizar el Toast en cualquier clase
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT);
    }
}
