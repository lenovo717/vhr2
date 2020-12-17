package com.zzyy.vhr.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VisitBase extends BaseModel{

    private Integer base_id;
    private String project_id;
    private String patient_id;
    private String patient_name;
    private String base_name;
    private Date base_time;
    private String address;
    private Date week_time;
    private Date month_time;
    private Date halfyear_time;


}