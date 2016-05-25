package br.com.nicbrain.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.nicbrain.R;
import br.com.nicbrain.model.Event;
import br.com.nicbrain.ui.viewholder.EventViewHolder;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder>{

    private List<Event> listEvento;
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
            "dd/MM/yyyy HH:mm:ss");


    public EventAdapter(final List<Event> listEvento){
        this.listEvento = listEvento;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.list_event,viewGroup,false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {

        final Event event = listEvento.get(position);
        holder.getTextNomeEvento().setText(event.getNomeEvento());

        holder.getTextNomeLocal().setText(event.getNomeLocal());

        final Date date = new Date(event.getDataInicioPrevisto());
        holder.getTextEventoDataInicioPrevisto().setText(DATE_FORMAT.format(date));
        holder.getTextNomeEvento().setTag(event.getIdEvento());
    }

    @Override
    public int getItemCount() {
        return listEvento.size();
    }
}
