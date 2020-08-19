package com.yono.applicationscanner.mvv.response;

import com.google.gson.annotations.SerializedName;

public class ExampleResponse {
    @SerializedName("namaAsset")
    private String namaAssetExample;

    @SerializedName("images")
    private String imagesExample;

    public String getNamaAssetExample() {
        return namaAssetExample;
    }

    public ExampleResponse(String namaAssetExample, String imagesExample) {
        this.namaAssetExample = namaAssetExample;
        this.imagesExample = imagesExample;
    }

    public void setNamaAssetExample(String namaAssetExample) {
        this.namaAssetExample = namaAssetExample;
    }

    public String getImagesExample() {
        return imagesExample;
    }

    public void setImagesExample(String imagesExample) {
        this.imagesExample = imagesExample;
    }
}
