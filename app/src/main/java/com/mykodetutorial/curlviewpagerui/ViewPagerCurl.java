package com.mykodetutorial.curlviewpagerui;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Suyono on 5/26/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
public class ViewPagerCurl extends ViewPager {

    public int setResource(String name, String Type)
    {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }

    public ViewPagerCurl(Context context, AttributeSet attrs) {
        super(context, attrs);
        AdapterExpandedViewpagerUI adapter = new AdapterExpandedViewpagerUI();
        final ViewPager EasyExpandedViewPagerUI = (ViewPager) this.findViewById(setResource("id_viewpager_curl","id"));
        EasyExpandedViewPagerUI.setPageTransformer(true, new HalamanCurlPageTransformer());
        EasyExpandedViewPagerUI.setAdapter(adapter);
        EasyExpandedViewPagerUI.setOffscreenPageLimit(5);
    }

    private static class HalamanCurlPageTransformer implements PageTransformer {

        @Override
        public void transformPage(View page, float position) {

            if (page instanceof HalamanCurl) {
                if (position > -1.0F && position < 1.0F) {
                    // hold the page steady and let the views do the work
                    page.setTranslationX(-position * page.getWidth());
                } else {
                    page.setTranslationX(0.0F);
                }
                if (position <= 1.0F && position >= -1.0F) {
                    ((HalamanCurl) page).setCurlFactor(position);
                }
            }
        }
    }


    private class AdapterExpandedViewpagerUI extends PagerAdapter {
        @Override
        public int getCount () {
            return 5;
        }

        @Override
        public Object instantiateItem (ViewGroup container,int position){
            int tampilkanMenurutId = 0;
            switch (position) {
                case 0:
                    tampilkanMenurutId = setResource("id_halaman_curl_1","id");

                    break;
                case 1:
                    tampilkanMenurutId = setResource("id_halaman_curl_2","id");
                    break;
                case 2:
                    tampilkanMenurutId = setResource("id_halaman_curl_3","id");
                    break;
                case 3:
                    tampilkanMenurutId = setResource("id_halaman_curl_4","id");
                    break;
                case 4:
                    tampilkanMenurutId = setResource("id_halaman_curl_5","id");
                    break;
            }

            return findViewById(tampilkanMenurutId);

        }

        @Override
        public boolean isViewFromObject (View arg0, Object arg1){
            return arg0 ==  arg1;
        }

        @Override
        public Parcelable saveState () {
            return null;
        }
    }
}
