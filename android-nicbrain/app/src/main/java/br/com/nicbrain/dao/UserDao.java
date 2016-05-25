package br.com.nicbrain.dao;

import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import br.com.nicbrain.exception.ServiceException;
import br.com.nicbrain.model.User;

/**
 * Created by eduardoabreu on 5/23/16.
 */
public class UserDao {

    public User getUsuarioByEmail(String email, String senha){

        return new Select()
                .from(User.class)
                .where("email = ?", email)
                .and("senha = ?", senha)
                .executeSingle();

    }


    public void save(final Context context, User usuario) throws ServiceException {
        ActiveAndroid.beginTransaction();

        try {
            usuario.save();
            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }

    public void saveOrUpdate(final User user) throws ServiceException {
        ActiveAndroid.beginTransaction();

        try {

            User userSelected = new Select()
                    .from(User.class)
                    .where("email = ?", user.getEmail())
                    .and("senha = ?", user.getSenha())
                    .executeSingle();

            if(userSelected != null){
                userSelected.delete();
            }

            user.save();

        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }


}
