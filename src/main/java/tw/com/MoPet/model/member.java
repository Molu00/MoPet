package tw.com.MoPet.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "member_email")
	private String memberEmail;

	@Column(name = "member_pwd")
	private String memberPwd;

	@Column(name = "member_name")
	private String memberName;

	@Column(name = "member_tel")
	private String memberTel;

	@Column(name = "member_address")
	private String memberAddress;

	@Column(name = "member_profile")
	private String memberProfile;
	
	@Column(name = "member_gender")
	private String memberGender;
	
	@Column(name = "member_birth")
	private Date memberBirth;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "petOwner", cascade = CascadeType.ALL)
	private Set<pet> pets=new LinkedHashSet<pet>();
	
	public Set<pet> getPets() {
		return pets;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public Date getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}

	public void setPets(Set<pet> pets) {
		this.pets = pets;
	}

	public String getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}

	public member() {
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("member [id=");
		builder.append(id);
		builder.append(", memberEmail=");
		builder.append(memberEmail);
		builder.append(", memberPwd=");
		builder.append(memberPwd);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", memberTel=");
		builder.append(memberTel);
		builder.append(", memberAddress=");
		builder.append(memberAddress);
		builder.append(", memberProfile=");
		builder.append(memberProfile);
		builder.append(", memberGender=");
		builder.append(memberGender);
		builder.append(", memberBirth=");
		builder.append(memberBirth);
		builder.append(", pets=");
		builder.append(pets);
		builder.append("]");
		return builder.toString();
	}

	

}
