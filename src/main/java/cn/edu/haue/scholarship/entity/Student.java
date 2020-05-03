package cn.edu.haue.scholarship.entity;

import java.io.Serializable;

import cn.edu.haue.scholarship.common.RoleName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学生
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Student对象", description = "学生")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学号")
    @TableId
    private String studentId;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "所属单位ID")
    private Integer unitId;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "班级")
    @TableField(exist = false)
    private String clazz;

    @ApiModelProperty(value = "专业")
    @TableField(exist = false)
    private String speciality;

    @ApiModelProperty(value = "身份证")
    @TableField(exist = false)
    private String idNumber;

    public String getRole() {
        return RoleName.ROLE_STUDENT.name();
    }
}
