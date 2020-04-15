package cn.edu.haue.scholarship.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 名额分配
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Distribution对象", description="名额分配")
public class Distribution implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "单位id")
    private Integer unitId;

    @ApiModelProperty(value = "奖学金id")
    private Integer scholarshipId;

    @ApiModelProperty(value = "分配名额")
    private Integer num;


}
