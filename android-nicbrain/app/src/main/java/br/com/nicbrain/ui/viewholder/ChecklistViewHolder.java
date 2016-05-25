package br.com.nicbrain.ui.viewholder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.nicbrain.R;


public class ChecklistViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView txtNomeEvento;
    private TextView txtNomeResponsavel;
    private TextView txtDataInicioPrevisto;
    private TextView txtStatus;
    private ImageButton btnCancelar;
    private ImageView imageStatus;

    public ChecklistViewHolder(View itemView) {
        super(itemView);
        this.imageStatus = (ImageView) itemView.findViewById(R.id.imageIconStatus);
        this.txtNomeEvento = ((TextView) itemView
                .findViewById(R.id.textNomeChecklist));
        this.txtNomeResponsavel = ((TextView) itemView
                .findViewById(R.id.textNomeResponsavel));
        this.txtDataInicioPrevisto = (TextView) itemView
                .findViewById(R.id.textDataInicioPrevisto);
        this.txtStatus = (TextView) itemView
                .findViewById(R.id.textStatus);
        this.btnCancelar = (ImageButton) itemView
                .findViewById(R.id.btnCancelar);

        itemView.setClickable(true);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        ChecklistDTO checklistDTO = new ChecklistDTO();
//        checklistDTO.setIdChecklist((String)this.txtStatus.getTag());
//        checklistDTO.setNomeCheckList(this.getTxtNomeEvento().getText().toString());
//        checklistDTO.setNomeResponsavel(this.getTxtNomeResponsavel().getText().toString());
//        checklistDTO.setNomeStatus(this.getTxtStatus().getText().toString());
//        checklistDTO.setDataPrevistaInicio(this.getTxtDataInicioPrevisto().getText().toString());
//
//        final Intent intent = new Intent(v.getContext(),DetalheCheckList.class);
//        intent.putExtra("checklist",checklistDTO);
//        v.getContext().startActivity(intent);
    }

    public TextView getTxtNomeEvento() {
        return txtNomeEvento;
    }

    public void setTxtNomeEvento(TextView txtNomeEvento) {
        this.txtNomeEvento = txtNomeEvento;
    }

    public TextView getTxtNomeResponsavel() {
        return txtNomeResponsavel;
    }

    public void setTxtNomeResponsavel(TextView txtNomeResponsavel) {
        this.txtNomeResponsavel = txtNomeResponsavel;
    }

    public TextView getTxtDataInicioPrevisto() {
        return txtDataInicioPrevisto;
    }

    public void setTxtDataInicioPrevisto(TextView txtDataInicioPrevisto) {
        this.txtDataInicioPrevisto = txtDataInicioPrevisto;
    }

    public TextView getTxtStatus() {
        return txtStatus;
    }

    public void setTxtStatus(TextView txtStatus) {
        this.txtStatus = txtStatus;
    }

    public ImageButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(ImageButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public ImageView getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(ImageView imageStatus) {
        this.imageStatus = imageStatus;
    }
}
