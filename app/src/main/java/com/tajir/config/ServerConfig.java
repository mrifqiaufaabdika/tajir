package com.tajir.config;

public class ServerConfig {

    /**
     * Url Server
     */
    private static final String BASE_URL_API = "https://api.tmp.trimueri.com/public/api/v1/";

    private static final String BASE_URL_API_ARTICEL = "https://trimueri.com/";

    //url test local ip
   // private static final String BASE_URL_API_LOCAL = "http://192.168.43.34:7002/api/v1/";
    private static final String BASE_URL_API_LOCAL = "http://192.168.23.56:7002/api/v1/";


    /**
     * Mendeklarasikan Interface BaseApiService for pemol api
     * @return
     */
    public static ApiService getAPIService(){
        return ApiConfig.getClient(BASE_URL_API_LOCAL).create(ApiService.class);
    }

    /**
     * Mendeklarasikan Interface BaseApiService for pemol articel api
     * @return
     */
    public static ApiService getArticelAPIService(){
        return ApiConfig.getClient(BASE_URL_API_ARTICEL).create(ApiService.class);
    }
}
