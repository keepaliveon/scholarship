package cn.edu.haue.scholarship.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 辅导员
 * </p>
 *
 * @author yangwei
 * @since 2020-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Counsellor对象", description="辅导员")
public class Counsellor implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "工号")
    private String staffId;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年级")
    private String year;

    @ApiModelProperty(value = "学院")
    private String department;


}
