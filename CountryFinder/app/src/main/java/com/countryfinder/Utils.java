package com.countryfinder;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Utils {

    /**
     * Used to load the images using glide.
     *
     * @param context  Instance of the activity.
     * @param imageUrl Url path from the response.
     * @param view     Image view to load the url.
     */
    public static void glideLoadImage(Context context, String imageUrl, ImageView view) {
        Glide.with(context)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }
}
