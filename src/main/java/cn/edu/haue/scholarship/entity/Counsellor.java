package cn.edu.haue.scholarship.entity;

import cn.edu.haue.scholarship.common.RoleName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 辅导员
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Counsellor对象", description="辅导员")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Counsellor implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    @ApiModelProperty(value = "工号")
    private String staffId;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "所属单位")
    private Integer unitId;

    @TableField(exist = false)
    private String year;

    @TableField(exist = false)
    private String collage;

    public String getRole() {
        return RoleName.ROLE_COUNSELLOR.name();
    }

}
