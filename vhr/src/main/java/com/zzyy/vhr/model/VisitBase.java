package com.zzyy.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VisitBase extends BaseModel{

    private Integer base_id;
    private Integer proj_pati_id;
    private String project_id;
    private String file_id;
    private String patient_name;
    private String base_name;
    private Date base_time;
    private String address;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date week_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date month_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date halfyear_time;
    private String belongs;

}
