package com.santillanj.rplife_z.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.santillanj.rplife_z.Adapters.CharacterCreationAdapter;
import com.santillanj.rplife_z.Models.CharacterParts;
import com.santillanj.rplife_z.R;

import java.util.ArrayList;

/**
 * Created by Jeremy on 7/12/2018.
 */

public class CharPartFragment extends Fragment {
    private static String TAG = "CharPartFragment";
    private RecyclerView mRecyclerCharParts;
    private ArrayList<CharacterParts> mCharPartsList;

    public CharPartFragment(){

    }

    public static CharPartFragment newInstance(ArrayList<CharacterParts> characterParts){
        Bundle args = new Bundle();
        args.putSerializable("CharParts", characterParts);
        CharPartFragment fragment = new CharPartFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_charpart, container, false);
        view.setTag(TAG);

        mRecyclerCharParts = view.findViewById(R.id.mRecyclerCharPart);
        CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());

        mCharPartsList = (ArrayList<CharacterParts>) getArguments().getSerializable("CharParts");

        mRecyclerCharParts.setLayoutManager(layoutManager);
        mRecyclerCharParts.setAdapter(new CharacterCreationAdapter(mCharPartsList));
        mRecyclerCharParts.setHasFixedSize(true);
        mRecyclerCharParts.addOnScrollListener(new CenterScrollListener());
        mRecyclerCharParts.scrollToPosition(4);

        return view;
    }
}
