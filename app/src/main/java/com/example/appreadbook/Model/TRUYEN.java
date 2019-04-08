package com.example.appreadbook.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class TRUYEN {

    @SerializedName("ID")
    @Expose
    private int iD;
    @SerializedName("TEN")
    @Expose
    private String tEN;
    @SerializedName("TACGIA")
    @Expose
    private String tACGIA;
    @SerializedName("NXB")
    @Expose
    private String nXB;
    @SerializedName("TENTHELOAI")
    @Expose
    private String tENTHELOAI;
    @SerializedName("ANHBIA")
    @Expose
    private String aNHBIA;
    @SerializedName("TTND")
    @Expose
    private String tTND;

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public String getTEN() {
        return tEN;
    }

    public void setTEN(String tEN) {
        this.tEN = tEN;
    }

    public String getTACGIA() {
        return tACGIA;
    }

    public void setTACGIA(String tACGIA) {
        this.tACGIA = tACGIA;
    }

    public String getNXB() {
        return nXB;
    }

    public void setNXB(String nXB) {
        this.nXB = nXB;
    }

    public String getTENTHELOAI() {
        return tENTHELOAI;
    }

    public void setTENTHELOAI(String tENTHELOAI) {
        this.tENTHELOAI = tENTHELOAI;
    }

    public String getANHBIA() {
        return aNHBIA;
    }

    public void setANHBIA(String aNHBIA) {
        this.aNHBIA = aNHBIA;
    }

    public String getTTND() {
        return tTND;
    }

    public void setTTND(String tTND) {
        this.tTND = tTND;
    }

    public TRUYEN(int iD, String tEN, String tENTHELOAI, String aNHBIA) {
        this.iD = iD;
        this.tEN = tEN;
        this.tENTHELOAI = tENTHELOAI;
        this.aNHBIA = aNHBIA;
    }
}
