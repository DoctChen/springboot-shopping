package com.chenxin.shop.modules.pms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 相册表
 * </p>
 *
 * @author Star_Chen
 * @since 2022-05-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_album")
@ApiModel(value="PmsAlbum对象", description="相册表")
public class PmsAlbum implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String coverPic;

    private Integer picCount;

    private Integer sort;

    private String description;


}
