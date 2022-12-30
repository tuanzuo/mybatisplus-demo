package com.tz.mybatis.plus.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_student")
public class Student {
    @TableId
    private Long id;
    @TableField("nick_name")
    private String name;
    private Integer age;
    private String emailInfo;
}