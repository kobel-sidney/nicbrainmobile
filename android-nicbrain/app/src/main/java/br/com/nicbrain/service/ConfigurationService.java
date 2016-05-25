package br.com.nicbrain.service;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import br.com.nicbrain.exception.ServiceException;
import br.com.nicbrain.model.Checklist;
import br.com.nicbrain.model.Event;
import br.com.nicbrain.model.Local;
import br.com.nicbrain.model.User;
import br.com.nicbrain.repository.EventRepository;
import br.com.nicbrain.util.ConnectionUtil;
import br.com.nicbrain.util.OperationListener;

/**
 * Created by eduardoabreu on 5/24/16.
 */
public class ConfigurationService {

    private EventService eventService;
    private ChecklistService checklistService;

    public ConfigurationService(){
        eventService = new EventService();
        checklistService = new ChecklistService();
    }



    public void init(Activity activity, final Context context, final User user, final OperationListener<String> callbackService) throws ServiceException {

        final AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute(){

            }

            @Override
            protected String doInBackground(Void... params) {

                EventRepository eventRepository = new EventRepository();

                if(ConnectionUtil.verififyConnection()){
                    String response = eventRepository.getEventsByUser(user.getEmail(), user.getSenha());

                    List<Event> events =  eventService.getEvents(response, user);
                    eventService.deleteAll(user);
                    eventService.saveOrUpdateEvents(events);

                    initServices(events);
                }

                return null;
            }
            @Override
            protected void onPostExecute(String result){
                callbackService.onOperationSucces(result);
            }
        };
        asyncTask.execute();
    }



    private Event convertJsonObjectToPojo(JSONObject jsonObject) throws JSONException {
        Event obj = new Event();
        obj.setIdEvento(jsonObject.getString("idEvento"));
        obj.setNomeEvento(jsonObject.getString("nomeEvento"));
        obj.setDataInicioPrevisto(jsonObject.getLong("dataInicioPrevisto"));
        Local localDTO = new Local();
        localDTO.setNomeLocal("Nome");
        localDTO.setIdLocal("id");
        return obj;
    }



    private void initServices(List<Event> events){
//        TelefoneUteisAsync telefoneUteisAsync = new TelefoneUteisAsync(this.context);
//        telefoneUteisAsync.execute((Void) null);

//        StatusAsync statusAsync = new StatusAsync(this.context);
//        statusAsync.execute((Void) null);

//        OcorrenciaAsync ocorrenciaAsync = new OcorrenciaAsync(this.context);
//        ocorrenciaAsync.execute((Void) null);

//        RondaAsync RondaAsync = new RondaAsync(context);
//        RondaAsync.execute(usuarioDTO.getIdUsuario());

//        LoginService loginService = new LoginService(this.context);

//        CheckListAsync checkListAsync = new CheckListAsync(this.context,Boolean.TRUE);
//        checkListAsync.execute(loginService.eventoLogin(usuarioDTO,this.usuario.trim()));

        checklistService.initChecklists(events);

    }

}
