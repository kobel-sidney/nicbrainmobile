package br.com.nicbrain.exception;

public class ServiceException extends NicbrainException {

    private static final long serialVersionUID = 6779633064380572209L;

    /**
     * Construtor definido para compatibilizada com API de checked Exception.
     * 
     * @param e
     */
    public ServiceException(final Exception e) {
        super(e);
    }

    /**
     * Construtor recebe String e outra exception.
     * 
     * @param message : mensagem do erro.
     * @param e : armazena a outra exception.
     */
    public ServiceException(final String message, final Exception e) {
        super(message, e);
    }

    /**
     * Construtor recebe String e outra exception.
     * 
     * @param message : mensagem do erro
     * @param params : paranetros que podem ser utilizados com bundle.
     */
    public ServiceException(final String message, final Object[] params) {
        super(message);
        super.params = params;
    }

    /**
     * Construtor recebe String representando a mensagem do erro.
     * 
     * @param message
     */
    public ServiceException(final String message) {
        super(message);
    }

}
