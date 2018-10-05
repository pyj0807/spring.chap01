package controllers.study;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.IssueRepository;

@Controller
@RequestMapping("/study")
public class JulietController {

	@Autowired 
	IssueRepository ir;
	
	@RequestMapping("/22.do")
	public void study22Handle() {
		List<Map> li = ir.getAllData();
		List<Map> lii = ir.getAllWithOpinionCount();
		System.out.println(li);
		System.out.println(lii);
	}
	

	
}
