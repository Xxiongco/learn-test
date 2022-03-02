package com.panda.learn_spring_boot.domain;
import com.panda.learn_spring_boot.config.DateValidator;
import com.panda.learn_spring_boot.config.Xiong;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
/**
 * @date 2018/4/12 11:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;
    @NotBlank
    private String userName;
    @NotBlank(groups = Xiong.class)
    private String passWord;
    private Date createTime;
    private String alias;
    private Integer level;
    private Integer vip;
    private String birthday;

}