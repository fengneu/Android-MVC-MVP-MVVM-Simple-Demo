package com.example.mvcmvpmvvm.mvvm.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mvcmvpmvvm.mvvm.model.Person;
import com.example.mvcmvpmvvm.mvvm.model.User;


/**
 * @author jere
 */
public class LoginViewModel extends ViewModel {
    private User user;
    private Person person;
    private MutableLiveData<Boolean> isLoginSuccessfulLD;

    public LoginViewModel() {
        this.isLoginSuccessfulLD = new MutableLiveData<>();
        user = new User();
        person = new Person();
    }

    public MutableLiveData<Boolean> getIsLoginSuccessfulLD() {
        return isLoginSuccessfulLD;
    }

    public void setIsLoginSuccessfulLD(boolean isLoginSuccessful) {
        isLoginSuccessfulLD.postValue(isLoginSuccessful);
    }

    public void login(String userName, String password) {
        if (userName.equals("jere") && password.equals("123")) {
            user.setUserName(userName);
            user.setPassword(password);
            person.setName(userName);
            person.setId(Integer.parseInt(password));
            setIsLoginSuccessfulLD(true);
        } else {
            setIsLoginSuccessfulLD(false);
        }
    }

    public String getUserName() {
        return user.getUserName();
    }
    public String getPersonName() { return person.getName();}
    public int getPersionId() { return person.getId();}
}
