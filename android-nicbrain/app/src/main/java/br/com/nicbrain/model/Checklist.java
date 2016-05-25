package br.com.nicbrain.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by eduardoabreu on 5/24/16.
 */
@Table(name = "checklist")
public class Checklist extends Model {

    @Column(name = "idChecklist")
    @SerializedName("idChecklist")
    @Expose
    private String idChecklist;

    @Column(name = "idEvento")
    @SerializedName("idEvento")
    @Expose
    private String idEvento;

    @Column(name = "idLocal")
    @SerializedName("idLocal")
    @Expose
    private String idLocal;

    @Column(name = "idCliente")
    @SerializedName("idCliente")
    @Expose
    private String idCliente;

    @Column(name = "nomeCheckList")
    @SerializedName("nomeCheckList")
    @Expose
    private String nomeCheckList;

    @Column(name = "dataPrevistaInicio")
    @SerializedName("dataPrevistaInicio")
    @Expose
    private String dataPrevistaInicio;

    @Column(name = "nomeStatus")
    @SerializedName("nomeStatus")
    @Expose
    private String nomeStatus;

    @Column(name = "nomeResponsavel")
    @SerializedName("nomeResponsavel")
    @Expose
    private String nomeResponsavel;

    @Column(name = "qtdAlerta")
    @SerializedName("qtdAlerta")
    @Expose
    private String qtdAlerta;

    @Column(name = "corSituacao")
    @SerializedName("corSituacao")
    @Expose
    private String corSituacao;

    public String getIdChecklist() {
        return idChecklist;
    }

    public void setIdChecklist(String idChecklist) {
        this.idChecklist = idChecklist;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCheckList() {
        return nomeCheckList;
    }

    public void setNomeCheckList(String nomeCheckList) {
        this.nomeCheckList = nomeCheckList;
    }

    public String getDataPrevistaInicio() {
        return dataPrevistaInicio;
    }

    public void setDataPrevistaInicio(String dataPrevistaInicio) {
        this.dataPrevistaInicio = dataPrevistaInicio;
    }

    public String getNomeStatus() {
        return nomeStatus;
    }

    public void setNomeStatus(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getQtdAlerta() {
        return qtdAlerta;
    }

    public void setQtdAlerta(String qtdAlerta) {
        this.qtdAlerta = qtdAlerta;
    }

    public String getCorSituacao() {
        return corSituacao;
    }

    public void setCorSituacao(String corSituacao) {
        this.corSituacao = corSituacao;
    }


}
