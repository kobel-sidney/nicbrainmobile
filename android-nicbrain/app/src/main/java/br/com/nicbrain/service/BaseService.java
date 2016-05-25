package br.com.nicbrain.service;

import android.os.AsyncTask;

import br.com.nicbrain.util.OperationListener;


/**
 * Classe responsável pelos Politicos
 */
public class BaseService extends AsyncTask<Void, Void, String> {

    private final String TAG = this.getClass().getName();
    private OperationListener<String> callbackService;
    private String url;

    public BaseService() {

    }

    @Override
    protected String doInBackground(Void... params) {
        return null;
    }
}