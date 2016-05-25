package br.com.nicbrain.repository;

import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.google.gson.Gson;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

import br.com.nicbrain.dao.UserDao;
import br.com.nicbrain.exception.ServiceException;
import br.com.nicbrain.model.User;
import br.com.nicbrain.net.NicbrainEndpoint;
import br.com.nicbrain.util.ConnectionUtil;


/**
 * Created by fabio on 06/04/16.
 */
public class EventRepository {

    private final String TAG = this.getClass().getName();
    protected UserDao usuarioDao;

    public String getEventsByUser(final String email, final String senha) throws ServiceException {

        HttpHeaders requestHeaders = new HttpHeaders();

        String response = null;
        if(ConnectionUtil.verififyConnection()){
            HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
            String url = NicbrainEndpoint.URL_LOGIN + email + "/" + senha;
            response  = restTemplate.exchange(url, HttpMethod.GET,
                    requestEntity, String.class).getBody();

        }
        return response;
    }

    public void setUsuario(final Context context, User usuario) throws ServiceException {
        ActiveAndroid.beginTransaction();

        try {
            usuario.save();
            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }

    public void updateUsuario(User usuario) throws ServiceException {
        ActiveAndroid.beginTransaction();

        try {
            usuario.delete();
            usuario.save();
            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }



}
