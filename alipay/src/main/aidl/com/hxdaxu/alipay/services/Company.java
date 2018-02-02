package com.hxdaxu.alipay.services;


import android.os.Parcel;
import android.os.Parcelable;

public class Company implements Parcelable{

    private String name;
    private int id;
    private String size;
    private boolean isMarket;



    protected Company(Parcel in) {
        this.name = in.readString();
        this.id = in.readInt();
        this.size = in.readString();
        this.isMarket = in.readInt() == 1 ? true : false;
    }

    public static final Creator<Company> CREATOR = new Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(name);
        out.writeInt(id);
        out.writeString(size);
        out.writeInt(isMarket?1:0);
    }
}
