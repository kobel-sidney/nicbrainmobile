package br.com.nicbrain.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by hamseshenrique on 10/09/15.
 */
@Table(name = "local")
public class Local extends Model {

    @Column(name = "idLocal")
    private String idLocal;

    @Column(name = "nomeLocal")
    private String nomeLocal;

    public Local() {
    }

    public Local(String idLocal, String nomeLocal) {
        this.idLocal = idLocal;
        this.nomeLocal = nomeLocal;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }
}
