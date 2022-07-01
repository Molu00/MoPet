package tw.com.MoPet.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.com.MoPet.model.AddBookings;
import tw.com.MoPet.model.AddSchedules;
import tw.com.MoPet.model.employee;
import tw.com.MoPet.service.AddBookingService;


@Controller
public class AddBookingController {

	@Autowired
	private AddBookingService bookingService;

	@GetMapping("staff/option")
	public String allStaffPage(employee emp, Model model) {

		List<employee> addemp = bookingService.getAll();

		model.addAttribute("addstaffs", addemp);

		return "bookStaffs";
	}

	@GetMapping("booking/all")
	public String addBooking(@RequestParam("staffname") String staffname, Model model) {

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

		model.addAttribute("addschedules", addschedules);

		return "bookWorkdays";
	}
	
	@GetMapping("booking/editBooking")
	public String editBooking(@RequestParam("bookday") @DateTimeFormat(pattern = "yyyy-MM-dd") Date bookday, Model model) {
		
		List<AddBookings> addbookings =bookingService.getByBookday(bookday);
		System.out.println(addbookings);
		model.addAttribute("addbookings", addbookings);
		
		return "bookWorktimes";
	}
	@GetMapping("time/bookTime")
	public String editTime(@RequestParam("id") Long id, Model model) {
		AddBookings booking = bookingService.findById(id);
		
		model.addAttribute("booking", booking);
		
		return "bookList";
	}

}

