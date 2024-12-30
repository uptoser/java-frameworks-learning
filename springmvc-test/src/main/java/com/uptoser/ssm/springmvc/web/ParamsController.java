package com.uptoser.ssm.springmvc.web;

import java.util.List;

import com.uptoser.ssm.springmvc.pojo.Role;
import com.uptoser.ssm.springmvc.pojo.RoleParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping("/params")
public class ParamsController {
	/**
	 * 无注解获取HTTP请求参数
	 */
	@GetMapping("/commonParams")
	public ModelAndView commonParams(String roleName, String note) {
	    System.out.println("roleName =>" + roleName);
	    System.out.println("note =>" + note);
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("index");
	    return mv;
	}
	/**
	 * 角色参数类
	 */
	@GetMapping("/commonParamPojo")
	public ModelAndView commonParamPojo(RoleParams roleParams) {
	    System.out.println("roleName =>" + roleParams.getRoleName());
	    System.out.println("note =>" + roleParams.getNote());
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("index");
	    return mv;
	}
	/**
	 * RequestParam注解获取参数
	 */
	@RequestMapping("/requestParam")
	//使用@RequestParam("role_name")指定映射HTTP参数名称
	public ModelAndView requestParam(@RequestParam("role_name") String roleName, String note) {
		System.out.println("roleName =>" + roleName);
	    System.out.println("note =>" + note);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("index");
	    return mv;
	}
	/**
	 * 通过URL传递参数获取角色信息
	 */
	@RequestMapping("/getRole/{id}")
	//注解@PathVariable表示从URL的请求地址中获取参数
	public ModelAndView pathVariable(@PathVariable("id") Long id)  {
		ModelAndView mv = new ModelAndView();
		System.out.println("id =>" + id);
		//绑定数据模型
		//设置为JSON视图
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	/**
	 * 传递JSON参数
	 */
	@RequestMapping("/findRoles")
	public ModelAndView findRoles(@RequestBody RoleParams roleParams) {
		ModelAndView mv = new ModelAndView();
		System.out.println("roleParams =>" + roleParams.getRoleName());
		//绑定模型
		//设置为JSON视图
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	/**
	 * 通过 JSON 的字符串化将参数传递到后台
	 */
	@RequestMapping("/deleteRoles")
	public ModelAndView deleteRoles(@RequestBody List<Long> idList) {
		idList.forEach(System.out::println);
		ModelAndView mv = new ModelAndView();
		mv.addObject("total", 111);
	    mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	/**
	 * 获取角色列表参数
	 */
	@RequestMapping("/addRoles")
	public ModelAndView addRoles(@RequestBody List<Role> roleList) {
		roleList.forEach(System.out::println);
		ModelAndView mv = new ModelAndView();
		//绑定视图
		mv.addObject("total", 111);
		//JSON视图
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	/**
	 * 接收序列化表单
	 * 由于序列化参数的传递规则变为了roleName=xxx&&note=xxx，所以获取参数也是十分容易的
	 */
	@RequestMapping("/commonParamPojo2")
	public ModelAndView commonParamPojo2(String roleName, String note) {
		System.out.println("roleName =>" + roleName);
		System.out.println("note =>" + note);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
}
