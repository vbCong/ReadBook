package com.example.appreadbook.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CHUONG {

@SerializedName("ID")
@Expose
private int iD;
@SerializedName("TENCHUONG")
@Expose
private String tENCHUONG;
@SerializedName("IDTRUYEN")
@Expose
private int iDTRUYEN;
@SerializedName("TTND")
@Expose
private String tTND;

public int getID() {
return iD;
}

public void setID(int iD) {
this.iD = iD;
}

public String getTENCHUONG() {
return tENCHUONG;
}

public void setTENCHUONG(String tENCHUONG) {
this.tENCHUONG = tENCHUONG;
}

public int getIDTRUYEN() {
return iDTRUYEN;
}

public void setIDTRUYEN(int iDTRUYEN) {
this.iDTRUYEN = iDTRUYEN;
}

public String getTTND() {
return tTND;
}

public void setTTND(String tTND) {
this.tTND = tTND;
}

    public CHUONG(int iD, String tENCHUONG, int iDTRUYEN, String tTND) {
        this.iD = iD;
        this.tENCHUONG = tENCHUONG;
        this.iDTRUYEN = iDTRUYEN;
        this.tTND = tTND;
    }

    public CHUONG(int iD, String tENCHUONG) {
        this.iD = iD;
        this.tENCHUONG = tENCHUONG;
    }
}