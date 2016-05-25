package br.com.nicbrain.util;


import br.com.nicbrain.response.HeaderHttpResponse;

/**
 * Created by eduardoabreu on 03/23/16.
 */
public abstract class OperationListener<TResult> {

    public abstract void onOperationSucces(final TResult result);

    public abstract void onOperationSucessWithError(final TResult result, final HeaderHttpResponse error);

}
