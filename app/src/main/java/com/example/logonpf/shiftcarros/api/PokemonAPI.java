package com.example.logonpf.shiftcarros.api;

import com.example.logonpf.shiftcarros.model.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by logonpf on 07/10/2017.
 */

public interface PokemonAPI {

    @GET("api/v2/pokemon")
    Call<List<Pokemon>> getPokemons();

}
