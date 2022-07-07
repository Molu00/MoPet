package tw.com.MoPet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "replies")
public class Replies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "content")
	private String content;

	@Column(name = "rep_img")
	private String rep_img;
	

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createondate")
	private Date createondate;

//	@Transient
//	@Column(name = "fk_member_id")
//	private Integer fk_member_id;
	
	@Transient
	@Column(name = "fk_c_id")
	private Integer fk_c_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_c_id")
	private Comments comments;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "fk_member_id")
//	private member member;

	@PrePersist
	public void onTiome() {
		if (createondate == null) {
			this.createondate = new Date();
		}
	}

	public Replies() {
	}

	public String getRep_img() {
		return rep_img;
	}

	public void setRep_img(String rep_img) {
		this.rep_img = rep_img;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateondate() {
		return createondate;
	}

	public void setCreateondate(Date createondate) {
		this.createondate = createondate;
	}

	public Integer getFk_c_id() {
		return fk_c_id;
	}

	public void setFk_c_id(Integer fk_c_id) {
		this.fk_c_id = fk_c_id;
	}

	
	
//	public Integer getFk_member_id() {
//		return fk_member_id;
//	}
//
//	public void setFk_member_id(Integer fk_member_id) {
//		this.fk_member_id = fk_member_id;
//	}
//
//	public member getMember() {
//		return member;
//	}
//
//	public void setMember(member member) {
//		this.member = member;
//	}



	public Replies(Integer id, String name, String content, String rep_img, Date createondate, Integer fk_member_id,
			Integer fk_c_id, Comments comments, tw.com.MoPet.model.member member) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.rep_img = rep_img;
		this.createondate = createondate;
//		this.fk_member_id = fk_member_id;
		this.fk_c_id = fk_c_id;
		this.comments = comments;
//		this.member = member;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

}
