package com.example.prototype;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewHeroAdapter extends RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>{
    private ArrayList<Hero> listHero;
    public CardViewHeroAdapter(ArrayList<Hero> list) {
        this.listHero = list;
    }
    private CardViewHeroAdapter.OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(CardViewHeroAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    private CardViewHeroAdapter.OnItemClickCallback onItemClickCallback2;
    public void setOnItemClickCallback2(CardViewHeroAdapter.OnItemClickCallback onItemClickCallback2) {
        this.onItemClickCallback2 = onItemClickCallback2;
    }
    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_hero, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position) {
        Hero hero = listHero.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(hero.getName());
        holder.tvDetail.setText(hero.getDetail());
        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite " +
                        listHero.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(holder.itemView.getContext(), "Share " +listHero.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                onItemClickCallback2.onItemClicked(listHero.get(holder.getAdapterPosition()));
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listHero.get(holder.getAdapterPosition()));
                //Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listHero.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                //Intent move =new Intent(Intent.ACTION_SEND);
                //move.setType("text/plain");
                //move.putExtra(Intent.EXTRA_SUBJECT,"Insert Subject Here");
                //String app_url="https://play.google.com/store/apps/details?id=com.example.administrator";
                //move.putExtra(Intent.EXTRA_TEXT,app_url);
                //startActivity();
            }
        });
    }
    public interface OnItemClickCallback {
        void onItemClicked(Hero data);
    }


    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnFavorite, btnShare;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
