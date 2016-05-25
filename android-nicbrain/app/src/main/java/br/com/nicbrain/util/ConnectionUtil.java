package br.com.nicbrain.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by eduardoabreu on 5/23/16.
 */
public class ConnectionUtil {

    /* Função para verificar existência de conexão com a internet
	 */
    public  static boolean verififyConnection() {
        boolean conectado;
        ConnectivityManager conectivtyManager = (ConnectivityManager) NicbrainApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            conectado = true;
        } else {
            conectado = false;
        }
        return conectado;
    }
}
