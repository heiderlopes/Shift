package com.example.logonpf.shiftcarros.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.logonpf.shiftcarros.R;
import com.example.logonpf.shiftcarros.model.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonAdapter
        extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private Context context;
    private List<Pokemon> pokemons;

    public PokemonAdapter(Context context, List<Pokemon> pokemons) {
        super();
        this.context = context;
        this.pokemons = pokemons;
    }

    //Aqui estamos selecionando o layout da linha da nossa lista
    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pokemon_item, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemons.get(position);
        holder.tvNomePokemon.setText(pokemon.getNome());
        Picasso.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
                        + (position + 1) + ".png")
                .error(R.drawable.erro)
                .placeholder(R.drawable.placeholder)
                .into(holder.ivPokemon);
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {

        TextView tvNomePokemon;
        ImageView ivPokemon;

        public PokemonViewHolder(View itemView) {
            super(itemView);
            tvNomePokemon = (TextView) itemView.findViewById(R.id.tvNomePokemon);
            ivPokemon = (ImageView) itemView.findViewById(R.id.ivPokemon);
        }
    }
}
