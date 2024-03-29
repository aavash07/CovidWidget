package com.aavash.dataFetch;

import com.aavash.dataFetch.Model.CountryData;
import com.aavash.dataFetch.Model.GlobalData;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CovidAPI {
    @GET("https://coronavirus-19-api.herokuapp.com/all")
    Call<GlobalData> getGlobalData();

    @GET("https://coronavirus-19-api.herokuapp.com/countries/{countryName}")
    Call<CountryData> getCountryData(@Path(value = "countryName") String countryName);
}
