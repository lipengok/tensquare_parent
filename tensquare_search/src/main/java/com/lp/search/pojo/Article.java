package com.lp.search.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * indexName: 索引名称
 * type: 文档的类型
 * @Id: 索引库的id
 * index: 是否进行分词	analyzed:分词	 not_analyzed:不分词  no:不根据此字段进行检索
 * store: 是否存储
 * analyzer: 指定使用的分词器
 * type: 存储数据的类型
 * searchAnalyzer: queryStringQuery就是查询条件进行分词的分词器.
 * @Author lipeng
 * @Date 2022/11/24 15:40
 * @Version 1.0
 */
@Document(indexName="tensquare",type="article")
@Data
public class Article {

    @Id
    private String id;//ID

    @Field(index = true, type = FieldType.Text, analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String title;//标题

    @Field(index = true, type = FieldType.Text, analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String content;//文章正文

    @Field(type = FieldType.Text)
    private String state;//审核状态
}
