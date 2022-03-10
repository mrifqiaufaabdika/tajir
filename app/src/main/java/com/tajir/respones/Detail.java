package com.tajir.respones;

import com.google.gson.annotations.SerializedName;

public class Detail{

	@SerializedName("ip")
	private String ip;

	@SerializedName("lastAccess")
	private String lastAccess;

	public String getIp(){
		return ip;
	}

	public String getLastAccess(){
		return lastAccess;
	}
}