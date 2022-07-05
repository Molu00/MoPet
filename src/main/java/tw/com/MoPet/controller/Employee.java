package tw.com.MoPet.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tw.com.MoPet.model.employee;
import tw.com.MoPet.model.member;
import tw.com.MoPet.service.employeeService;

@Controller
public class Employee {

	@Autowired
	private employeeService empService;

	@GetMapping(path = "employee/{id}")
	public employee findById(@PathVariable Integer id) {
		return empService.findById(id);
	}

	@GetMapping(path = "employee/delete/{id}")
	public String deleteById(@PathVariable Integer id) {
		employee temp = empService.findById(id);
		if (temp != null) {
			empService.delete(temp);
			return "redirect:/employees/all";
		}
		return "False";
	}

	@GetMapping(path = "employee")
	public String member() {
		return "empRegister";
	}
	
	@GetMapping(path = "employee/edit/{id}")
	public ModelAndView findById(ModelAndView mav,@PathVariable Integer id) {
		employee emp=empService.findById(id);
		mav.getModel().put("employee", emp);
		mav.setViewName("editEmp");
		return mav;
		
	}
	
	@PostMapping(path="employee/insert")
	public String insertEmp(@RequestParam("email") String user,
			@RequestParam("nickName") String name, @RequestParam("phonenNumber") String phone,
			@RequestParam("start_date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start, @RequestParam("profile") MultipartFile file, @RequestParam("character") String character) throws IOException {
		String temp=new String(Base64.getEncoder().encode(file.getBytes()));
		String profile="data:image/png;base64,"+temp;
		employee emp = new employee();
		emp.setEmpEmail(user);
		emp.setEmpPwd("MoPetisTheBest");
		emp.setEmpName(name);
		emp.setEmpTel(phone);
		emp.setEmpStartDate(start);
		emp.setEmpProfile(profile);
		emp.setEmpRole(character);
		empService.insert(emp);
		return "redirect:/employees/all";
	}
	
	@PostMapping(path="employee/edit/{id}")
	public String editEmp(@RequestParam("id") Integer id,@RequestParam("email") String user,
			@RequestParam("nickName") String name, @RequestParam("phonenNumber") String phone,
			@RequestParam("start_date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start, @RequestParam("profile") MultipartFile file, @RequestParam("character") String character) throws IOException {
		employee emp=empService.findById(id);
		if (file.isEmpty()) {
			emp.setEmpProfile(emp.getEmpProfile());
		}else {
		String temp=new String(Base64.getEncoder().encode(file.getBytes()));
		String profile="data:image/png;base64,"+temp;
		emp.setEmpProfile(profile);
		}
		emp.setEmpEmail(user);
		emp.setEmpPwd("MoPetisTheBest");
		emp.setEmpName(name);
		emp.setEmpTel(phone);
		emp.setEmpStartDate(start);	
		emp.setEmpRole(character);
		empService.insert(emp);
		return "redirect:/employees/all";
	}
	
	@GetMapping(path ="employees/all")
	public ModelAndView viewMessages(ModelAndView mav,
			@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, HttpSession session) {
		employee emp=(employee)session.getAttribute("backloginOK");
		employee emp1=empService.findById(emp.getEmpId());
		if (emp1.getEmpRole().equals("老闆")){
			mav.setViewName("noOK");
			return mav;
		}
		Page<employee> page = empService.findByPage(pageNumber);
		mav.getModel().put("page", page);
		mav.setViewName("viewEmployees");
		return mav;
	}
	
	@GetMapping(path = "home")
	public String home() {
		return "BackHome";
	}
	
}
