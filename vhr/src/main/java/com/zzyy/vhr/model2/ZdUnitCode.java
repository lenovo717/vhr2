package com.zzyy.vhr.model2;

public class ZdUnitCode {

     private String unit_sn;
     private String code;

    @Override
    public String toString() {
        return "ZdUnitCode{" +
                "unit_sn='" + unit_sn + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getUnit_sn() {
        return unit_sn;
    }

    public void setUnit_sn(String unit_sn) {
        this.unit_sn = unit_sn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
