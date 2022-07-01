package tw.com.MoPet.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InitListJsp {

	// finishList
	@Bean
	public Map<String, String> finishList() {
		Map<String, String> finishList = new HashMap<String, String>();
		finishList.put("finish", "已完成");
		finishList.put("unfinish", "未完成");
		return finishList;
	}

	// cancelList
	@Bean
	public Map<String, String> cancelList() {
		Map<String, String> cancelList = new HashMap<String, String>();
		cancelList.put("finish", "已取消");
		cancelList.put("unfinish", "未取消");
		return cancelList;
	}

	@Bean
	public Map<String, String> permissionList() {
		Map<String, String> permissionList = new HashMap<String, String>();
		permissionList.put("permission1", "打單和預約權限");
		permissionList.put("permission2", "店長權限");

		return permissionList;

	}

	@Bean
	public Map<String, String> genderList() {
		Map<String, String> genderList = new HashMap<String, String>();
		genderList.put("male", "男");
		genderList.put("female", "女");

		return genderList;

	}

	@Bean
	public Map<String, String> staffpositionList() {
		Map<String, String> staffpositionList = new HashMap<String, String>();
		staffpositionList.put("leader", "店長");
		staffpositionList.put("designer", "設計師");
		return staffpositionList;

	}

	@Bean
	public Map<String, String> activeList() {
		Map<String, String> activeList = new HashMap<String, String>();
		activeList.put("unactive", "未開通");
		activeList.put("activated", "已開通");
		return activeList;
	}
	
	@Bean
	public List<String> webVactionList(){
		List<String> webVactionList = new ArrayList<String>();
		webVactionList.add("星期一");
		webVactionList.add("星期二");
		webVactionList.add("星期三");
		webVactionList.add("星期四");
		webVactionList.add("星期五");
		webVactionList.add("星期六");
		webVactionList.add("星期日");
		return webVactionList; 
		
	}
	@Bean
	public List<String> webDateList(){
		List<String> webDateList = new ArrayList<String>();
		webDateList.add("星期一");
		webDateList.add("星期二");
		webDateList.add("星期三");
		webDateList.add("星期四");
		webDateList.add("星期五");
		return webDateList;		
	}
	@Bean
	public List<String> webWeekenList(){
		List<String> webWeekenList = new ArrayList<String>();
		webWeekenList.add("星期六");
		webWeekenList.add("星期日");
		return webWeekenList;
		
	}
}