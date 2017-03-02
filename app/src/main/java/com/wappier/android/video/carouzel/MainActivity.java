package com.wappier.android.video.carouzel;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Banner> banners = new ArrayList<Banner>();
        banners.add(new Banner("image", "http://www.wallpapersxl.com/wallpapers/800x600/busou-shinki/143319/busou-shinki-robotech-143319.jpg"));
        banners.add(new Banner("video", "http://res.cloudinary.com/krupen/video/upload/w_300,h_300,c_crop,q_70/v1481795675/3_yqeudi.mp4"));
        banners.add(new Banner("image", "https://www.walldevil.com/wallpapers/a46/macross-aircrafts-wallpaper-robotech-images-wallpoper-planes-paintings-artistic-wallpapers-plane.jpg"));

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this, banners));
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }
}
