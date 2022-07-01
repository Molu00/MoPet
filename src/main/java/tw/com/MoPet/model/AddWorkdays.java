package tw.com.MoPet.model;

import java.util.Arrays;

public class AddWorkdays {
	
	 private String staffname;
	 private String [] addVactions;
	 private String [] addWorkdays;
	 private String starttime;
	 private String endtime;
	 private String [] addWeekens;
	 private String wk_starttime;
	 private String wk_endtime;
	 
	 public AddWorkdays() {
			
		}

	 
	 
	public String getStaffname() {
		return staffname;
	}



	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}



	public String[] getAddVactions() {
		return addVactions;
	}

	public void setAddVactions(String[] addVactions) {
		this.addVactions = addVactions;
	}

	public String[] getAddWorkdays() {
		return addWorkdays;
	}

	public void setAddWorkdays(String[] addWorkdays) {
		this.addWorkdays = addWorkdays;
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

	

	public String[] getAddWeekens() {
		return addWeekens;
	}

	public void setAddWeekens(String[] addWeekens) {
		this.addWeekens = addWeekens;
	}

	public String getWk_starttime() {
		return wk_starttime;
	}

	public void setWk_starttime(String wk_starttime) {
		this.wk_starttime = wk_starttime;
	}

	public String getWk_endtime() {
		return wk_endtime;
	}

	public void setWk_endtime(String wk_endtime) {
		this.wk_endtime = wk_endtime;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddWorkdays [staffname=");
		builder.append(staffname);
		builder.append(", addVactions=");
		builder.append(Arrays.toString(addVactions));
		builder.append(", addWorkdays=");
		builder.append(Arrays.toString(addWorkdays));
		builder.append(", starttime=");
		builder.append(starttime);
		builder.append(", endtime=");
		builder.append(endtime);
		builder.append(", addWeekens=");
		builder.append(Arrays.toString(addWeekens));
		builder.append(", wk_starttime=");
		builder.append(wk_starttime);
		builder.append(", wk_endtime=");
		builder.append(wk_endtime);
		builder.append("]");
		return builder.toString();
	}

	


}
