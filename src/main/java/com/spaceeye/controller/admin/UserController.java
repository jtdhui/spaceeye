package com.spaceeye.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spaceeye.dto.User;
import com.spaceeye.service.IUserService;

/**
 * Created by chenhui on 2018/1/23.
 */
@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping("/login.do")
	public String login(User user,Model model,HttpServletRequest request){		
		User sysuser=userService.findUser(user);
		if(sysuser==null){
			 model.addAttribute("message","用户名或密码错误");
			 return "login";
		}else{
			request.getSession().setAttribute("sysuser", sysuser);
			return "redirect:/index.do";
		}		
	}
	
	@RequestMapping("/index.do")
	public String index(){		
		return "index";		
	}
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request){
		request.getSession().invalidate();
		 return "login";		
	}
}
