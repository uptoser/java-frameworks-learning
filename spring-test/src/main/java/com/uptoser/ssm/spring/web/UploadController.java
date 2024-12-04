package com.uptoser.ssm.spring.web;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/upload")
public class UploadController {

	// 上传图片
	@ResponseBody
	@ApiOperation(value = "上传图片", notes = "by barry")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadPic(@RequestParam(required = true, value = "file") MultipartFile file)
			throws IOException {
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		FileUtils.writeByteArrayToFile(new File("C:/Users/Share/"+file.getOriginalFilename()), file.getBytes());
		return "";
	}

}
