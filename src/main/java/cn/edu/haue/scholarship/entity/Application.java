package cn.edu.haue.scholarship.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 申请
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Application对象", description="申请")
public class Application implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "学号")
    private String studentId;

    @ApiModelProperty(value = "奖学金id")
    private Integer scholarshipId;

    @ApiModelProperty(value = "奖学金等级")
    private String level;

    @ApiModelProperty(value = "申请状态")
    private Boolean state;

    @ApiModelProperty(value = "申请时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "姓名")
    @TableField(exist = false)
    private String name;

    @ApiModelProperty(value = "班级")
    @TableField(exist = false)
    private String clazz;

    @ApiModelProperty(value = "专业")
    @TableField(exist = false)
    private String spec;

    @ApiModelProperty(value = "学年")
    @TableField(exist = false)
    private String year;

    @ApiModelProperty(value = "奖学金")
    @TableField(exist = false)
    private String scholarship;

}
