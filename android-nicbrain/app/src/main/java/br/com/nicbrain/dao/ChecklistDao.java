package br.com.nicbrain.dao;

import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import java.util.List;

import br.com.nicbrain.exception.ServiceException;
import br.com.nicbrain.model.Checklist;
import br.com.nicbrain.model.User;

/**
 * Created by eduardoabreu on 5/23/16.
 */
public class ChecklistDao {

    public List<Checklist> getListChecklistByEvent(String idEvent){

        return new Select()
                .from(Checklist.class)
                .where("idEvento = ?", idEvent)
                .execute();

    }

    public Checklist getChecklistByEvent(String idEvent){

        return new Select()
                .from(Checklist.class)
                .where("idEvento = ?", idEvent)
                .executeSingle();

    }




    public void save(final Checklist checklist) throws ServiceException {
        ActiveAndroid.beginTransaction();

        try {
            checklist.save();
            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }

    public void saveOrUpdate(final Checklist checklist) throws ServiceException {
        ActiveAndroid.beginTransaction();

        try {

        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }


}
