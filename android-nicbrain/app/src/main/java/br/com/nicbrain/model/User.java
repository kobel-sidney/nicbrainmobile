package br.com.nicbrain.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by eduardoabreu on 5/23/16.
 */
@Table(name = "usuario")
public class User extends Model {

    @Column(name = "idUsuario")
    @SerializedName("idUsuario")
    @Expose
    private Long idUsuario;

    @Column(name = "nome")
    @SerializedName("nome")
    @Expose
    private String nome;

    @Column(name = "senha")
    @SerializedName("senha")
    @Expose
    private String senha;

    @Column(name = "email")
    @SerializedName("email")
    @Expose
    private String email;

    @Column(name = "bloqueado")
    @SerializedName("bloqueado")
    @Expose
    private boolean bloqueado;

    @Column(name = "dataValidadeSenha")
    @SerializedName("dataValidadeSenha")
    @Expose
    private Date dataValidadeSenha;

    @Column(name = "dataValidadeConta")
    @SerializedName("dataValidadeConta")
    @Expose
    private Date dataValidadeConta;

    @Column(name = "idPerfil")
    @SerializedName("idPerfil")
    @Expose
    private Long idPerfil;

    @Column(name = "idTipoUsuario")
    @SerializedName("idTipoUsuario")
    @Expose
    private Long idTipoUsuario;

    @Column(name = "idPessoa")
    @SerializedName("idPessoa")
    @Expose
    private Long idPessoa;

    @Column(name = "idCliente")
    @SerializedName("idCliente")
    @Expose
    private Long idCliente;

    //private List<Evento> listE;

    @Column(name = "ativo")
    @SerializedName("ativo")
    @Expose
    private boolean ativo;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Date getDataValidadeSenha() {
        return dataValidadeSenha;
    }

    public void setDataValidadeSenha(Date dataValidadeSenha) {
        this.dataValidadeSenha = dataValidadeSenha;
    }

    public Date getDataValidadeConta() {
        return dataValidadeConta;
    }

    public void setDataValidadeConta(Date dataValidadeConta) {
        this.dataValidadeConta = dataValidadeConta;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
