package com.example.logonpf.shiftcarros.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.logonpf.shiftcarros.R;
import com.example.logonpf.shiftcarros.adapter.PokemonAdapter;
import com.example.logonpf.shiftcarros.api.PokemonAPI;
import com.example.logonpf.shiftcarros.model.Pokemon;
import com.example.logonpf.shiftcarros.model.PokemonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class PokemonFragment extends Fragment {


    private RecyclerView rvPokemons;

    public PokemonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pokemon, container, false);
        rvPokemons = (RecyclerView)v.findViewById(R.id.rvPokemons);
        rvPokemons.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPokemons.setHasFixedSize(true);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        carregaPokemons();
    }

    public void carregaPokemons() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonAPI api = retrofit.create(PokemonAPI.class);

        api.getPokemons()
                .enqueue(new Callback<PokemonResponse >() {
                    @Override
                    public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                        PokemonAdapter adapter = new PokemonAdapter(getContext(),
                                response.body().getResults());
                        rvPokemons.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<PokemonResponse> call, Throwable t) {
                        Toast.makeText(getContext(),
                                "Deu ruim!", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
