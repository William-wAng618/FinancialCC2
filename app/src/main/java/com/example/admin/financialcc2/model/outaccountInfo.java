package com.example.admin.financialcc2.model;

import java.io.Serializable;

/**
 * Created by admin on 2019/4/17.
 */

public class outaccountInfo implements Serializable{
    private int _id;
    private float money;
    private String time;
    private String type;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String mark;




    @Override
    public String toString() {
        return super.toString();
    }
}
