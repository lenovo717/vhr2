package com.zzyy.vhr.model2;

import java.util.Date;
import java.util.List;

public class Patient {
    private String  patient_id;
    private String patient_name;
    private String home_tel;
    private String hic_no;
    private String social_no;

    private String dept_sn;
    private int admiss_times;
    private Date visit_date;
    private String dept_name;
    private String diagnosis;


    public List<PatientMzDetail> getPatientMzDetailList() {
        return patientMzDetailList;
    }

    public void setPatientMzDetailList(List<PatientMzDetail> patientMzDetailList) {
        this.patientMzDetailList = patientMzDetailList;
    }

    private List<PatientMzDetail>  patientMzDetailList;

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
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

    public String getHic_no() {
        return hic_no;
    }

    public void setHic_no(String hic_no) {
        this.hic_no = hic_no;
    }

    public String getSocial_no() {
        return social_no;
    }

    public void setSocial_no(String social_no) {
        this.social_no = social_no;
    }

    public String getDept_sn() {
        return dept_sn;
    }

    public void setDept_sn(String dept_sn) {
        this.dept_sn = dept_sn;
    }

    public int getAdmiss_times() {
        return admiss_times;
    }

    public void setAdmiss_times(int admiss_times) {
        this.admiss_times = admiss_times;
    }

    public Date getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(Date visit_date) {
        this.visit_date = visit_date;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
