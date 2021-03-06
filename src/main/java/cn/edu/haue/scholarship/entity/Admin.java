package cn.edu.haue.scholarship.entity;

import cn.edu.haue.scholarship.common.RoleName;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 学生资助中心管理员
 * </p>
 *
 * @author yangwei
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Admin对象", description="学生资助中心管理员")
public class Admin implements Serializable{

    private static final long serialVersionUID=1L;

    @TableId
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    public String getRole() {
        return RoleName.ROLE_ADMIN.name();
    }
}
