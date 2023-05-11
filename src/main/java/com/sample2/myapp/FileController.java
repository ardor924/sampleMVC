package com.sample2.myapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.sample2.model.FileDTO;
import com.sample2.service.BoardService;

@Controller
public class FileController {
	
	@Autowired BoardService service;

	FileInputStream in = null;  // 설명 : 다운로드시 FileInputStream과 ServletOutputStream를 사용하여 구현
	ServletOutputStream out = null; // HttpServletResponse 필요  -> 다운시 setContentType과 setContentLength ,setHeader 로 받기위함
	
	
	@RequestMapping("uploadTestPage.do")
	public String uploadTestPage() {
		return "upload/test";
	}
	
	// 이미지 테스트 페이지
	@RequestMapping("imgTestPage.do")
	public String imgTstPage() {
		return "upload/imgshowtest";
	}
	
	
	
	// 이미지 송출
	@GetMapping("imgShowTest")
	public void imgShowTest(HttpServletResponse response,Model model,FileDTO fDto,@RequestParam(defaultValue = "2") int fNo) {
		
		fNo = 11;
		
		System.out.println("---------------------------->"+fNo);
		
		fDto.setFno(fNo);
		
		
		fDto = service.getFileInfoFromDB(fDto);
		
		String fName =  fDto.getfName();
		String fPath = fDto.getfPath();
		

		try {
			File file = new File(fPath+fName); // 설명 : 파일의 경로 + 실제파일명 으로 새로운 파일객체를 생성한다.
			if(file.exists()) { // 파일이 폴더에 실제로 존재하는경우 실행
				in = new FileInputStream(file);  
				out = response.getOutputStream();
				
				response.setContentType("application/pdf"); // 설명 : PDF다운 받기 위한설정
				response.setContentLength((int) file.length()); 
				response.setHeader("Content-Disposition", "attachment;filename="+fPath+fName); // 필수. 없으면 바이너리로 표기된 페이지만 전환됨
				
				for(int i = in.read(); i != -1; i = in.read()) {
					out.write(i);
				}
				
			}else {
				System.out.println("File Not Found");
			}
			
		} catch (Exception e) {
			
			
		}finally {
			
			if(in != null) { // FileInputStream에 파일이 있을경우 닫아준다.
				try {
					in.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			if(out != null) { // ServletOutputStream에 파일이 있을경우 버퍼를 비워주고 닫아준다.
				
				try {
					out.flush();
					out.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			
			
			
		}
	};
	

	@PostMapping("uploadTest.do")
	public String uploadTest(FileDTO fDto,Model model,ArrayList<MultipartFile> imgFiles)throws IOException {
		
		System.out.println("--------------------------------나오는지확인-------------------------");
		
		String fRoot= "C:\\file_repo\\";  // 설명 : 업로드할 폴더명을 선언한다. 
		String fDate = service.getFolderDate(); // 설명 : simpleDateFormat 으로 String 형태로 변환한 날짜값을 가져온다.
		String uuid = UUID.randomUUID().toString();

		String fPath = fRoot+fDate+"\\"; // 설명 : (폴더루트 + 날짜 + "\\")를 합친 경로

		
		
		// 폴더 생성기
		File folderGenerator = new File(fRoot+fDate);
		if(!folderGenerator.exists()) {
			folderGenerator.mkdirs();
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
			
			String fName = file.getOriginalFilename();
			
			
			fDto.setfName(fName);
			fDto.setfPath(fPath);			
			service.insertFileInfoToDB(fDto);
		}


		
		return "upload/msg";
	}
	
	
	
	
	
	/*-------------------------------------------------실험용-------------------------------------------------*/
	@ResponseBody
	@PostMapping("/upload/image")
	public Map<String, Object> uploadImage(@RequestParam Map<String, Object> paramMap, MultipartRequest request) throws Exception
	{	
		
		String fRoot= "C:\\file_repo\\";  // 설명 : 업로드할 폴더명을 선언한다. 
		String fDate = service.getFolderDate(); // 설명 : simpleDateFormat 으로 String 형태로 변환한 날짜값을 가져온다.
		String uuid = UUID.randomUUID().toString();

		String fPath = fRoot+fDate+"\\"; // 설명 : (폴더루트 + 날짜 + "\\")를 합친 경로
		
		MultipartFile uploadFile = request.getFile("upload");
		String uploadDir = fRoot+fDate;
		String uploadId = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(uploadFile.getOriginalFilename());
		uploadFile.transferTo(new File(uploadDir + uploadId));
		paramMap.put("url", "/static/upload/images/" + uploadId);
		return paramMap;
		
	}
	
	
//	-----------------------------------CKeditor5업로드로직--------------------------------------------------------------------
	
	@ResponseBody
	@PostMapping("uploadImage.do")
	public ResponseEntity<Object> uploadImage(@RequestParam("upload") MultipartFile image) {
	    try {
	        // 이미지 업로드 로직 수행
	        String fRoot = "C:\\uploadIMGfolder\\";
	        String fDate = service.getFolderDate();
	        String uuid = UUID.randomUUID().toString();
	        String fPath = fRoot + fDate + "\\";

	        File folderGenerator = new File(fRoot + fDate);
	        if (!folderGenerator.exists()) {
	            folderGenerator.mkdirs();
	            System.out.println("진입성공1!");
	        } else {
	            System.out.println("The folder already exists!");
	        }

	        File saveFile = new File(fPath, image.getOriginalFilename());
	        image.transferTo(saveFile);
	        System.out.println("진입성공2!");

	        String fName = image.getOriginalFilename();

	        FileDTO fDto = new FileDTO();
	        fDto.setfName(fName);
	        fDto.setfPath(fPath);
	        service.insertFileInfoToDB(fDto);

	        // 이미지 업로드 성공 응답 데이터 생성
	        String responseMessage = "이미지가 업로드되었습니다.";

	        String imageUrl = "http://localhost:8080/myapp/images/" + fDate + "/" + image.getOriginalFilename();

	        Map<String, Object> response = new HashMap<>();
	        response.put("message", responseMessage);
	        response.put("url", imageUrl); // 업로드된 파일 경로를 응답에 포함할 수 있습니다.

	        System.out.println("진입성공3!");

	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        // 업로드 실패 시 예외 처리
	        String errorMessage = "이미지 업로드 중 오류가 발생했습니다.";
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	    }
	}

		/**/
	
	
	@GetMapping("/images/{date}/{filename:.+}")
	public ResponseEntity<Resource> getImage(@PathVariable("date") String date,
	                                         @PathVariable("filename") String filename) {
	    try {
	        // 이미지 파일을 읽어옴
	        String fRoot = "C:\\uploadIMGfolder\\";
	        String fPath = fRoot + date + "\\" + filename;

	        Path imagePath = Paths.get(fPath);
	        Resource resource = new UrlResource(imagePath.toUri());

	        if (resource.exists()) {
	            // 이미지 파일을 응답에 포함하여 반환
	            return ResponseEntity.ok()
	                    .contentType(MediaType.IMAGE_JPEG)
	                    .body(resource);
	        } else {
	            // 이미지 파일이 존재하지 않을 경우 404 응답 반환
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        // 이미지 파일 로드 실패 시 예외 처리
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	

	
}
