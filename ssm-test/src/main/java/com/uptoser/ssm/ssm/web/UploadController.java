package com.uptoser.ssm.ssm.web;

import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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
