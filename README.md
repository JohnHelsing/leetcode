## LeetCode刷题记录

>配合IDEA插件 leetcode editor食用

### 插件模板配置：
勾上[Custom Template]选项  
0. tempFilePath: 
```
LeetCode\src\main\java\com\helsing
```
1. codeFileName：
```
Q$!velocityTool.leftPadZeros(${question.frontendQuestionId},4)_$!velocityTool.camelCaseName(${question.titleSlug})
```
2. codeTemplate:
```
${question.content}
package com.helsing.leetcode.editor.cn;

public class Q$!velocityTool.leftPadZeros(${question.frontendQuestionId},4)_$!velocityTool.camelCaseName(${question.titleSlug}){
    
    public static void main(String[]args){
        Solution solution = new Solution();
    }
    
    static
    ${question.code}
}
```


