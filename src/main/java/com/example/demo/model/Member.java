package com.example.demo.model;
/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 */

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Erupt(name = "成员管理")
@Table(name = "t_member")
@Entity
public class Member extends BaseModel {

    @EruptField(
            views = @View(title = "姓名"),
            edit = @Edit(title = "姓名")
    )
    private String name;

    @EruptField(
            views = @View(title = "性别"),
            edit = @Edit(title = "性别",
                    boolType = @BoolType(trueText = "男", falseText = "女"))
    )
    private Boolean sex;

    @EruptField(
            views = @View(title = "出生日期"),
            edit = @Edit(title = "出生日期",
                    dateType = @DateType(pickerMode = DateType.PickerMode.HISTORY) //选择历史时间
            ))
    private Date birthday;

//    @EruptField(
//            views = @View(
//                    title = "年龄", sortable = true
//            ),
//            edit = @Edit(
//                    title = "年龄",
//                    type = EditType.NUMBER, search = @Search, notNull = true,
//                    numberType = @NumberType
//            )
//    )
//    private Integer age;

//    @EruptField(
//            views = @View(
//                    title = "地图"
//            ),
//            edit = @Edit(
//                    title = "地图",
//                    type = EditType.MAP, search = @Search, notNull = true
//            )
//    )
//    private String map;


}