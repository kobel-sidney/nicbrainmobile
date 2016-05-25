package br.com.nicbrain.exception;

import java.text.MessageFormat;

public class NicbrainException extends RuntimeException {

    private static final long serialVersionUID = 3422494428773141388L;

    protected Object[] params;

    public NicbrainException(final String mensagem) {
        super(mensagem);
    }

    public NicbrainException(final String mensagem, final Object[] params) {
        super(MessageFormat.format(mensagem, params));
    }

    public NicbrainException(final String mensagem, final Throwable cause) {
        super(mensagem, cause);
    }

    public NicbrainException(final String mensagem, final Object[] params, final Throwable cause) {
        super(MessageFormat.format(mensagem, params), cause);
    }

    protected NicbrainException() {
        super();
    }

    public NicbrainException(final Throwable cause) {
        super(cause);
    }

    public Object[] getParams() {
        return params;
    }

}
