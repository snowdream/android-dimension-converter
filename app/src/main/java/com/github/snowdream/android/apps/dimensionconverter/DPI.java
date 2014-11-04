package com.github.snowdream.android.apps.dimensionconverter;

public enum DPI{
    LDPI(120,0.75f),
    MDPI(160,1f),
    TVDPI(213,1.33f),
    HDPI(240,1.5f),
    XHDPI(320,2f),
    XXHDPI(480,3f),
    XXXHDPI(640,4f);

    private float ratio;
    private int dpi;

    private DPI(){};

    private DPI(final int dpi,final float ratio){
        this.dpi = dpi;
        this.ratio = ratio;
    }

    public int getDPI(){
        return this.dpi;
    }

    public float getRatio(){
        return this.ratio;
    }
}