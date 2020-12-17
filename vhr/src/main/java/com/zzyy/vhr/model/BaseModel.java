package com.zzyy.vhr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {

//    private Integer id;

    private String creator;
    @JsonIgnore
    private Date create_time;

    private String remark;

    @JsonIgnore
    private Date update_time;

    @JsonIgnore
    private Date delete_time;
}
