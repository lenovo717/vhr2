package com.zzyy.vhr.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class VisitRecord extends BaseModel{
    private String record_id;
    private Integer base_id;
    private String project_id;
    private String patient_id;
    private String patient_name;
    private String record_type;
    /*访视时间*/
    private Date vist_time;
    /*随访形式*/
    private String sfxs;
    /*临床结果*/
    private String lcjg;
    /*患者症状*/
    private String hzzz;
    /*生活方式*/
    private String shfs;
    /*日常监测*/
    private String rcjc;
    /*体征与体格检查*/
    private String tzytg;
    /*检测结果*/
    private String jcjg;
    private String xdt;
    /*治疗药物A-心血管药物*/
    private String zlyw_a;
    /*治疗药物b-其它药物*/
    private String zlyw_b;
    private Integer status;


}
