package com.ch.wit.authentication;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.ch.wit.BR;

public abstract class UserDetails extends BaseObservable {
    private String userName, batch,ktuId ,phoneNumber ,password;
    public UserDetails() {
    }
    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getKtuId() {
        return ktuId;
    }

    public void setKtuId(String ktuId) {
        this.ktuId = ktuId;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.userName);

    }

    public abstract  void action();
}

