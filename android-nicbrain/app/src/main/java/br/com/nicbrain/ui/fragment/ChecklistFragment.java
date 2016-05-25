package br.com.nicbrain.ui.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.nicbrain.R;
import br.com.nicbrain.model.Checklist;
import br.com.nicbrain.response.HeaderHttpResponse;
import br.com.nicbrain.service.ChecklistService;
import br.com.nicbrain.service.EventService;
import br.com.nicbrain.ui.activity.ChecklistActivity;
import br.com.nicbrain.ui.adapter.ChecklistAdapter;
import br.com.nicbrain.ui.adapter.EventAdapter;
import br.com.nicbrain.util.NicBrainUtil;
import br.com.nicbrain.util.NicbrainApplication;
import br.com.nicbrain.util.OperationListener;
import br.com.nicbrain.util.OrdenacaoListEnum;

public class ChecklistFragment extends BaseFragment {

    RecyclerView recyclerView = null;
    EventAdapter eventAdapter = null;
    ChecklistAdapter checklistAdapter = null;
    View rootView;
    private String idEvento;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            idEvento = extras.getString("idEvento");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_checklist, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleCheckList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        initObjects();

        return rootView;
    }

    private void initView(){



    }

    private void initObjects(){

        final ChecklistService checklistService = new ChecklistService();

        checklistService.getChecklistByEvent(getActivity(), NicbrainApplication.getContext(), idEvento, new OperationListener<List<Checklist>>() {
            @Override
            public void onOperationSucces(List<Checklist> listChecklist) {
                setChecklist(listChecklist);
            }

            @Override
            public void onOperationSucessWithError(List<Checklist> listChecklist, HeaderHttpResponse error) {

            }
        });

    }

    private void setChecklist(List<Checklist> checklists){

        if(checklists != null) {

            checklistAdapter = new ChecklistAdapter(checklists);
            recyclerView.setAdapter(checklistAdapter);
            checklistAdapter.notifyDataSetChanged();

            final Spinner spnOrdenacao = (Spinner) rootView.findViewById(R.id.checklistSpinnerOrdenacao);
            spnOrdenacao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(final AdapterView<?> parent,
                                           final View view, final int position, final long id) {
                    checklistAdapter.ordenarList(OrdenacaoListEnum.fromCodigo(
                            position));
                }

                @Override
                public void onNothingSelected(final AdapterView<?> parent) {
                }
            });

        }else{
            Toast.makeText(NicbrainApplication.getContext(), R.string.no_checklist_found, Toast.LENGTH_LONG).show();
        }

    }


    private void listeners(){
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
