package com.santillanj.rplife_z.Adapters;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.santillanj.rplife_z.Models.CharacterParts;
import com.santillanj.rplife_z.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeremy on 7/6/2018.
 */

public class CharacterCreationAdapter extends RecyclerView.Adapter<CharacterCreationAdapter.ViewHolder> {

    private ArrayList<CharacterParts> charPartsList;

    public CharacterCreationAdapter(ArrayList<CharacterParts> charPartsList) {
        this.charPartsList = charPartsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.card_layout_char_create, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CharacterParts item = charPartsList.get(position);

        Glide.with(holder.itemView.getContext())
                .load(item.getPartImg())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return charPartsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.mImgCharCard);
        }
    }
}