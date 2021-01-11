package com.lgs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "info")
@Data
@AllArgsConstructor //有参构造
@NoArgsConstructor //无参构造
public class Info {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String uname;
    private String sex;
    private String clazz;
    private Integer score;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
