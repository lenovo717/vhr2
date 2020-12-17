package com.zzyy.vhr.model2;

public class HFPatientFile {
    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getShfs() {
        return shfs;
    }

    public void setShfs(String shfs) {
        this.shfs = shfs;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getXzz() {
        return xzz;
    }

    public void setXzz(String xzz) {
        this.xzz = xzz;
    }

    public String getTgjc() {
        return tgjc;
    }

    public void setTgjc(String tgjc) {
        this.tgjc = tgjc;
    }

    public String getJcjg() {
        return jcjg;
    }

    public void setJcjg(String jcjg) {
        this.jcjg = jcjg;
    }

    public String getXdt() {
        return xdt;
    }

    public void setXdt(String xdt) {
        this.xdt = xdt;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

    public String getBxsy() {
        return bxsy;
    }

    public void setBxsy(String bxsy) {
        this.bxsy = bxsy;
    }

    public String getCyjg() {
        return cyjg;
    }

    public void setCyjg(String cyjg) {
        this.cyjg = cyjg;
    }

    public String getCytz() {
        return cytz;
    }

    public void setCytz(String cytz) {
        this.cytz = cytz;
    }

    public String getCyqk() {
        return cyqk;
    }

    public void setCyqk(String cyqk) {
        this.cyqk = cyqk;
    }

    public String getCydy() {
        return cydy;
    }

    public void setCydy(String cydy) {
        this.cydy = cydy;
    }

    private String  file_id;
    private String  patient_id;
    private String  shfs; //生活方式
    private String  bs; //病史
    private String  xzz; //现症状
    private String  tgjc; //体格检查
    private String  jcjg; //检测结果
    private String  xdt;  //心电图
    private String  cs;   //超声
    private String  bxsy; //步行试验
    private String  cyjg; //出院检测结果
    private String  cytz; //出院体征
    private String  cyqk; //出院情况
    private String  cydy; //出院带药

    /*   扩展属性 */
    private String name;
    private String social_no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocial_no() {
        return social_no;
    }

    public void setSocial_no(String social_no) {
        this.social_no = social_no;
    }
}
