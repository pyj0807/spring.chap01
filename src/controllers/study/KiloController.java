package controllers.study;

import java.io.File;
import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.AlertService;

/*
 * Multipart 처리 (File upload)
 *  - Spring은 Mltipart 요청도 처리하게 편하게 처리해서 요청처리 메서드에 Inject 해준다
 *  어떤 라이브러리를 써서 분석할껀지만 설정해주면 된다
 *  
 *  Spring 에서는 멀티파트 parsing 라이브러리로 Commons File Upload lib 로 처리한다
 *  
 *  maven repository 에서 Apache commons fileupload (Apache commons IO)
 *   를 찾아서 pom.xml에 등록후,
 *   
 *  Spring bean configuration 파일에 가서
 *  
 *  mulipartResolver 를 등록
 */
@Controller
@RequestMapping("/study")
public class KiloController {

	@Autowired
	AlertService service;
	
	@Autowired
	ServletContext ctx;

	@RequestMapping("/26.do")
	public String study26Handle() {
		String json = "{\"mode\":\"upload\"}";
		service.sendAll(json);
		return "upload";
	}

	@RequestMapping("/27.do")
	public void study27Handle(@RequestParam String info, @RequestParam MultipartFile attach) throws IOException {
		
		
		
		System.out.println("info =" + info);
		System.out.println("attach =" + attach + "/" + attach.isEmpty());
		// MultipartFile 객체는 첨부된 파일데이터가 없어도 생성된다, Empty 체크할것.
		// 기본적으로 임시 디렉터리에 저장되고,
		String type = attach.getContentType(); // 파일종류
		System.out.println("type =" + type);

		String fileName = attach.getOriginalFilename(); // 파일명
		System.out.println("fileName =" + fileName);

		String name = attach.getName(); // 파라미터명임(attach)
		System.out.println("name =" + name);

		long size = attach.getSize(); // 파일크기
		System.out.println("size =" + size);

		// 파일정보들은 database 같은걸 이용해서 기록을 해두겠지만, 실제 업로드 처리를 하려면...
		// attach.transferTo(dest);
		// 이 파일을 어디로 옮길껀지 설정해서 경로와 파일명을 지정하여
		// File객체를 만들어서 설정, 실제 서버내부로 저장하기 위해선
		// application.getRealPath를 이용해서 경로를 얻어야 하는데
		// ServletContext 객체는 따로 매개변수로 설정해서 사용하는게 아니라

		String path = ctx.getRealPath("/storage");
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		System.out.println(dir);
		File dst = new File(dir, fileName);
		attach.transferTo(dst);

	}

	@RequestMapping("/28.do")
	public String study28Handle() {
		return "upload2";
	}

	@RequestMapping("/29.do")
	public void study29Handle(@RequestParam MultipartFile[] attach) {
		if(attach.length==1 && attach[0].isEmpty()) {
			System.out.println("업로드된 파일이 없다");
		}else {
			System.out.println("업로드된 파일 개수 :"+attach.length);
			for (int i = 0; i < attach.length; i++) {
				System.out.println("->"+ attach[i].getOriginalFilename());
				//attach[i].transferTo();
			}
		}
	
	}

}


























