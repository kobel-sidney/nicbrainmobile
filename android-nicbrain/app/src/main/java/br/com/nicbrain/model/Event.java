package br.com.nicbrain.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by eduardoabreu on 5/24/16.
 */
@Table(name = "evento")
public class Event extends Model {

    @Column(name = "idEvento")
    @SerializedName("idEvento")
    @Expose
    private String idEvento;

    @Column(name = "nomeEvento")
    @SerializedName("nomeEvento")
    @Expose
    private String nomeEvento;

    @Column(name = "idUsuario")
    private String idUsuario;

    @Column(name = "dataInicioPrevisto")
    @SerializedName("dataInicioPrevisto")
    @Expose
    private long dataInicioPrevisto;

    @Column(name = "local")
    private String  nomeLocal;

    public Event() {
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public long getDataInicioPrevisto() {
        return dataInicioPrevisto;
    }

    public void setDataInicioPrevisto(long dataInicioPrevisto) {
        this.dataInicioPrevisto = dataInicioPrevisto;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
