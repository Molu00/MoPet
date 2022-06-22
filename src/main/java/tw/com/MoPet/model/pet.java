package tw.com.MoPet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="pet")
public class pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pet_id")
	private Integer pet_id;
	
	@Column(name="pet_name")
	private String pet_name;
	
	@Column(name="pet_breed")
	private String pet_breed;
	
	@Column(name="pet_category")
	private String pet_category;
	
	@Column(name="pet_profile")
	private String pet_profile;
	
	@Column(name="pet_sex")
	private String pet_sex;
	
	@Column(name="fk_id")
	@Transient
	private Integer owner_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_id")
	private member petOwner;

	public pet() {
	}

	public Integer getPet_id() {
		return pet_id;
	}

	public void setPet_id(Integer pet_id) {
		this.pet_id = pet_id;
	}

	public String getPet_name() {
		return pet_name;
	}

	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}

	public String getPet_breed() {
		return pet_breed;
	}

	public void setPet_breed(String pet_breed) {
		this.pet_breed = pet_breed;
	}

	public String getPet_category() {
		return pet_category;
	}

	public void setPet_category(String pet_category) {
		this.pet_category = pet_category;
	}

	public String getPet_profile() {
		return pet_profile;
	}

	public void setPet_profile(String pet_profile) {
		this.pet_profile = pet_profile;
	}

	public String getPet_sex() {
		return pet_sex;
	}

	public void setPet_sex(String pet_sex) {
		this.pet_sex = pet_sex;
	}

	public Integer getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}

	public member getPetOwner() {
		return petOwner;
	}

	public void setPetOwner(member petOwner) {
		this.petOwner = petOwner;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("pet [pet_id=");
		builder.append(pet_id);
		builder.append(", pet_name=");
		builder.append(pet_name);
		builder.append(", pet_breed=");
		builder.append(pet_breed);
		builder.append(", pet_category=");
		builder.append(pet_category);
		builder.append(", pet_profile=");
		builder.append(pet_profile);
		builder.append(", pet_sex=");
		builder.append(pet_sex);
		builder.append(", owner_id=");
		builder.append(owner_id);
		builder.append(", petOwner=");
		builder.append(petOwner);
		builder.append("]");
		return builder.toString();
	}

}
