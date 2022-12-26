package top.tangyh.lamp.tenant.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.SuperEntity;
import top.tangyh.lamp.model.enumeration.system.TenantConnectTypeEnum;
import top.tangyh.lamp.model.enumeration.system.TenantStatusEnum;
import top.tangyh.lamp.model.enumeration.system.TenantTypeEnum;
import top.tangyh.lamp.model.vo.save.AppendixSaveVO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@Schema(description = "企业")
public class TenantUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @NotNull(message = "id不能为空", groups = SuperEntity.Update.class)
    private Long id;

    /**
     * 企业编码
     */
    @Schema(description = "企业编码")
    @NotEmpty(message = "企业编码不能为空")
    @Size(max = 20, message = "企业编码长度不能超过20")
    private String code;
    /**
     * 企业名称
     */
    @Schema(description = "企业名称")
    @Size(max = 255, message = "企业名称长度不能超过255")
    private String name;
    /**
     * 类型
     * #{CREATE:创建;REGISTER:注册}
     */
    @Schema(description = "类型")
    private TenantTypeEnum type;
    /**
     * 连接类型
     * #TenantConnectTypeEnum{LOCAL:本地;REMOTE:远程}
     */
    @Schema(description = "连接类型")
    private TenantConnectTypeEnum connectType;
    /**
     * 状态
     * #{NORMAL:正常;WAIT_INIT:待初始化;FORBIDDEN:禁用;WAITING:待审核;REFUSE:拒绝;DELETE:已删除}
     */
    @Schema(description = "状态")
    private TenantStatusEnum status;
    /**
     * 内置
     */
    @Schema(description = "内置")
    private Boolean readonly;
    /**
     * 责任人
     */
    @Schema(description = "责任人")
    @Size(max = 50, message = "责任人长度不能超过50")
    private String duty;
    /**
     * 有效期
     * 为空表示永久
     */
    @Schema(description = "有效期")
    private LocalDateTime expirationTime;
    @Schema(description = "logo地址")
    @Size(max = 1, message = "只能上传1个logo")
    private List<AppendixSaveVO> logos;

    /**
     * 企业简介
     */
    @Schema(description = "企业简介")
    @Size(max = 255, message = "企业简介长度不能超过255")
    private String describe;
}
