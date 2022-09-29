package com.rxjava2.android.medicinealert.model;




public class UserDetail {

    public long id;
    public String firstname;
    public String lastname;

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
