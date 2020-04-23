package cn.edu.haue.scholarship.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 成绩平均分
 * </p>
 *
 * @author yangwei
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Grade对象", description="成绩平均分")
public class Grade implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    @ApiModelProperty(value = "学号")
    private String studentId;

    @TableId
    @ApiModelProperty(value = "学年")
    private String year;

    @ApiModelProperty(value = "考试分")
    private Float score;

    @ApiModelProperty(value = "素质分")
    private Float quality;

    @ApiModelProperty(value = "挂科标记")
    private Boolean fail;

    @TableField(exist = false)
    private String name;

    @TableField(exist = false)
    private String clazz;

    @TableField(exist = false)
    private String speciality;

    @TableField(exist = false)
    private Float mark;

}
