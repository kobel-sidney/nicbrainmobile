package br.com.nicbrain.util;

import android.content.Intent;
import android.view.View;



import java.util.concurrent.TimeUnit;

import br.com.nicbrain.model.User;


/**
 * Created by hamseshenrique on 20/09/15.
 */
public class NicBrainUtil {

   //public static final String URL = "http://qwerty:8080/";
   public static final String URL_RONDA = "http://rondaapihomologacao.nicbrain.com.br/rondaapi/";

    //public static final String URL = "http://www.nicbrain.com.br";
    //public static final String URL_RONDA = "http://rondaapihomologacao.nicbrain.com.br/rondaapi/";

  public static final String URL = "http://homologacao.nicbrain.com.br";
  //public static final String URL_RONDA = "http://rondaapihomologacao.nicbrain.com.br/rondaapi/";


   // public static final String URL = "http://treinamento.nicbrain.com.br";
    //public static final String URL_RONDA = "http://rondaapihomologacao.nicbrain.com.br/rondaapi/";

    //public static final String URL = "http://gcm.nicbrain.com.br";
    //public static final String URL_RONDA = "http://ronda.nicbrain.com.br/rondaapi/";


    public static final String PREFS = "Preferences";
    public static final String PREFS_NAME="PrefUsuario";
    public static final String PREFS_SENHA="PrefSenha";
    public static final String TELA_EVENTO = "telaEvento";

    private static Long idUsuario;
    private static String nomeEvento;
    private static String idEvento;
    private static String idPerfil;
    //private static OkHttpClient okHttpClient;
    private static String mensagemPush;
    private static Long idContratante;

    private static User user;


    //private static RondaDTO rondaDTO;



//    public static OkHttpClient getOkHttpClient() {
//        okHttpClient = new OkHttpClient();
//        okHttpClient.setConnectTimeout(220*1000, TimeUnit.MILLISECONDS);
//        okHttpClient.setReadTimeout(220*1000,TimeUnit.MILLISECONDS);
//        return okHttpClient;
//    }


    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        NicBrainUtil.user = user;
    }

    public static Long getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(Long idUsuario) {
        NicBrainUtil.idUsuario = idUsuario;
    }

    public static String getNomeEvento() {
        return nomeEvento;
    }

    public static Long getIdContratante() {
        return idContratante;
    }

    public static void setIdContratante(Long idContratante) {
        NicBrainUtil.idContratante = idContratante;
    }

    public static void setNomeEvento(String nomeEvento) {
        NicBrainUtil.nomeEvento = nomeEvento;
    }

    public static String getIdEvento() {
        return idEvento;
    }

    public static void setIdEvento(String idEvento) {
        NicBrainUtil.idEvento = idEvento;
    }

    public static String getIdPerfil() {
        return idPerfil;
    }

    public static void setIdPerfil(String idPerfil) {
        NicBrainUtil.idPerfil = idPerfil;
    }

   // public static RondaDTO getRondaDTO() {
       // return rondaDTO;
   // }

   // public static void setRondaDTO(RondaDTO rondaDTO) {
       // NicBrainUtil.rondaDTO = rondaDTO;
   // }

    public static String getMensagemPush() {
        return mensagemPush;
    }

    public static void setMensagemPush(String mensagemPush) {
        NicBrainUtil.mensagemPush = mensagemPush;
    }


    /**
     * Realiza a criptografia da senha.<br>
     * (Encapsula o algoritmo de criptografia de senha).
     *
     * @param password
     * @return
     */
//    public static String criptografarSenha(String password) {
//        /* Algoritmo de criptografia - Alterar aqui!*/
//        return DigestUtils.sha256Hex(password);
//    }
}

