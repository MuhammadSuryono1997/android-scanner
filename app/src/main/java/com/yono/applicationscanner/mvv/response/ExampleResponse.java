package com.yono.applicationscanner.mvv.response;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

public class ExampleResponse {
    @SerializedName("asset")
    private String assetExample;

    @SerializedName("image")
    private String imageExample;

    public ExampleResponse(String assetExample, String imageExample) {
        this.assetExample = assetExample;
        this.imageExample = imageExample;
    }

    public String getAssetExample() {
        return assetExample;
    }

    public void setAssetExample(String assetExample) {
        this.assetExample = assetExample;
    }

    public String getImageExample() {
        return imageExample;
    }

    public void setImageExample(String imageExample) {
        this.imageExample = imageExample;
    }

    @BindingAdapter("imageLastUpdate")
    public static void loadImage(ImageView view, String backdropPathTrending){
        Picasso.get().load(backdropPathTrending).into(view);
    }
}
