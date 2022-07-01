package tw.com.MoPet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "add_schedule")
public class AddSchedules {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "staffname")
	private String staffname;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd") // Spring MVC 用
	@Temporal(TemporalType.DATE)
	@Column(name="added", columnDefinition="date") // 預設是 datetime2
	private Date added;
	
	// 檢查是否有時間，沒有的話依照現在時間產生
	@PrePersist // helper function 在物件轉換成 Persistent 狀態以前，做此方法
	public void onCreate() {
		if(added == null) {
			this.added = new Date();
		}
	}
	 @Column(name = "starttime")
	 private String starttime;
	 
	 @Column(name = "endtime")
	 private String endtime;
     
	 @Column(name = "status")
	 private String status;
	 
	 public AddSchedules() {
			
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

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
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
		builder.append("AddSchedules [id=");
		builder.append(id);
		builder.append(", staffname=");
		builder.append(staffname);
		builder.append(", added=");
		builder.append(added);
		builder.append(", starttime=");
		builder.append(starttime);
		builder.append(", endtime=");
		builder.append(endtime);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}


}

