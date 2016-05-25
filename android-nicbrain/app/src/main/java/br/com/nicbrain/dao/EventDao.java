package br.com.nicbrain.dao;

import com.activeandroid.query.Select;

import java.util.List;

import br.com.nicbrain.model.Event;
import br.com.nicbrain.model.User;

/**
 * Created by eduardoabreu on 5/23/16.
 */
public class EventDao {

    public List<Event> getEventByIdUser(String idUsuario){

        return new Select()
                .from(Event.class)
                .where("idUsuario = ?", idUsuario)
                .execute();
    }

    public void setEvents(List<Event> eventos){

        for (Event event: eventos) {
            event.save();
        }
    }


    public boolean deleteAll(User user){

        List<Event> events = new Select().from(Event.class).where("idUsuario = ?", String.valueOf(user.getIdUsuario())).execute();

        for (Event event: events) {
            event.delete();
        }

        return true;
    }

}
