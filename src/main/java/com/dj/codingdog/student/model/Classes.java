package com.dj.codingdog.student.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dj
 * @since 2024-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("classes")
public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer courseId;

    private Integer teacherId;

    private String semester;

    private Integer year;


}
