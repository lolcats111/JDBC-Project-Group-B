package com.service;
import com.dao.CreateAccountDao;
import com.dao.CustomerDao;
import com.dao.LoginDao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CreateAccountService {
    public CreateAccountService(){
        super();
    }

    public boolean createAccount(String username, String password) throws NoSuchAlgorithmException {
        //Get the users password hash from the db, if it exists
        CreateAccountDao dao = new CreateAccountDao();
    
        //Generate MD5 hash of the given password
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();

        boolean succeeded = dao.createAccount(username, digest);

        return succeeded;
    }

}
