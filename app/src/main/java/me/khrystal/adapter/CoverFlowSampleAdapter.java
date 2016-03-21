package me.khrystal.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import me.khrystal.activities.R;
import me.khrystal.widget.coverflow.KCoverFlow;
import me.khrystal.widget.coverflow.KCoverFlowAdapter;

/**
 * Created by kHRYSTAL on 16/3/21.
 */
public class CoverFlowSampleAdapter extends KCoverFlowAdapter {




    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6,};

    private Context mContext;

    public CoverFlowSampleAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Integer getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getCoverFlowItem(final int i, View reuseableView, ViewGroup viewGroup) {
        ImageView imageView = null;

        if (reuseableView != null) {
            imageView = (ImageView) reuseableView;
        } else {
            imageView = new ImageView(viewGroup.getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setLayoutParams(new KCoverFlow.LayoutParams(300, 400));


        }

        imageView.setImageResource(this.getItem(i));

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext,"item"+i,Toast.LENGTH_SHORT).show();
//            }
//        });

        return imageView;
    }
}

