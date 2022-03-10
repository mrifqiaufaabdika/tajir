package com.tajir.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tajir.respones.Detail;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{

    @SerializedName("role")
    private List<String> role;

    @SerializedName("nip")
    private Object nip;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("perm")
    private List<String> perm;

    @SerializedName("name")
    private String name;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("email_verified_at")
    private Object emailVerifiedAt;

    @SerializedName("id")
    private long id;

    @SerializedName("detail")
    private Detail detail;

    @SerializedName("email")
    private String email;

    public List<String> getRole(){
        return role;
    }

    public Object getNip(){
        return nip;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public List<String> getPerm(){
        return perm;
    }

    public String getName(){
        return name;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public Object getEmailVerifiedAt(){
        return emailVerifiedAt;
    }

    public long getId(){
        return id;
    }

    public Detail getDetail(){
        return detail;
    }

    public String getEmail(){
        return email;
    }
}
