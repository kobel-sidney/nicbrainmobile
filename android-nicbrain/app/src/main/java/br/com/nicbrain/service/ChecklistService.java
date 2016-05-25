package br.com.nicbrain.service;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import com.activeandroid.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.nicbrain.dao.ChecklistDao;
import br.com.nicbrain.dao.EventDao;
import br.com.nicbrain.exception.ServiceException;
import br.com.nicbrain.model.Checklist;
import br.com.nicbrain.model.Event;
import br.com.nicbrain.model.User;
import br.com.nicbrain.repository.ChecklistRepository;
import br.com.nicbrain.repository.EventRepository;
import br.com.nicbrain.util.ConnectionUtil;
import br.com.nicbrain.util.NicBrainUtil;
import br.com.nicbrain.util.OperationListener;

public class ChecklistService {

    private Context context;

    private User user;
    private ChecklistRepository checklistRepository;

    public ChecklistService(){
        checklistRepository = new ChecklistRepository();
    }

    public ChecklistService(final Context context){
        this.context = context;
        checklistRepository = new ChecklistRepository();
    }

    public boolean initChecklists(List<Event> events){
        checklistRepository.initChecklistForEvents(events);
        return true;
    }

    public Checklist getChecklistByEvent(String idEvent){
        return checklistRepository.getChecklistByIdEvent(idEvent);
    }




    public void getChecklistByEvent(Activity activity, final Context context, final String idEvent, final OperationListener<List<Checklist>> callbackService) throws ServiceException {

        final AsyncTask<Void, Void, List<Checklist>> asyncTask = new AsyncTask<Void, Void, List<Checklist>>() {
            @Override
            protected void onPreExecute(){

            }

            @Override
            protected List<Checklist> doInBackground(Void... params) {
                return checklistRepository.getListChecklistByIdEvent(idEvent);
            }
            @Override
            protected void onPostExecute(List<Checklist> result){
                callbackService.onOperationSucces(result);
            }
        };
        asyncTask.execute();
    }



}