package com.derveljuns.fileupload;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@GetMapping(value="/view/{PageName}")
	public String PageMapper(@PathVariable("PageName") String pageName) {
		return "/" + pageName;
	}
	
	@PostMapping(value="/upload")
	@ResponseBody
	public void upload(@RequestPart MultipartFile files){ 
		try {
			String baseDir = "C:\\ServerFiles";
			files.transferTo(new File(baseDir + "\\"+ files.getOriginalFilename()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
