package com.yc.blog.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.blog.biz.BizException;
import com.yc.blog.biz.UserBiz;
import com.yc.blog.mapper.UserMapper;
import com.yc.blog.pojo.User;
import com.yc.blog.pojo.UserExample;
import com.yc.blog.vo.Result;

@RestController
@SessionAttributes("loginUser")
public class UserAction {

	@Resource
	private UserBiz ub;

	@PostMapping("login")
	public Result login(String name, String password, Model model) {

		try {
			User user = ub.login(name, password);
			return new Result(1, "OK", user);
		} catch (BizException e) {

			return new Result(0, e.getMessage());
		} catch (RuntimeException e) {

			e.printStackTrace();
			System.out.println("cuowu ");
			return new Result(0, "业务繁忙");
			
		}
	}

}
