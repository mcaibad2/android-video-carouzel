package com.wappier.android.video.carouzel;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomPagerAdapter extends PagerAdapter {

    private final Context mContext;
    private final List<Banner> mBanners;

    public CustomPagerAdapter(Context context, List<Banner> banners) {
        mContext = context;
        mBanners = banners;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        Banner banner = mBanners.get(position);
        View view = null;
        if (banner.getType().equals("image")) {
            view = inflater.inflate(R.layout.item_image, collection, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            Picasso.with(mContext).load(banner.getUrl()).into(imageView);
        } else if (banner.getType().equals("video")) {
            view = inflater.inflate(R.layout.item_video, collection, false);
            VideoView videoView = (VideoView) view.findViewById(R.id.videoView);
            videoView.setVideoURI(Uri.parse("android.resource://" + mContext.getPackageName() + "/" + R.raw.kitkat));
            videoView.requestFocus();
            videoView.start();
        }
        collection.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return mBanners.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
