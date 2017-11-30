package com.hqc.demo.Parcelable;
import android.os.Parcel;
import android.os.Parcelable;

public class Company implements Parcelable {

    private String name;
    private int id;
    private String size;
    private boolean isMarket;

    /**
     * Parcel 可以看作一个流。
     * 数据写入和读出的顺序要一致。
     */

    // Creator使用的构造对象的方法
    protected Company(Parcel in) {
        this.name = in.readString();
        this.id = in.readInt();
        this.size = in.readString();
        this.isMarket = in.readInt() == 1 ? true : false;
    }

    // 必须实现的一个Creator，用来外部创建对象
    public static final Creator<Company> CREATOR = new Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        @Override// 创建多个对象。
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };

    @Override// 描述内容，一般不用关心
    public int describeContents() {
        return 0;
    }

    @Override// 写入Parcel
    public void writeToParcel(Parcel out, int i) {
        out.writeString(name);
        out.writeInt(id);
        out.writeString(size);
        out.writeInt(isMarket?1:0);
    }
}
