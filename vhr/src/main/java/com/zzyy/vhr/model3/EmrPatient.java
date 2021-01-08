package com.zzyy.vhr.model3;

import com.zzyy.vhr.model2.PatientMzDetail;

import java.util.Date;
import java.util.List;

public class EmrPatient {
    private String  patient_id;
    private int visit_time;
    private String patient_name;
    private String home_tel;
    private String inpatient_no;
    private Date birth;
    private String sex;
    private String social_no;
    private String address;
    private Date in_date;
    private String in_dept_name;
    private String in_dept;
    private Date dis_date;
    private String dis_dept_name;
    private String dis_dept;
    private String diagnosis;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public int getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(int visit_time) {
        this.visit_time = visit_time;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getHome_tel() {
        return home_tel;
    }

    public void setHome_tel(String home_tel) {
        this.home_tel = home_tel;
    }

    public String getInpatient_no() {
        return inpatient_no;
    }

    public void setInpatient_no(String inpatient_no) {
        this.inpatient_no = inpatient_no;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSocial_no() {
        return social_no;
    }

    public void setSocial_no(String social_no) {
        this.social_no = social_no;
    }

    public Date getIn_date() {
        return in_date;
    }

    public void setIn_date(Date in_date) {
        this.in_date = in_date;
    }

    public String getIn_dept_name() {
        return in_dept_name;
    }

    public void setIn_dept_name(String in_dept_name) {
        this.in_dept_name = in_dept_name;
    }

    public String getIn_dept() {
        return in_dept;
    }

    public void setIn_dept(String in_dept) {
        this.in_dept = in_dept;
    }

    public Date getDis_date() {
        return dis_date;
    }

    public void setDis_date(Date dis_date) {
        this.dis_date = dis_date;
    }

    public String getDis_dept_name() {
        return dis_dept_name;
    }

    public void setDis_dept_name(String dis_dept_name) {
        this.dis_dept_name = dis_dept_name;
    }

    public String getDis_dept() {
        return dis_dept;
    }

    public void setDis_dept(String dis_dept) {
        this.dis_dept = dis_dept;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
