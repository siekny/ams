package com.siekny.articleresful.repository.provider;


import com.siekny.articleresful.model.Paging;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {
    public String findAll(Integer id) {
        return new SQL(){{
            SELECT("*");
            FROM("tb_article AS art");
            INNER_JOIN("tb_category AS cate ON a.category_id = c.id");

            WHERE("art.status = true");
            if(id != null) {
                AND().WHERE("art.id = " + id);
            }

            ORDER_BY("art.id");
        }}.toString();
    }

    public String selectArticles() {
        return new SQL() {{
             SELECT("a.article_id, a.title, a.description, a.created_date, c.category_id, c.category_name, c.color, c.created_date, u.user_id, u.user_name, u.created_date");
             FROM("tb_article AS a");
             INNER_JOIN("tb_category AS c ON a.category_id = c.category_id");
             INNER_JOIN("tb_user AS u ON a.user_id = u.user_id");
             ORDER_BY("a.article_id");
        }}.toString();
    }

    public String selectArticlesByPaging(@Param("userId") Integer userId,
                                         @Param("categoryId") Integer categoryId,
                                         @Param("paging") Paging paging,
                                         @Param("patternSearch") String patternSearch) {
        return new SQL(){{
            SELECT("*");
            FROM("tb_article AS a");
            if (categoryId != null) {
                INNER_JOIN("tb_category AS c ON a.category_id = c.category_id");
                WHERE("a.category_id = " + categoryId);
            } else {
                LEFT_OUTER_JOIN("tb_category AS c ON a.category_id = c.category_id");
            }

            if (userId != null) {
                INNER_JOIN("tb_user AS u ON a.user_id = u.user_id");
                WHERE("a.user_id = " + userId);
            } else {
                LEFT_OUTER_JOIN("tb_user AS u ON a.user_id = u.user_id");
            }

            if (patternSearch != null) {
                AND().WHERE("a.title LIKE '%" + patternSearch + "%'");
                OR().WHERE("a.description LIKE '%" + patternSearch + "%'");
            }
            ORDER_BY("a.article_id LIMIT " + paging.getLimit() + " OFFSET " + paging.getOffset());

        }}.toString();
    }

    public String getOneArticle(int id) {
        return new SQL(){{
            SELECT("*");
            FROM("tb_article AS a ");
                LEFT_OUTER_JOIN("tb_category AS c ON a.category_id = c.category_id ");
                LEFT_OUTER_JOIN("tb_user AS u ON a.user_id = u.user_id");
            WHERE("a.article_id=" + id);
        }}.toString();
    }

}
