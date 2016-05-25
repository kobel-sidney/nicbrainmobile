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
import java.util.List;

import br.com.nicbrain.dao.ChecklistDao;
import br.com.nicbrain.dao.UserDao;
import br.com.nicbrain.exception.ServiceException;
import br.com.nicbrain.model.Checklist;
import br.com.nicbrain.model.Event;
import br.com.nicbrain.model.User;
import br.com.nicbrain.net.NicbrainEndpoint;
import br.com.nicbrain.util.ConnectionUtil;
import br.com.nicbrain.util.NicBrainUtil;


/**
 * Created by fabio on 06/04/16.
 */
public class ChecklistRepository {

    private final String TAG = this.getClass().getName();
    protected ChecklistDao checklistDao;

    public String initChecklistForEvents(List<Event> listEvent) throws ServiceException {

        HttpHeaders requestHeaders = new HttpHeaders();

        Checklist checklist = null;
        checklistDao = new ChecklistDao();

        for (Event event : listEvent) {
            checklist = checklistDao.getChecklistByEvent(event.getIdEvento());
            if(checklist == null){
                String response = callEndPoint(event.getIdEvento());
                Gson gson = new Gson();
                checklist = gson.fromJson(response, Checklist.class);
                checklistDao.save(checklist);
            }
        }
        return null;
    }

    public Checklist getChecklistByIdEvent(String idEvent) throws ServiceException {

        Checklist checklist = null;
        checklistDao = new ChecklistDao();

        checklist = checklistDao.getChecklistByEvent(idEvent);
        if(checklist == null){
            String response = callEndPoint(idEvent);
            Gson gson = new Gson();
            checklist = gson.fromJson(response, Checklist.class);
            checklistDao.save(checklist);
        }
        return checklist;
    }

    public List<Checklist> getListChecklistByIdEvent(String idEvent) throws ServiceException {

        List<Checklist> listChecklist = null;
        checklistDao = new ChecklistDao();

        listChecklist = checklistDao.getListChecklistByEvent(idEvent);
//        if(checklist == null){
//            String response = callEndPoint(idEvent);
//            Gson gson = new Gson();
//            checklist = gson.fromJson(response, Checklist.class);
//            checklistDao.save(checklist);
//        }
        return listChecklist;
    }

    private String callEndPoint(String idEvent){
        HttpHeaders requestHeaders = new HttpHeaders();

        String response = null;
        Checklist checklist = null;
        if(ConnectionUtil.verififyConnection()){
            HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

                String idUser = String.valueOf(NicBrainUtil.getIdUsuario());
                String url = NicbrainEndpoint.URL_LISTAR_CHECKLIST + idUser + "/" + idEvent + "/" + NicBrainUtil.getIdPerfil();
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
