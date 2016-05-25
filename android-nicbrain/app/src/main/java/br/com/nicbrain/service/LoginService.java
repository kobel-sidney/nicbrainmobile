package br.com.nicbrain.service;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import br.com.nicbrain.exception.ServiceException;
import br.com.nicbrain.model.User;
import br.com.nicbrain.repository.UserRepository;
import br.com.nicbrain.util.OperationListener;

/**
 * Created by eduardoabreu on 5/23/16.
 */
public class LoginService extends BaseService {

    private final String TAG = this.getClass().getName();



    public void getLogin(Activity activity, final Context context, final String email, final String senha, final OperationListener<User> callbackService) throws ServiceException {

        final AsyncTask<Void, Void, User> asyncTask = new AsyncTask<Void, Void, User>() {
            @Override
            protected void onPreExecute(){

            }

            @Override
            protected User doInBackground(Void... params) {
                UserRepository usuarioRepository = new UserRepository();
                User response = usuarioRepository.getLogin(email, senha);
                return response;
            }
            @Override
            protected void onPostExecute(User result){
                callbackService.onOperationSucces(result);
            }
        };
        asyncTask.execute();
    }

}
