package com.yc.blog.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.blog.biz.ArticleBiz;
import com.yc.blog.biz.CategoryBiz;
import com.yc.blog.pojo.Category;

@Controller
public class ArticleAction {
	@Resource
	private ArticleBiz abiz;
	@Resource
	private CategoryBiz cbiz;
	
	@ModelAttribute("cList")
	public List<Category>init(){
		
		return cbiz.queryAll();
	}

	@GetMapping("index")
	public String index(@RequestParam(defaultValue = "1") int page, Model model) {
		// 最新文章
		model.addAttribute("aList", abiz.queryNewArticle(page));
		return "index";
	}

	@GetMapping("category")
	public String category(@RequestParam(defaultValue = "1") int page,int id,  Model model) {

		model.addAttribute("aList", abiz.queryByCategory(id, page));
		return "category";

	}
}
