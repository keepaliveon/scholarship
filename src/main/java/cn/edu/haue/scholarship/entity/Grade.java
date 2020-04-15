package cn.edu.haue.scholarship.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 成绩
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Grade对象", description="成绩")
public class Grade implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "学号")
    private String studentId;

    @ApiModelProperty(value = "课程名")
    private String course;

    @ApiModelProperty(value = "分数")
    private Float score;

    @ApiModelProperty(value = "学年")
    private String year;

    @ApiModelProperty(value = "挂科标记")
    private Boolean fail;


}
