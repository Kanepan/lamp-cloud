package top.tangyh.lamp.tenant.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.Entity;
import top.tangyh.lamp.model.enumeration.system.TenantConnectTypeEnum;
import top.tangyh.lamp.model.enumeration.system.TenantStatusEnum;
import top.tangyh.lamp.model.enumeration.system.TenantTypeEnum;

import java.time.LocalDateTime;

import static top.tangyh.basic.utils.DateUtils.DEFAULT_DATE_TIME_FORMAT;
import static top.tangyh.lamp.model.constant.Condition.LIKE;

/**
 * <p>
 * 实体类
 * 企业
 * </p>
 *
 * @author zuihou
 * @since 2020-11-19
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("c_tenant")
@Schema(description = "企业")
@AllArgsConstructor
public class Tenant extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 企业编码
     */
    @Schema(description = "企业编码")
    @NotEmpty(message = "企业编码不能为空")
    @Size(max = 20, message = "企业编码长度不能超过20")
    @TableField(value = "code", condition = LIKE)
    @Excel(name = "企业编码", width = 20)
    private String code;

    /**
     * 企业名称
     */
    @Schema(description = "企业名称")
    @Size(max = 255, message = "企业名称长度不能超过255")
    @TableField(value = "name", condition = LIKE)
    @Excel(name = "企业名称", width = 20)
    private String name;

    /**
     * 类型
     * #{CREATE:创建;REGISTER:注册}
     */
    @Schema(description = "类型")
    @TableField("type")
    @Excel(name = "类型", width = 20, replace = {"创建_CREATE", "注册_REGISTER", "_null"})
    private TenantTypeEnum type;

    /**
     * 连接类型
     * #TenantConnectTypeEnum{LOCAL:本地;REMOTE:远程}
     */
    @Schema(description = "连接类型")
    @TableField("connect_type")
    @Excel(name = "连接类型", width = 20, replace = {"本地_LOCAL", "远程_REMOTE", "_null"})
    private TenantConnectTypeEnum connectType;

    /**
     * 状态
     * #{NORMAL:正常;WAIT_INIT:待初始化;FORBIDDEN:禁用;WAITING:待审核;REFUSE:拒绝;DELETE:已删除}
     */
    @Schema(description = "状态")
    @TableField("status")
    @Excel(name = "状态", width = 20, replace = {"正常_NORMAL", "待初始化_WAIT_INIT", "禁用_FORBIDDEN", "待审核_WAITING", "拒绝_REFUSE", "已删除_DELETE", "_null"})
    private TenantStatusEnum status;

    /**
     * 内置
     */
    @Schema(description = "内置")
    @TableField("readonly_")
    @Excel(name = "内置", replace = {"是_true", "否_false", "_null"})
    private Boolean readonly;

    /**
     * 责任人
     */
    @Schema(description = "责任人")
    @Size(max = 50, message = "责任人长度不能超过50")
    @TableField(value = "duty", condition = LIKE)
    @Excel(name = "责任人")
    private String duty;

    /**
     * 有效期
     * 为空表示永久
     */
    @Schema(description = "有效期")
    @TableField(value = "expiration_time", updateStrategy = FieldStrategy.IGNORED)
    @Excel(name = "有效期", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalDateTime expirationTime;

    /**
     * logo地址
     */
    @Schema(description = "logo地址")
    @Size(max = 255, message = "logo地址长度不能超过255")
    @TableField(value = "logo", condition = LIKE)
    private String logo;

    /**
     * 企业简介
     */
    @Schema(description = "企业简介")
    @Size(max = 255, message = "企业简介长度不能超过255")
    @TableField(value = "describe_", condition = LIKE)
    @Excel(name = "企业简介", width = 20)
    private String describe;


    @Builder
    public Tenant(Long id, LocalDateTime createTime, Long createdBy, LocalDateTime updateTime, Long updatedBy,
                  String code, String name, TenantTypeEnum type, TenantConnectTypeEnum connectType, TenantStatusEnum status,
                  Boolean readonly, String duty, LocalDateTime expirationTime, String logo, String describe) {
        this.id = id;
        this.createTime = createTime;
        this.createdBy = createdBy;
        this.updateTime = updateTime;
        this.updatedBy = updatedBy;
        this.code = code;
        this.name = name;
        this.type = type;
        this.connectType = connectType;
        this.status = status;
        this.readonly = readonly;
        this.duty = duty;
        this.expirationTime = expirationTime;
        this.logo = logo;
        this.describe = describe;
    }

}
