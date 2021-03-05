package com.dodo1920.springProj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dodo1920.util.MediaConfirm;
import com.dodo1920.util.uploadFileProcess;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static String uploadPath = "E:\\lecture\\10_SpringUpload";
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@RequestMapping(value="/test")
	public String ajaxTest() {
		return "testJson";
	}
	
	@RequestMapping(value="/uploadForm", method=RequestMethod.GET)
	public void uploadForm() {
		
	}
	
	@RequestMapping(value="/uploadForm", method=RequestMethod.POST)
	public String uploadForm(HttpServletRequest request, MultipartFile uploadFile, Model model) throws IOException {
		System.out.println("업로드 파일 이름 : " + uploadFile.getOriginalFilename());
		System.out.println("업로드 파일 사이즈 : " + uploadFile.getSize());
		System.out.println("업로드 파일 : " + Arrays.toString(uploadFile.getBytes()));
		System.out.println("업로드 파일의 타입 : " + uploadFile.getContentType()); // 파일의 MIME type (못 바꾸기 때문에 이미지인지 판별할때 사용)
		
		String saveFileName = uploadFile(request, uploadFile.getOriginalFilename(), uploadFile.getBytes());
		
		System.out.println(request.getRealPath("resources/uploads"));
		
		model.addAttribute("saveFileName", saveFileName);
		
		// 서비스단 호출
		return "uploadResult";
	}
	
	@RequestMapping(value="/uploadAjax", method=RequestMethod.GET)
	public void uploadAjax() {
		
	}
	
	@RequestMapping(value="/uploadAjax", method=RequestMethod.POST, produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file, HttpServletRequest request) {
		System.out.println("업로드 파일 이름 : " + file.getOriginalFilename());
		System.out.println("업로드 파일 사이즈 : " + file.getSize());
		System.out.println("업로드 파일의 타입 : " + file.getContentType()); // 파일의 MIME type (못 바꾸기 때문에 이미지인지 판별할때 사용)
		System.out.println("파일 separator : " + File.separator);
		
		try {
			String path = request.getSession().getServletContext().getRealPath("resources/uploads");
			//String uploadFileName = uploadFile(request, file.getOriginalFilename(), file.getBytes());
			String uploadFile = uploadFileProcess.uploadFile(path, file.getOriginalFilename(), file.getBytes());
			return new ResponseEntity<String>(uploadFile, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
//	@RequestMapping(value="/displayFile")
//	public ResponseEntity<byte[]> displayFile(String fileName) {
//		InputStream in = null;
//		
//		ResponseEntity<byte[]> entity = null;
//		
//		String ext = fileName.substring(fileName.lastIndexOf(".") + 1); 
//		
//		MediaType mType = MediaConfirm.getMediaType(ext);
//		
//		HttpHeaders header = new HttpHeaders();
//		if(mType != null) {
//			header.setContentType(mType);
//		} else { // 이미지 파일이 아니면,
//			fileName.substring(fileName.indexOf("_") + 1); // UUID_ 다음 originalFileName을 얻어옴
//		}
//	}
	
	@ResponseBody // byte[]의 데이터(파일 데이터)가 web에 그대로 전송 되도록
	@RequestMapping("/displayFile")
	   public ResponseEntity<byte[]> displayFile(HttpServletRequest request, String fileName) throws IOException {
	      InputStream in = null;
	      ResponseEntity<byte[]> entity = null;
	      
	      try {
	         String ext = fileName.substring(fileName.lastIndexOf(".") + 1); // 확장자 추출
	         
	         MediaType mType = MediaConfirm.getMediaType(ext); // 이미지 파일인지 아닌지를 검사하기 위해
	         
	         HttpHeaders header = new HttpHeaders();
	         
	         
	         
	         String path = request.getSession().getServletContext().getRealPath("resources/uploads");
//	         String uploadPath = path + "/2021/03/05";
	         fileName = fileName.replace('/', File.separatorChar);
	         logger.info(path + fileName);
	         
	         in = new FileInputStream(path + fileName);
	         
	         if (mType != null) {
	            header.setContentType(mType); 
	         } else {
	            fileName = fileName.substring(fileName.indexOf("_") + 1); // UUID_ 다음 originalFileName을 얻어옴
	            header.setContentType(MediaType.APPLICATION_OCTET_STREAM); // 다운로드 가능한 파일임
	            header.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\""); // 다운로드 될 수 있도록 일종의 링크 제공
	         }
	      
	      
	         entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), header, HttpStatus.CREATED); // 파일을 읽은 뒤 데이터를 그대로 전송
	      } catch (IOException e) {
	         e.printStackTrace();
	         entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	      } finally {
	         in.close();
	      }
	      
	      return entity;
	   }

	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(HttpServletRequest request, String fileName) {
		logger.info("삭제할 파일 : " + fileName);
		
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		String path = request.getSession().getServletContext().getRealPath("resources/uploads");
		
		MediaType mType = MediaConfirm.getMediaType(ext);
		
		String tmp = fileName.replace("thumb_", "");
		String originalFile = path + tmp; // 삭제해야 할 오리지널 이미지 파일
		String thumbFile = path + fileName; // 삭제해야 할 썸네일 이미지 파일
		// *************우리의 OS가 windows이므로 아래 코드를 해줘야 함. (window는 File.seperator : \, linux : /) **************
		originalFile = originalFile.replace('/', File.separatorChar);
		thumbFile = thumbFile.replace('/', File.separatorChar);
		// **********************************************************************************************************************
		
		logger.info("삭제할 파일 (original) : " + originalFile + ", (thumb) : " + thumbFile);
		
		if(mType != null) {
			// 이미지 파일이면,
			// 삭제할 파일과 경로
			new File(originalFile).delete();
			new File(thumbFile).delete();
			
		}
		
		// DB테이블에서도 삭제
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	private String uploadFile(HttpServletRequest request, String originalFilename, byte[] file) throws IOException {
		// UUID : Universal Unique ID
		UUID uuid = UUID.randomUUID();
		
		String saveName = uuid.toString() + "_" + originalFilename;
		System.out.println("완성된 파일 이름 : " + saveName);
		
		String path = request.getSession().getServletContext().getRealPath("resources/uploads"); // request.getRealPath("resources/uploads")와 비교하여, 비슷하면 이걸 사용
		System.out.println(path);
		
		File target = new File(request.getRealPath("resources/uploads"), saveName);
		
		FileCopyUtils.copy(file, target); // 파일 복사
		
		return saveName;
	}
	
}
 