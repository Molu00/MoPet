package tw.com.MoPet.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import tw.com.MoPet.model.AddBookings;
import tw.com.MoPet.model.AddSchedules;
import tw.com.MoPet.model.AddWorkdays;
import tw.com.MoPet.model.employee;
import tw.com.MoPet.service.AddBookingService;
import tw.com.MoPet.service.AddScheduleService;
import tw.com.MoPet.service.employeeService;

@Controller
@SessionAttributes(names= {"addworkday_session"})
public class AddWorkdayController {
	
	@Autowired
	private employeeService empService;
	
	@Autowired
	private AddScheduleService scheduleService;
	
	@Autowired
	private AddBookingService bookingService;
	
	private int month_day;

	private int month_day1;

	private String staffname;
	
	@RequestMapping(value = "/workday", method = RequestMethod.GET)
	   public ModelAndView addWorkday(@RequestParam("id") Integer id, Model model) {
		  
		  employee emp = empService.findById(id);
		  model.addAttribute("staffName", emp.getEmpName());
		
	      AddWorkdays addWorkday = new AddWorkdays();	
	      addWorkday.setStaffname(emp.getEmpName());
	      model.addAttribute("staffName", addWorkday.getStaffname());
	      addWorkday.setAddVactions((new String []{"星期六","星期日"}));
	      addWorkday.setAddWorkdays((new String []{"星期一","星期二","星期三","星期四","星期五"}));
	      addWorkday.setAddWeekens((new String []{"星期六","星期日"}));
		  ModelAndView modelAndView = new ModelAndView("addWorkday", "command", addWorkday);
		  return modelAndView;
	   }
	
	@RequestMapping(value = "/addSchedule", method = RequestMethod.POST)
	   public String addWorkday(@ModelAttribute("SpringWeb")AddWorkdays addWorkday, 
	      ModelMap model,HttpSession httpSession) { 
		  
		  model.addAttribute("staffName",addWorkday.getStaffname());
	      model.addAttribute("addVactions", addWorkday.getAddVactions());
	      model.addAttribute("addWorkdays", addWorkday.getAddWorkdays());
	      model.addAttribute("starttime", addWorkday.getStarttime());
	      model.addAttribute("endtime", addWorkday.getEndtime());
	      model.addAttribute("addWeekens", addWorkday.getAddWeekens());
	      model.addAttribute("wk_starttime", addWorkday.getWk_starttime());
	      model.addAttribute("wk_endtime", addWorkday.getWk_endtime());
	      model.addAttribute("addworkday_session",addWorkday);
	      
	      
	     
			
		
			//得到今天是刑期幾->目前用不到
			long miliseconds = System.currentTimeMillis();
		    Date date = new Date(miliseconds);
		    String week= new SimpleDateFormat("E").format(date);
		    System.out.println(week);
		    
		    //得到今天的日期並轉換星期->為目前可以使用的格式
		    LocalDate today = LocalDate.now();
		    DayOfWeek dayOfWeek = today.getDayOfWeek();
	        System.out.println(dayOfWeek);
	        
	        
	        //以下3個String分別為本月最後一天、下個月的第一天和最後一天
	        String thisMonthLastDay = getLastDayOfMonth();
	        String nextMonthFirstDay = getFirstDayOfNextMonth();
	        String nextMonthLastDay = getLastDayOfNextMonth();
	        //將日期轉換為統一格式
	        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
	        
	        try {
	        	
	        //將今天日期的localtime轉成date套件	
	        	ZoneId zoneId = ZoneId.systemDefault();
	            ZonedDateTime zdt = today.atStartOfDay(zoneId);
	            Date date_current =Date.from(zdt.toInstant());
	          
	         //將這個月最後一天轉換為統一日期格式   
				 Date date_thisMonthLastDay = dateParser.parse(thisMonthLastDay);
				
			//將2日期相減，這個月最後一天減掉今天	 
				 long diff = date_thisMonthLastDay.getTime() - date_current.getTime();
				 TimeUnit time = TimeUnit.DAYS; 
			     long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
			     System.out.println("The difference in days is : "+diffrence);
			     month_day = Integer.parseInt(String.valueOf(diffrence));
			     
			 //將2日期相減，下個月最後一天減掉下個月第一天    
			     Date date_nextMonthFirstDay = dateParser.parse(nextMonthFirstDay);
			     Date date_nextMonthLastDay = dateParser.parse(nextMonthLastDay);
			     
			     long diff1 = date_nextMonthLastDay.getTime() - date_nextMonthFirstDay.getTime();
				 TimeUnit time1 = TimeUnit.DAYS; 
			     long diffrence1 = time1.convert(diff1, TimeUnit.MILLISECONDS);
			     System.out.println("The difference in days is : "+diffrence1);
			     month_day1 = Integer.parseInt(String.valueOf(diffrence1));
				
			} catch (ParseException e) {
			
				e.printStackTrace();
			}
	       
	        
	        //Ref:https://stackoverflow.com/questions/65335253/iterate-over-dates-in-java
	        //列出這個月和下個月所有日期
	        for ( int i = 0 ; i < ((month_day+1) +(month_day1+1)) ; i++ )
	        {
	            LocalDate localDate = today.plusDays( i );
	            ZoneId zoneId = ZoneId.systemDefault();
	            ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
	            Date date_current =Date.from(zdt.toInstant());
	            DayOfWeek localDateWeek = localDate.getDayOfWeek();
//	          System.out.println("----------------------------------------------------");
//	          System.out.println("日期:"+localDate+"星期:"+localDateWeek);
	           
	            
	    		String[] vactions = addWorkday.getAddVactions();
	    		String[] workdays = addWorkday.getAddWorkdays();
	    		String[] weekens = addWorkday.getAddWeekens();
	    		String staffname = addWorkday.getStaffname();
	    		String starttime = addWorkday.getStarttime();
	    		String endtime = addWorkday.getEndtime();
	    		String wk_starttime =addWorkday.getWk_starttime();
	    		String wk_endtime = addWorkday.getWk_endtime();
	    		
	            
	            //判斷日期是否為休假日(vactions[j])，為休假日則status列為close
	            for(int j=0 ; j<vactions.length;j++) 
	            {   
//	            	System.out.println(vactions[j]);
	            	//列印出日期是否為選擇的日期，以星期為條件判斷
//	        		System.out.println((localDateWeek.toString()).equals(vactions[j]));
	            	
	                if((localDateWeek.toString()).equals(vactions[j])) 
	                {
//	                schedule.setStaffname(");	
	                	
	                AddSchedules newSchedule = new AddSchedules();
	                newSchedule.setStaffname(staffname);
	                newSchedule.setAdded(date_current);                  
	                newSchedule.setStarttime("");
	                newSchedule.setEndtime("");
	             
	                newSchedule.setStatus("close");
	                scheduleService.insertSchedule(newSchedule);
	            	model.addAttribute("addSchedules",newSchedule);	
	            	System.out.println( "休假日 = " + localDate + localDateWeek);	
	                }
	                
	            }
	            
	            for(int j=0 ; j<workdays.length;j++) 
	            {   
	            	System.out.println(workdays[j]);
	            	//列印出日期是否為選擇的日期，以星期為條件判斷
	        		System.out.println((localDateWeek.toString()).equals(workdays[j]));
	            	
	                if((localDateWeek.toString()).equals(workdays[j])) 
	                {
	                AddSchedules newSchedule = new AddSchedules();
	                newSchedule.setStaffname(staffname);
	                newSchedule.setAdded(date_current);
	                newSchedule.setStarttime(starttime);
	                newSchedule.setEndtime(endtime);
	                newSchedule.setStatus("open");
	                scheduleService.insertSchedule(newSchedule);
	            	model.addAttribute("addSchedules",newSchedule);	                
	            	System.out.println( "上班日 = " + localDate + localDateWeek);	
	                }
	                
	            }
	            
	            for(int j=0 ; j<weekens.length;j++) 
	            {   
	            	System.out.println(weekens[j]);
	            	//列印出日期是否為選擇的日期，以星期為條件判斷
	        		System.out.println((localDateWeek.toString()).equals(weekens[j]));
	            	
	                if((localDateWeek.toString()).equals(weekens[j])) 
	                {
	                AddSchedules newSchedule = new AddSchedules();
	                newSchedule.setStaffname(staffname);
	                newSchedule.setAdded(date_current);
	                newSchedule.setStarttime(wk_starttime);
	                newSchedule.setEndtime(wk_endtime);
	                newSchedule.setStatus("open");
	                scheduleService.insertSchedule(newSchedule);
	                model.addAttribute("addSchedules",newSchedule);	
	            	System.out.println( "上班日 = " + localDate + localDateWeek);	
	                }
	                
	            }
	        }
	            List<AddSchedules> addschedules = bookingService.getByName(staffname);

	    		for (int i = 0; i < addschedules.size(); i++) {
	    			String book_staffname = addschedules.get(i).getStaffname();
	    			Date bookday = addschedules.get(i).getAdded();
	    			String start_booktime = addschedules.get(i).getStarttime();
	    			String end_booktime = addschedules.get(i).getEndtime();
	    			String status = addschedules.get(i).getStatus();

	    			if (status.equals("open")) {
	    				LocalTime timeStart = LocalTime.parse(start_booktime);
	    				LocalTime timeEnd = LocalTime.parse(end_booktime);
	    				while (timeStart.isBefore(timeEnd)) {
	    					AddBookings booking = new AddBookings();
	    					booking.setStaffname(book_staffname);
	    					booking.setBookday(bookday);
	    					booking.setStart_booktime(timeStart.toString());
	    					timeStart = timeStart.plusMinutes(30);
	    					booking.setEnd_booktime(timeStart.toString());
	    					booking.setStatus("free");
	    					bookingService.insertBooking(booking);
	    					System.out.println(timeStart.format(DateTimeFormatter.ofPattern("HH:mm")));

	    				}
	    			}

	    		}
	           
	            
	        
		 
			
			return "redirect:/schedule/all";
	   }
	@ModelAttribute("webVactionList")
	public Map<String, String> webVactionList(){
		Map<String, String> webVactionList = new LinkedHashMap<String, String>();
		webVactionList.put("MONDAY", "星期一");
		webVactionList.put("TUESDAY", "星期二");
		webVactionList.put("WEDNESDAY", "星期三");
		webVactionList.put("THURSDAY", "星期四");
		webVactionList.put("FRIDAY", "星期五");
		webVactionList.put("SATURDAY", "星期六");
		webVactionList.put("SUNDAY", "星期日");
		return webVactionList;
	}
	
	@ModelAttribute("webDateList")
	public Map<String, String> webDateList(){
		Map<String, String> webDateList = new LinkedHashMap<String, String>();
		webDateList.put("MONDAY", "星期一");
		webDateList.put("TUESDAY", "星期二");
		webDateList.put("WEDNESDAY", "星期三");
		webDateList.put("THURSDAY", "星期四");
		webDateList.put("FRIDAY", "星期五");
		return webDateList;
	}
	@ModelAttribute("webWeekenList")
	public Map<String, String> webWeekenList(){
		Map<String, String> webWeekenList = new LinkedHashMap<String, String>();
		webWeekenList.put("SATURDAY", "星期六");
		webWeekenList.put("SUNDAY", "星期日");
		return webWeekenList;
	}
	
//	@ModelAttribute("webVactionList")
//	public List<Wenk> webVactionList(){
//		List<Wenk> webVactionList = new ArrayList<Wenk>();
//	   com,ispan.springbootdemo.code->enun寫法
//		webVactionList.add(Wenk.Momday);
//		webVactionList.add("星期二");
//		webVactionList.add("星期三");
//		webVactionList.add("星期四");
//		webVactionList.add("星期五");
//		webVactionList.add("星期六");
//		webVactionList.add("星期日");
//		return webVactionList; 		
//	}
//	@ModelAttribute("webDateList")
//	public List<String> webDateList(){
//		List<String> webDateList = new ArrayList<String>();
//		webDateList.add("星期一");
//		webDateList.add("星期二");
//		webDateList.add("星期三");
//		webDateList.add("星期四");
//		webDateList.add("星期五");
//		return webDateList;		
//	}
//	@ModelAttribute("webWeekenList")
//	public List<String> webWeekenList(){
//		List<String> webWeekenList = new ArrayList<String>();
//		webWeekenList.add("星期六");
//		webWeekenList.add("星期日");
//		return webWeekenList;
//		
//	}
	@ModelAttribute("webWorktimeList")
	public List<String> webWorktimeList(){
		List<String> webWorktimeList = new ArrayList<String>();
		webWorktimeList.add("08:00");
		webWorktimeList.add("08:30");
		webWorktimeList.add("09:00");
		webWorktimeList.add("09:30");
		webWorktimeList.add("10:00");
		webWorktimeList.add("10:30");
		webWorktimeList.add("11:00");
		webWorktimeList.add("11:30");
		webWorktimeList.add("12:00");
		webWorktimeList.add("12:30");
		webWorktimeList.add("13:00");
		webWorktimeList.add("13:30");
		webWorktimeList.add("14:00");
		webWorktimeList.add("14:30");
		webWorktimeList.add("15:00");
		webWorktimeList.add("15:30");
		webWorktimeList.add("16:00");
		webWorktimeList.add("16:30");
		webWorktimeList.add("17:00");
		webWorktimeList.add("17:30");
		webWorktimeList.add("18:00");
		webWorktimeList.add("18:30");
		webWorktimeList.add("19:00");
		webWorktimeList.add("19:30");
		webWorktimeList.add("20:00");
		webWorktimeList.add("20:30");
		webWorktimeList.add("21:00");

		return webWorktimeList;

	
		
	}
	
	// 获取当月最后一天
		public String getLastDayOfMonth() {
			String strLastDay = "";
			SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DATE, 1);		// 设置当前月的1号
			calendar.add(Calendar.MONDAY, 1);	// 加一个月，变为下月的1号
			calendar.add(Calendar.DATE, -1);	// 减去一天，变为当前月的最后一天
			
			strLastDay = sDateFormat.format(calendar.getTime());
			return strLastDay;
		}
		
		// 获取下月第一天
			public String getFirstDayOfNextMonth() {
				String strFirstDay = "";
				SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.MONTH, 1);	// 加一个月
				calendar.set(Calendar.DATE, 1);		// 设置当前月第一天
				
				strFirstDay = sDateFormat.format(calendar.getTime());
				return strFirstDay;
			}
		
		// 获取下月最后一天
			public String getLastDayOfNextMonth() {
				String strLastDay = "";
				SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.DATE, 1);		// 设置当前月的1号
				calendar.add(Calendar.MONDAY, 2);	// 加两个月，变为下下月的1号
				calendar.add(Calendar.DATE, -1);	// 减一天，变为下月的最后一天
				
				strLastDay = sDateFormat.format(calendar.getTime());
				return strLastDay;
			}
	
}

