package com.example.logonpf.shiftcarros.api;

import com.example.logonpf.shiftcarros.model.Pokemon;
import com.example.logonpf.shiftcarros.model.PokemonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by logonpf on 07/10/2017.
 */

public interface PokemonAPI {

    @GET("api/v2/pokemon")
    Call<PokemonResponse> getPokemons();

    @GET("api/v2/pokemon/{numeroPokemon}")
    Call<Pokemon> getPokemon(@Path(value = "numeroPokemon") int numeroPokemon);

}
