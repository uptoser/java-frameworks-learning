package com.uptoser.ssm.ssm.web;

import com.uptoser.ssm.ssm.vo.Book;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class TestController {

	//----------------------
	@RequestMapping(value = "validator", method = RequestMethod.POST)
	public Map<String,Object> validator(@RequestBody @Valid Book book, Errors errors) {
		System.out.println(book);
		Map<String,Object> map = new HashMap<String,Object>();
		if(errors.hasErrors()){
			map.put("msg", errors.getFieldError().getDefaultMessage());
			return map;
		}
		map.put("msg", 111);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "test", method = RequestMethod.POST)
	public Map<String,Object> test1(String name,String name1) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		System.out.println(name);
		return map;
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public Map<String,Object> test2(String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", "哦哦");
		map.put("name", name);
		System.out.println(name);
		return map;
	}

}
