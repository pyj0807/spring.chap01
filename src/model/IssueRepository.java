package model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository	//이걸 하면 알아서 등록이되서 confing에  <context:component-scan base-package="model"/> 만 하면 된다
public class IssueRepository {

	@Autowired
	SqlSessionFactory factory;
	
	
	@Autowired
	SqlSessionTemplate template;
	
	public List<Map> getAllData(){
		SqlSession session = factory.openSession();
		try {
			return session.selectList("issue.getAllData");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}
	
	public List<Map> getAllWithOpinionCount(){
		return template.selectList("issue.getAllWithOpinionCount");
		
	}
	
	
}
