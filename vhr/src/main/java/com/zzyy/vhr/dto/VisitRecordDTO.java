package com.zzyy.vhr.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class VisitRecordDTO {
    private String record_id;
    private Integer base_id;
    private String project_id;
    private String patient_id;
    private String patient_name;
    /*访视类型*/
    private String record_type;
    /*访视时间*/
    private Date vist_time;
    /*随访形式*/
    private String sfxs;
    /*临床结果*/
    private Object lcjg;
    /*患者症状*/
    private Object hzzz;
    /*生活方式*/
    private Object shfs;
    /*日常监测*/
    private Object rcjc;
    /*体征与体格检查*/
    private Object tzytg;
    /*检测结果*/
    private Object jcjg;
    private Object xdt;
    /*治疗药物A-心血管药物*/
    private Object zlyw_a;
    /*治疗药物b-其它药物*/
    private Object zlyw_b;

    private String remark;
}
