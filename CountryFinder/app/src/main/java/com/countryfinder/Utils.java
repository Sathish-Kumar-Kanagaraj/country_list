package com.countryfinder;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.RequestBuilder;

public class Utils {

    private static RequestBuilder<PictureDrawable> requestBuilder;

    /**
     * Used to load the images using glide.
     *
     * @param context  Instance of the activity.
     * @param imageUrl Url path from the response.
     * @param view     Image view to load the url.
     */
    public static void glideLoadImage(Context context, String imageUrl, ImageView view) {
        requestBuilder = GlideApp.with(context)
                .as(PictureDrawable.class)
                .listener(new SvgSoftwareLayerSetter());

        requestBuilder.load(imageUrl).into(view);

    }
}
