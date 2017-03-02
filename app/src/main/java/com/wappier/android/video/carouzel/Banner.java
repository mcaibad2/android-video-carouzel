package com.wappier.android.video.carouzel;

public class Banner {
    private String mType;
    private String mUrl;

    public Banner(String type, String url) {
        this.mType = type;
        this.mUrl = url;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }
}
