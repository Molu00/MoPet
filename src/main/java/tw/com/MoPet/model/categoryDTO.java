package tw.com.MoPet.model;

public class categoryDTO {
	
	private Integer foods;
	private Integer toys;
	private Integer clothing;
	private Integer supplies;
	private Integer cleaning;
	

	public categoryDTO() {
	}


	public Integer getFoods() {
		return foods;
	}


	public void setFoods(Integer foods) {
		this.foods = foods;
	}


	public Integer getToys() {
		return toys;
	}


	public void setToys(Integer toys) {
		this.toys = toys;
	}


	public Integer getClothing() {
		return clothing;
	}


	public void setClothing(Integer clothing) {
		this.clothing = clothing;
	}


	public Integer getSupplies() {
		return supplies;
	}


	public void setSupplies(Integer supplies) {
		this.supplies = supplies;
	}


	public Integer getCleaning() {
		return cleaning;
	}


	public void setCleaning(Integer cleaning) {
		this.cleaning = cleaning;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("categoryDTO [foods=");
		builder.append(foods);
		builder.append(", toys=");
		builder.append(toys);
		builder.append(", clothing=");
		builder.append(clothing);
		builder.append(", supplies=");
		builder.append(supplies);
		builder.append(", cleaning=");
		builder.append(cleaning);
		builder.append("]");
		return builder.toString();
	}

}
