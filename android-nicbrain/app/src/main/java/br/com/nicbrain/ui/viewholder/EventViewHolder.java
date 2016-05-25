package br.com.nicbrain.ui.viewholder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import br.com.nicbrain.R;
import br.com.nicbrain.ui.activity.ChecklistActivity;
import br.com.nicbrain.ui.activity.LoginActivity;
import br.com.nicbrain.util.NicBrainUtil;


public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView textNomeEvento;
    private TextView textNomeLocal;
    private TextView textEventoDataInicioPrevisto;

    public EventViewHolder(View view) {
        super(view);

        this.textNomeEvento = (TextView) view.findViewById(R.id.textView_nome_evento);
        this.textNomeLocal = (TextView) view.findViewById(R.id.textView_local_name);
        this.textEventoDataInicioPrevisto = (TextView) view.findViewById(R.id.textView_start_event_date);

        view.setClickable(true);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final String idEvento = (String) textNomeEvento.getTag();

        if(!TextUtils.isEmpty(idEvento)){
            final Intent intent = new Intent(v.getContext(),ChecklistActivity.class);
            intent.putExtra("idEvento",idEvento);
            intent.putExtra("nomeEvento",this.getTextNomeEvento().getText().toString());
            v.getContext().startActivity(intent);
            NicBrainUtil.setNomeEvento(this.getTextNomeEvento().getText().toString());
            NicBrainUtil.setIdEvento(idEvento);

        }
    }

    public TextView getTextNomeEvento() {
        return textNomeEvento;
    }

    public void setTextNomeEvento(TextView textNomeEvento) {
        this.textNomeEvento = textNomeEvento;
    }

    public TextView getTextNomeLocal() {
        return textNomeLocal;
    }

    public void setTextNomeLocal(TextView textNomeLocal) {
        this.textNomeLocal = textNomeLocal;
    }

    public TextView getTextEventoDataInicioPrevisto() {
        return textEventoDataInicioPrevisto;
    }

    public void setTextEventoDataInicioPrevisto(TextView textEventoDataInicioPrevisto) {
        this.textEventoDataInicioPrevisto = textEventoDataInicioPrevisto;
    }
}
