package com.example.snowyleung.oven_fresh.BakerySearch;

public class MyMarker
{
    private String mLabel1;
    private String mLabel2;
    private String mIcon;
    private Double mLatitude;
    private Double mLongitude;

    public MyMarker(String label1, String label2, String icon, Double latitude, Double longitude)
    {
        this.mLabel1 = label1;
        this.mLabel2 = label2;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mIcon = icon;
    }

    public String getmLabel1()
    {
        return mLabel1;
    }

    public void setmLabel1(String mLabel)
    {
        this.mLabel1 = mLabel;
    }

    public String getmLabel2()
    {
        return mLabel2;
    }

    public void setmLabel2(String mLabel)
    {
        this.mLabel2 = mLabel;
    }

    public String getmIcon()
    {
        return mIcon;
    }

    public void setmIcon(String icon)
    {
        this.mIcon = icon;
    }

    public Double getmLatitude()
    {
        return mLatitude;
    }

    public void setmLatitude(Double mLatitude)
    {
        this.mLatitude = mLatitude;
    }

    public Double getmLongitude()
    {
        return mLongitude;
    }

    public void setmLongitude(Double mLongitude)
    {
        this.mLongitude = mLongitude;
    }
}
