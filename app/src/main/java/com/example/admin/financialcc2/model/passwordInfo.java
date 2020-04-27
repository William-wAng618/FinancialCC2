package com.example.admin.financialcc2.model;

import java.io.Serializable;

/**
 * Created by admin on 2019/4/16.
 */

public class passwordInfo implements Serializable {
    private String password;

    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
