package br.com.nicbrain.ui.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.nicbrain.R;
import br.com.nicbrain.model.Checklist;
import br.com.nicbrain.ui.viewholder.ChecklistViewHolder;
import br.com.nicbrain.util.CorEnum;
import br.com.nicbrain.util.OrdenacaoListEnum;

public class ChecklistAdapter extends RecyclerView.Adapter<ChecklistViewHolder>{

    private static List<Checklist> list;

    public ChecklistAdapter(final List<Checklist> list){
        this.list = list;
    }

    @Override
    public ChecklistViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.list_checklist, viewGroup, false);
        return new ChecklistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChecklistViewHolder holder, int position) {

        final Checklist checklist = list.get(position);

        holder.getImageStatus().setImageResource(CorEnum.getValue(
                checklist.getCorSituacao()).getCodCor());
        holder.getTxtNomeEvento().setText(checklist.getNomeCheckList());

        holder.getTxtNomeResponsavel().setText(checklist.getNomeResponsavel());
        holder.getTxtDataInicioPrevisto().setText(checklist.getDataPrevistaInicio());
        holder.getTxtStatus().setText(checklist.getNomeStatus());
        holder.getTxtStatus().setTag(checklist.getIdChecklist());
        holder.getBtnCancelar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                montarAlert(v.getContext(), checklist.getIdChecklist());
            }
        });
    }



    /**
     *
     * @param idCheckList
     */
    public void removerCheckList(final String idCheckList){
        for(Checklist checklist:list){
            if(checklist.getIdChecklist().equals(idCheckList)){
                list.remove(checklist);
                break;
            }
        }

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     *
     * @param context
     * @param idCheckList
     */
    private void montarAlert(final Context context,final String idCheckList){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(context);

        dialogo.setTitle(R.string.alert_cancel_checklist);
        dialogo.setCancelable(true);
        final EditText txtJustificativa = new EditText(context);
        dialogo.setView(txtJustificativa);
        dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    if(!TextUtils.isEmpty(txtJustificativa.getText().toString())){
                       //final CancelamentoCheckListAsync cancelamentoCheckListAsync = new CancelamentoCheckListAsync(context);
                        //cancelamentoCheckListAsync.execute(new String[]{idCheckList,txtJustificativa.getText().toString()});
                        removerCheckList(idCheckList);
                    }else{
                        Toast toast = Toast.makeText(context,context.getString(R.string.msg_observation_cancel), Toast.LENGTH_LONG);
                        toast.show();
                    }
                } catch (Exception e) {
                    Log.e("problema", "Nao foi possivel cancelar o checklist", e);
                }
                dialog.cancel();
            }
        });

        dialogo.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        dialogo.show();
    }

    public void ordenarList(final OrdenacaoListEnum ordenacaoListEnum){
        Collections.sort(list, new Comparator<Checklist>() {
            @Override
            public int compare(Checklist checklist, Checklist checklist1) {

                if (OrdenacaoListEnum.RESPONSAVEL.equals(ordenacaoListEnum)) {
                    return checklist.getNomeResponsavel().compareTo(
                            checklist1.getNomeResponsavel());
                } else if (OrdenacaoListEnum.STATUS.equals(ordenacaoListEnum)) {
                    return checklist.getNomeStatus().compareTo(
                            checklist1.getNomeStatus());
                } else {
                    return -1;
                }
            }
        });

        notifyDataSetChanged();
    }
}