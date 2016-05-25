package br.com.nicbrain.repository;

import com.google.gson.Gson;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import br.com.nicbrain.dao.UserDao;
import br.com.nicbrain.exception.ServiceException;
import br.com.nicbrain.model.User;
import br.com.nicbrain.net.NicbrainEndpoint;
import br.com.nicbrain.util.ConnectionUtil;
import br.com.nicbrain.util.NicBrainUtil;


public class UserRepository {

    private final String TAG = this.getClass().getName();
    protected UserDao userDao;

    public User getLogin(final String mail, final String password) throws ServiceException {

        HttpHeaders requestHeaders = new HttpHeaders();
        userDao = new UserDao();

        User user = null;
        if(ConnectionUtil.verififyConnection()){
            HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            String url = NicbrainEndpoint.URL_LOGIN + mail + "/" + password;
            String response  = restTemplate.exchange(url, HttpMethod.GET,
                    requestEntity, String.class).getBody();

            Gson gson = new Gson();
            user = gson.fromJson(response, User.class);
            user.setEmail(mail);
            user.setSenha(password);
            userDao.saveOrUpdate(user);


        }else{
            user = userDao.getUsuarioByEmail(mail, password);
        }
        NicBrainUtil.setIdUsuario(user.getIdUsuario());
        return user;
    }

}
