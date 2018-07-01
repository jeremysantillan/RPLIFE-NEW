package Adapters;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.santillanj.rplife_z.R;

import java.util.List;


/**
 * Created by Jeremy on 7/1/2018.
 */

public class InitializationAdapter extends RecyclerView.Adapter<InitializationAdapter.ViewHolder> {

    private Context context;
    private InitializationAdapter.ViewHolder viewHolder;
    private List<String> initTypeList;

    public static final String TAG = "INITADAPTER";


    public InitializationAdapter(List<String> initTypeList) {
        this.initTypeList = initTypeList;
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String itemType= initTypeList.get(position);
        Log.d(TAG, "onBindViewHolder: POSITION "+position+"  "+itemType);



        if(itemType!=null){
            switch (itemType){
                case "type_elima":
                    Log.d(TAG,"TYPE_ELIMA");
                    Glide.with(holder.mImgInitType.getContext()).load(R.drawable.img_elima_logo_new).into(holder.mImgInitType);
                    break;
                case "type_erudite":
                    Log.d(TAG,"TYPE_ERUDITE");
                    Glide.with(holder.mImgInitType.getContext()).load(R.drawable.img_erudite_logo_new).into(holder.mImgInitType);
                    break;
                case "type_locked_1":
                    Log.d(TAG,"TYPE_LOCKED_1");
                    Glide.with(holder.mImgInitType.getContext()).load(R.drawable.img_initialization_locked_1).into(holder.mImgInitType);
                    break;
                case "type_locked_2":
                    Log.d(TAG,"TYPE_LOCKED_2");
                    Glide.with(holder.mImgInitType.getContext()).load(R.drawable.img_initialization_locked_2).into(holder.mImgInitType);
                    break;
                case "type_locked_3":
                    Log.d(TAG,"TYPE_LOCKED_3");
                    Glide.with(holder.mImgInitType.getContext()).load(R.drawable.img_initialization_locked_3).into(holder.mImgInitType);
                    break;
                default:
                    Log.d(TAG,"TYPE_LOCKED");
                    Glide.with(holder.mImgInitType.getContext()).load(R.drawable.img_initialization_locked_3).into(holder.mImgInitType);
                    break;
            }
        }

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
