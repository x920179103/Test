package com.yc.blog.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.yc.blog.mapper.ArticleMapper;
import com.yc.blog.pojo.Article;
import com.yc.blog.pojo.ArticleExample;

@Service
public class ArticleBiz {
	@Autowired
	private ArticleMapper am;

//	查询最新文章，page页数

	public List<Article> queryNewArticle(int page) {

		ArticleExample example = new ArticleExample();
		example.setOrderByClause("createTime desc");
		PageHelper.startPage(page, 5);
		return am.selectByExampleWithBLOBs(example);

	}

	public List<Article> queryByCategory(int id, int page) {
		// TODO Auto-generated method stub
		ArticleExample example = new ArticleExample();
		example.createCriteria().andCategoryidEqualTo(id);
		example.setOrderByClause("createTime desc");
		PageHelper.startPage(page, 5);
		return am.selectByExampleWithBLOBs(example);
	}

	@Transactional
	public Article read(int id) {
		ArticleExample example = new ArticleExample();
		example.createCriteria().andCategoryidEqualTo(id);
		Article a = am.selectByPrimaryKey(id);
		a.setReadcnt((a.getReadcnt() == null ? 0 : a.getReadcnt()) + 1);
		am.updateByPrimaryKey(a);
		return a;
	}



	public List<Article> queryRela(Integer categoryid) {
		ArticleExample example = new ArticleExample();
		example.setOrderByClause("createTime desc");
		example.createCriteria().andCategoryidEqualTo(categoryid);
		PageHelper.startPage(1, 10);
		return am.selectByExample(example);
	}

}
