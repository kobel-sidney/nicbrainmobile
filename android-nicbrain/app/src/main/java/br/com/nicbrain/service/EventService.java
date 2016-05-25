package br.com.nicbrain.service;

import android.content.Context;

import com.activeandroid.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.nicbrain.dao.EventDao;
import br.com.nicbrain.model.Event;
import br.com.nicbrain.model.Local;
import br.com.nicbrain.model.User;
import br.com.nicbrain.util.NicBrainUtil;


/**
 * Created by hamseshenrique on 18/09/15.
 */
public class EventService {

    private Context context;

    private User user;
    private  EventDao eventDao;

    public EventService(){
        eventDao = new EventDao();
    }

    public EventService(final Context context){
        this.context = context;
        eventDao = new EventDao();
    }


    public void initEvents(List<Event> events){

    }


    /**
     *
     * @return
     */

    public List<Event> getEvents(String response, User user){
        List<Event> listEvento = new ArrayList<Event>();

        this.user = user;
        try {
            JSONObject obj = new JSONObject(response);
            JSONArray jsonArray = obj.getJSONArray("lstEventoDTO");
            for (int i = 0; i < jsonArray.length(); i++) {
                final JSONObject jsonObject = jsonArray.getJSONObject(i);
                Event evento = convertJsonObjectToPojo(jsonObject);

                listEvento.add(evento);
            }

            return listEvento;

        } catch (JSONException e) {
            Log.e("debug", e.getMessage());
        }
        return null;
    }

    private Event convertJsonObjectToPojo(JSONObject jsonObject) throws JSONException {
        Event obj = new Event();
        obj.setIdEvento(jsonObject.getString("idEvento"));
        obj.setNomeEvento(jsonObject.getString("nomeEvento"));
        obj.setDataInicioPrevisto(jsonObject.getLong("dataInicioPrevisto"));
        obj.setIdUsuario(String.valueOf(user.getIdUsuario()));

        final JSONObject jsonObjectLocal = jsonObject.getJSONObject("localDTO");
        obj.setNomeLocal(jsonObjectLocal.getString("nomeLocal"));

        return obj;
    }

    /**
     * Fluxo de persistencia
     *
     */
    public void saveOrUpdateEvents(List<Event> events){


        eventDao.setEvents(events);
    }

    public void deleteAll(User user){
        List<Event> listEvent = new ArrayList<Event>();
        listEvent = eventDao.getEventByIdUser(String.valueOf(NicBrainUtil.getIdUsuario()));

        for (Event event: listEvent) {
          event.delete();
        }
    }


    public List<Event> getEventsByIdUser(){
        List<Event> listEvent = new ArrayList<Event>();
        listEvent = eventDao.getEventByIdUser(String.valueOf(NicBrainUtil.getIdUsuario()));
        return listEvent;
    }


}