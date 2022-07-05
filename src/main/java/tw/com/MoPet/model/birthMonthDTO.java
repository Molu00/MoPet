package tw.com.MoPet.model;

public class birthMonthDTO {

	private Integer january;
	private Integer february;
	private Integer march;
	private Integer april;
	private Integer may;
	private Integer june;
	private Integer july;
	private Integer august;
	private Integer september;
	private Integer october;
	private Integer november;
	private Integer december;
	
	public birthMonthDTO() {
	}

	public Integer getJanuary() {
		return january;
	}

	public void setJanuary(Integer january) {
		this.january = january;
	}

	public Integer getFebruary() {
		return february;
	}

	public void setFebruary(Integer february) {
		this.february = february;
	}

	public Integer getMarch() {
		return march;
	}

	public void setMarch(Integer march) {
		this.march = march;
	}

	public Integer getApril() {
		return april;
	}

	public void setApril(Integer april) {
		this.april = april;
	}

	public Integer getMay() {
		return may;
	}

	public void setMay(Integer may) {
		this.may = may;
	}

	public Integer getJune() {
		return june;
	}

	public void setJune(Integer june) {
		this.june = june;
	}

	public Integer getJuly() {
		return july;
	}

	public void setJuly(Integer july) {
		this.july = july;
	}

	public Integer getAugust() {
		return august;
	}

	public void setAugust(Integer august) {
		this.august = august;
	}

	public Integer getSeptember() {
		return september;
	}

	public void setSeptember(Integer september) {
		this.september = september;
	}

	public Integer getOctober() {
		return october;
	}

	public void setOctober(Integer october) {
		this.october = october;
	}

	public Integer getNovember() {
		return november;
	}

	public void setNovember(Integer november) {
		this.november = november;
	}

	public Integer getDecember() {
		return december;
	}

	public void setDecember(Integer december) {
		this.december = december;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("birthMonthDTO [january=");
		builder.append(january);
		builder.append(", february=");
		builder.append(february);
		builder.append(", march=");
		builder.append(march);
		builder.append(", april=");
		builder.append(april);
		builder.append(", may=");
		builder.append(may);
		builder.append(", june=");
		builder.append(june);
		builder.append(", july=");
		builder.append(july);
		builder.append(", august=");
		builder.append(august);
		builder.append(", september=");
		builder.append(september);
		builder.append(", october=");
		builder.append(october);
		builder.append(", november=");
		builder.append(november);
		builder.append(", december=");
		builder.append(december);
		builder.append("]");
		return builder.toString();
	}



}
