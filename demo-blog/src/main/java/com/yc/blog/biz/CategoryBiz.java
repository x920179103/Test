package com.yc.blog.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.blog.mapper.CategoryMapper;
import com.yc.blog.pojo.Category;

@Service
public class CategoryBiz {
	@Resource
	private CategoryMapper cm;
	
	public List<Category>queryAll(){
		return cm.selectByExample(null);
		
		
		
	}

}
