package com.zzyy.vhr.model2;

import java.util.Date;

public class PatientMzDetail {
    private String patient_id;
    private String patient_name;



    private int times;
    private String charge_code;
    private int charge_status;
    private int charge_amount;
    private double charge_price;

    private Date price_data;
    private String price_opera;
    private String dept_name;
    private String doctor_name;
    private String drugname;
    private String drug_amount; //用量
    private String specification;
    private Integer persist_days; //服用天数
    private String dosage;
    private String dosage_name;
    private String mini_name;
    private String pack_name;
    private String supply_name; //用药方式



    private String freq_code; //频率

    public String getFreq_code() {
        return freq_code;
    }

    public void setFreq_code(String freq_code) {
        this.freq_code = freq_code;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getCharge_code() {
        return charge_code;
    }

    public void setCharge_code(String charge_code) {
        this.charge_code = charge_code;
    }

    public int getCharge_status() {
        return charge_status;
    }

    public void setCharge_status(int charge_status) {
        this.charge_status = charge_status;
    }

    public int getCharge_amount() {
        return charge_amount;
    }

    public void setCharge_amount(int charge_amount) {
        this.charge_amount = charge_amount;
    }

    public double getCharge_price() {
        return charge_price;
    }

    public void setCharge_price(double charge_price) {
        this.charge_price = charge_price;
    }

    public Date getPrice_data() {
        return price_data;
    }

    public void setPrice_data(Date price_data) {
        this.price_data = price_data;
    }

    public String getPrice_opera() {
        return price_opera;
    }

    public void setPrice_opera(String price_opera) {
        this.price_opera = price_opera;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getDosage_name() {
        return dosage_name;
    }

    public void setDosage_name(String dosage_name) {
        this.dosage_name = dosage_name;
    }

    public String getMini_name() {
        return mini_name;
    }

    public void setMini_name(String mini_name) {
        this.mini_name = mini_name;
    }

    public String getPack_name() {
        return pack_name;
    }

    public void setPack_name(String pack_name) {
        this.pack_name = pack_name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    public String getDrug_amount() {
        return drug_amount;
    }

    public void setDrug_amount(String drug_amount) {
        this.drug_amount = drug_amount;
    }

    public Integer getPersist_days() {
        return persist_days;
    }

    public void setPersist_days(Integer persist_days) {
        this.persist_days = persist_days;
    }

    public String getSupply_name() {
        return supply_name;
    }

    public void setSupply_name(String supply_name) {
        this.supply_name = supply_name;
    }



}
