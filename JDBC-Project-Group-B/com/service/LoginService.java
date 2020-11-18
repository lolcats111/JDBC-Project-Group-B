package com.service;

import com.bean.Customer;
import com.dao.CustomerDao;
import com.dao.LoginDao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class LoginService {
	public LoginService(){
        super();
    }

	public boolean isAuthorised(String username, String password) throws NoSuchAlgorithmException {
        //Get the users password hash from the db, if it exists
        LoginDao dao = new LoginDao();
        byte[] clarkMD5Hash = dao.getClarkHash(username);
        // Null if there's no such username.
        if(clarkMD5Hash==null) return false;

        //Generate MD5 hash of the given password
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();

        //Shallow compare the two hashes for equality
        return Arrays.equals(clarkMD5Hash, digest);
    }

}
