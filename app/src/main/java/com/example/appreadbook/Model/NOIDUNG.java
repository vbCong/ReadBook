package com.example.appreadbook.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NOIDUNG {

@SerializedName("ID")
@Expose
private String iD;
@SerializedName("ANH")
@Expose
private String aNH;
@SerializedName("VANBAN")
@Expose
private String vANBAN;
@SerializedName("IDCHUONG")
@Expose
private String iDCHUONG;

public String getID() {
return iD;
}

public void setID(String iD) {
this.iD = iD;
}

public String getANH() {
return aNH;
}

public void setANH(String aNH) {
this.aNH = aNH;
}

public String getVANBAN() {
return vANBAN;
}

public void setVANBAN(String vANBAN) {
this.vANBAN = vANBAN;
}

public String getIDCHUONG() {
return iDCHUONG;
}

public void setIDCHUONG(String iDCHUONG) {
this.iDCHUONG = iDCHUONG;
}

    public NOIDUNG(String iD, String aNH, String vANBAN, String iDCHUONG) {
        this.iD = iD;
        this.aNH = aNH;
        this.vANBAN = vANBAN;
        this.iDCHUONG = iDCHUONG;
    }

    public NOIDUNG(String iD, String aNH, String iDCHUONG) {
        this.iD = iD;
        this.aNH = aNH;
        this.iDCHUONG = iDCHUONG;
    }

}