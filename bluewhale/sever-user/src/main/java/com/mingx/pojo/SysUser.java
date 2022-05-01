package com.mingx.pojo;


import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
public class SysUser implements Serializable {

//    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String sex;

    private String birthday;

    private String createTime;

    private String createBy;

    private String updateTime;

    private String updateBy;

    private Integer delFlag;


}
