//
// 
// 表： Weather 
//
// 
//+---------------+---------+
//| Column Name   | Type    |
//+---------------+---------+
//| id            | int     |
//| recordDate    | date    |
//| temperature   | int     |
//+---------------+---------+
//id 是这个表的主键
//该表包含特定日期的温度信息 
//
// 
//
// 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。 
//
// 返回结果 不要求顺序 。 
//
// 查询结果格式如下例。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//Weather 表：
//+----+------------+-------------+
//| id | recordDate | Temperature |
//+----+------------+-------------+
//| 1  | 2015-01-01 | 10          |
//| 2  | 2015-01-02 | 25          |
//| 3  | 2015-01-03 | 20          |
//| 4  | 2015-01-04 | 30          |
//+----+------------+-------------+
//输出：
//+----+
//| id |
//+----+
//| 2  |
//| 4  |
//+----+
//解释：
//2015-01-02 的温度比前一天高（10 -> 25）
//2015-01-04 的温度比前一天高（20 -> 30） 
// 
// 
// Related Topics 数据库 👍 274 👎 0

package com.helsing.leetcode.editor.cn;

public class Q0197_RisingTemperature {

    public static void main(String[] args) {
    }

    //There is no code of Java type for this problem
    // select w1.id as id from Weather w1 left join Weather w2 on datediff(w1.recordDate, w2.recordDate) = 1
    // where w1.temperature > w2.temperature
}
