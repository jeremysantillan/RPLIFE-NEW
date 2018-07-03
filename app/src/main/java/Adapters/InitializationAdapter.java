package Adapters;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.santillanj.rplife_z.R;

import java.util.List;

import Interfaces.InitializationRecyclerListener;
import Models.InitializationType;


/**
 * Created by Jeremy on 7/1/2018.
 */

public class InitializationAdapter extends RecyclerView.Adapter<InitializationAdapter.ViewHolder> {

    private Context context;
    private InitializationAdapter.ViewHolder viewHolder;
    private List<InitializationType> initTypeList;
    private InitializationRecyclerListener typeInterface;

    public static final String TAG = "INITADAPTER";

    public InitializationAdapter(List<InitializationType> initTypeList, InitializationRecyclerListener typeInterface) {
        this.initTypeList = initTypeList;
        this.typeInterface = typeInterface;
    }

    @Override
    public InitializationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        final View itemLayoutView = LayoutInflater.from(context)
                .inflate(R.layout.card_layout_initialization, null);
        viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final InitializationType itemType = initTypeList.get(position);
        Log.d(TAG, "onBindViewHolder: POSITION " + position + "  " + itemType.getTypeName());
        Glide.with(holder.mImgInitType.getContext()).load(itemType.getTypeImgID()).into(holder.mImgInitType);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: POSITION "+position);
                typeInterface.onInitRecyclerItemClick(initTypeList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return initTypeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImgInitType;
        public ViewHolder(View itemView) {
            super(itemView);
            mImgInitType = itemView.findViewById(R.id.mImgInitTypeLogo);
        }
    }
}
