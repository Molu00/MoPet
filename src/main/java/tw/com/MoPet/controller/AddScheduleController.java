package tw.com.MoPet.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.com.MoPet.model.AddSchedules;
import tw.com.MoPet.model.AddWorkdays;
import tw.com.MoPet.service.AddScheduleService;


@Controller
@SessionAttributes(names= {"addworkday_session"})
public class AddScheduleController {

	@Autowired
	private AddScheduleService scheduleService;
	
	private int month_day;

	private int month_day1;
	
	@PostMapping("addScheduleOld")
	public String addSchedule(AddSchedules schedule ,ModelMap model, HttpSession httpSession ) {
		
	    //session物件取出，將addworkdays進行專喚出scchedule
		AddWorkdays workday = new AddWorkdays();
		System.out.println(httpSession.getAttribute("addworkday_session"));
		
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
//          System.out.println("----------------------------------------------------");
//          System.out.println("日期:"+localDate+"星期:"+localDateWeek);
           
            
          //拿Session值
        	AddWorkdays addworkday = (AddWorkdays) httpSession.getAttribute("addworkday_session");
    		String[] vactions = addworkday.getAddVactions();
    		String[] workdays = addworkday.getAddWorkdays();
    		String[] weekens = addworkday.getAddWeekens();
    		String staffname = addworkday.getStaffname();
    		String starttime = addworkday.getStarttime();
    		String endtime = addworkday.getEndtime();
    		String wk_starttime =addworkday.getWk_starttime();
    		String wk_endtime = addworkday.getWk_endtime();
    		//僵直放入AddSchedule
    		 schedule = new AddSchedules();
            
            //判斷日期是否為休假日(vactions[j])，為休假日則status列為close
            for(int j=0 ; j<vactions.length;j++) 
            {   
//            	System.out.println(vactions[j]);
            	//列印出日期是否為選擇的日期，以星期為條件判斷
//        		System.out.println((localDateWeek.toString()).equals(vactions[j]));
            	
                if((localDateWeek.toString()).equals(vactions[j])) 
                {
//                schedule.setStaffname(");	
                	
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
	 
		
		return "redirect:/schedule/all";
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
		@GetMapping("schedule/all")
		public String allSchedulePage(AddSchedules schedule,Model model,HttpSession httpSession) {
			AddWorkdays addworkday = (AddWorkdays) httpSession.getAttribute("addworkday_session");
			String staffname = addworkday.getStaffname();			
	        List<AddSchedules> addschedules =scheduleService.getByName(staffname);
	        

			model.addAttribute("addschedules", addschedules);

			return "viewSchedules";
		}
		@GetMapping("schedule/editSchedule")
		public String editSchedule(@RequestParam("staffname") String staffname, Model model) {
			
			List<AddSchedules> addschedules =scheduleService.getByName(staffname);
			
			model.addAttribute("addschedules", addschedules);
			
			return "viewSchedules";
		}
}
