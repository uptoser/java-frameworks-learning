package com.uptoser.ssm.ssm.web;

import com.uptoser.ssm.ssm.exception.Test1Exception;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/t2")
public class TestController2 {

	@RequestMapping(value = "test", method = RequestMethod.POST)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name1", value = "名字1", paramType = "body", dataType = "String", required = false), })
	public Map<String, Object> test1(String name1) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "哦哦");
		map.put("name", name1);
		System.out.println(name1);
		return map;
	}

	@RequestMapping(value = "testException", method = RequestMethod.POST)
	public String test111(@ModelAttribute("msg") String a) {
		System.out.println(a);//
		throw new Test1Exception();
	}

}
