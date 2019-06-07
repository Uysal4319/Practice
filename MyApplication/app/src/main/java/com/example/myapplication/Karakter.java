package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Karakter implements Parcelable {
    int kilo ;
    int hareketSayisi;
    int saldiriGucu;
    String isim ="karakerinize isim verin ";
    public String yemek(){
        if(hareketSayisi>0){
            kilo++;
            hareketSayisi--;
            return "yemek yedi ve kilosu arttı";
        }else
            return "yeterli hareket yok";

    }

    public String  uyumak(){
        if(hareketSayisi>0){
            hareketSayisi--;
            return "karakteriniz uyudu";
        }else
            return "yeterli hareket yok";


    }

    public String  savas(){
        if (hareketSayisi>0){
            hareketSayisi--;
            saldiriGucu++;
            return "karakteriniz savaşti";
        }else
            return "yeterli hareket yok";

    }



    @Override
    public String toString(){
        return "isim : "+isim
                +"\n kilo : " + kilo
                +"\n hareket sayisi : "+ hareketSayisi
                +"\n Saldiri gucu : "+saldiriGucu;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.kilo);
        dest.writeInt(this.hareketSayisi);
        dest.writeInt(this.saldiriGucu);
        dest.writeString(this.isim);
    }

    public Karakter() {
    }

    protected Karakter(Parcel in) {
        this.kilo = in.readInt();
        this.hareketSayisi = in.readInt();
        this.saldiriGucu = in.readInt();
        this.isim = in.readString();
    }

    public static final Parcelable.Creator<Karakter> CREATOR = new Parcelable.Creator<Karakter>() {
        @Override
        public Karakter createFromParcel(Parcel source) {
            return new Karakter(source);
        }

        @Override
        public Karakter[] newArray(int size) {
            return new Karakter[size];
        }
    };
}
