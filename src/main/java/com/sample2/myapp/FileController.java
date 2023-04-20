package com.sample2.myapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ProcessHandle.Info;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sample2.service.BoardService;

@Controller
public class FileController {
	
	@Autowired BoardService service;

	@RequestMapping("uploadTestPage.do")
	public String uploadTestPage() {
		return "upload/test";
	}
	
	@ResponseBody
	@GetMapping("/image/{fName}")
	public Resource showImage(@PathVariable String fName) throws MalformedURLException {
		
		System.out.println("fName : "+fName);
		
		
	 	return new UrlResource(fName);
	 }
	
	
	@PostMapping("uploadTest.do")
	public String uploadTest(Model model,ArrayList<MultipartFile> imgFiles)throws IOException {
		
		
		
		String fRoot= "C:\\file_repo\\";  // 설명 : 업로드할 폴더명을 선언한다. 
		String fDate = service.getFolderDate(); // 설명 : simpleDateFormat 으로 String 형태로 변환한 날짜값을 가져온다.
		String uuid = UUID.randomUUID().toString();

		String fPath = fRoot+fDate+"\\"; // 설명 : (폴더루트 + 날짜 + "\\")를 합친 경로

		
		
		// 폴더 생성기
		File folderGenerator = new File(fRoot+fDate);
		if(!folderGenerator.exists()) {
			folderGenerator.mkdir();
		}else {
			System.out.println("The folder is already exist!");
		}
		
		
		for(MultipartFile file : imgFiles) {
			
			try {
				
				File saveFile = new File(fPath, file.getOriginalFilename());
				
				file.transferTo(saveFile);
				
			} catch (IOException e) {
				System.out.println("파일등록 에러발생");
			}
			
			
			
		}

		

		
		return "upload/msg";
	}
	
	
	
	
	
	
	
	
	
}
