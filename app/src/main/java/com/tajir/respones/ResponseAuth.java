package com.tajir.respones;

import com.google.gson.annotations.SerializedName;
import com.tajir.model.User;

public class ResponseAuth{

	@SerializedName("msg")
	private String msg;

	@SerializedName("value")
	private User value;

	@SerializedName("token")
	private String token;

	public String getMsg(){
		return msg;
	}

	public User getValue(){
		return value;
	}

	public String getToken(){
		return token;
	}
}