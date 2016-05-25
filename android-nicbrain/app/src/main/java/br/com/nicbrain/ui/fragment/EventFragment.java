package br.com.nicbrain.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.nicbrain.R;
import br.com.nicbrain.service.EventService;
import br.com.nicbrain.ui.activity.ChecklistActivity;
import br.com.nicbrain.ui.adapter.EventAdapter;
import br.com.nicbrain.util.NicBrainUtil;

public class EventFragment extends BaseFragment {

    RecyclerView recyclerView = null;
    EventAdapter eventAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleEventos);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        final EventService eventoService = new EventService(this.getActivity());
        eventAdapter = new EventAdapter(eventoService.getEventsByIdUser());
        recyclerView.setAdapter(eventAdapter);
        return rootView;

    }


    private void listeners(){
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
