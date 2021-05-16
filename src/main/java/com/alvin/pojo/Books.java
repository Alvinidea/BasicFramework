package com.alvin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
/*
*  要与db的设定一致
*
*  lombok
* */
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
