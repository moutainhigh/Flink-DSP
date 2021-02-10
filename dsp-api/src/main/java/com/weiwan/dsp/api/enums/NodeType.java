package com.weiwan.dsp.api.enums;

/**
 * @author: xiaozhennan
 * @email: xiaozhennan1995@gmail.com
 * @date: 2021/2/10 14:25
 * @description:
 */
public enum NodeType {
    READER, //reader插件
    WRITER,  //writer插件
    PROCESS,  //process插件
    UNION, //合并节点
    SPLIT //拆分节点
}
