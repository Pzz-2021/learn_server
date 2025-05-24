package com.ape.apesystem.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.ape.apecommon.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author pengzheng
 * @version 1.0
 * @description: 用户考试题目
 * @date 2023/11/24 10:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("ape_test_student")
@ColumnWidth(20)
public class ApeTestStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelIgnore
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ExcelIgnore
    private String itemId;

    /**
     * 考试id
     */
    @ExcelIgnore
    private String testId;

    /**
     * 题目
     */
    @ExcelIgnore
    private String title;

    /**
     * 序号
     */
    @ExcelIgnore
    private Integer sort;

    /**
     * 类型 0：单选 1：多选 2：填空 3：判断 4：问答题 5：计算题
     */
    @ExcelIgnore
    private Integer type;

    /**
     * 分数
     */
    @ExcelIgnore
    private Integer score;

    /**
     * 得分点
     */
    @ExcelIgnore
    private String keyword;

    /**
     * 答案
     */
    @ExcelIgnore
    private String answer;

    /**
     * 题目内容
     */
    @ExcelIgnore
    private String content;

    /**
     * 得分
     */
    @ExcelIgnore
    private Integer point;

    /**
     * 答案
     */
    @ExcelIgnore
    private String solution;

    /**
     * 用户id
     */
    @ExcelIgnore
    private String userId;

    /**
     * 备注
     */
    @ExcelIgnore
    private String remark;

    /**
     * 创建者
     */
    @ExcelProperty(value = "学生姓名",index=0)
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ExcelIgnore
    private Date createTime;

    /**
     * 更新者
     */
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    @ExcelIgnore
    private String updateBy;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @ExcelIgnore
    private Date updateTime;

    @TableField(exist = false)
    @ExcelProperty(value = "总分",index=2)
    private Integer totalScore;

    @TableField(exist = false)
    @ExcelProperty(value = "得分",index=3)
    private Integer totalGetScore;

    @TableField(exist = false)
    @ExcelProperty(value = "考试名称",index=1)
    private String testName;

    @TableField(exist = false)
    @ExcelIgnore
    private Integer pageNumber;

    @TableField(exist = false)
    @ExcelIgnore
    private Integer pageSize;
}