package tw.com.MoPet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "add_booking")
public class AddBookings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "staffname")
	private String staffname;
	
	@JsonFormat(pattern="yyyy/MM/dd", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd") // Spring MVC 用
	@Temporal(TemporalType.DATE)
	@Column(name="bookday", columnDefinition="date") // 預設是 datetime2
	private Date bookday;
	
	@Column(name = "starttime")
	private String start_booktime;
	
	
	@Column(name = "endtime")
	private String end_booktime;
	
	@Column(name = "status")
	private String status;
	
	
	public AddBookings() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	

	public String getStaffname() {
		return staffname;
	}


	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}


	public Date getBookday() {
		return bookday;
	}


	public void setBookday(Date bookday) {
		this.bookday = bookday;
	}


	

	public String getStart_booktime() {
		return start_booktime;
	}


	public void setStart_booktime(String start_booktime) {
		this.start_booktime = start_booktime;
	}


	

	public String getEnd_booktime() {
		return end_booktime;
	}


	public void setEnd_booktime(String end_booktime) {
		this.end_booktime = end_booktime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddBookings [id=");
		builder.append(id);
		builder.append(", staffname=");
		builder.append(staffname);
		builder.append(", bookday=");
		builder.append(bookday);
		builder.append(", start_booktime=");
		builder.append(start_booktime);
		builder.append(", end_booktime=");
		builder.append(end_booktime);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}


	   
}
