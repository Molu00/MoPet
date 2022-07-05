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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "comments")
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "name")
	private String name;
	
	@Column(name = "com_img")
	private String com_img;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createondate")
	private Date createondate;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="comments",cascade=CascadeType.ALL)
	private Set<Replies> replies = new LinkedHashSet<Replies>();
	
	@Transient
	@Column(name = "fk_member_id")
	private Integer fk_member_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_member_id")
	private member member;

//	private Integer count;
	
	//檢查是否有時間，如果沒有時間依照現在時間產生
		@PrePersist   //helper function 在物件轉換成Persistent狀態之前，做此方法
		public void onTiome() {
			if(createondate == null) {
				this.createondate = new Date();
			}
		}
	
	public Comments(Integer id) {
			super();
			this.id = id;
		}
	
//	public Integer getCount() {
//		return count;
//	}
//
//	public void setCount(Integer count) {
//		this.count = count;
//	}

	public String getCom_img() {
		return com_img;
	}

	public void setCom_img(String com_img) {
		this.com_img = com_img;
	}

	public Comments() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateondate() {
		return createondate;
	}

	public void setCreateondate(Date createondate) {
		this.createondate = createondate;
	}

	

	public Comments(Integer id, String title, String content, String name, String com_img, Date createondate,
			Set<Replies> replies, Integer fk_member_id, tw.com.MoPet.model.member member) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.name = name;
		this.com_img = com_img;
		this.createondate = createondate;
		this.replies = replies;
		this.fk_member_id = fk_member_id;
		this.member = member;
	}

	public Set<Replies> getReplies() {
		return replies;
	}

	public void setReplies(Set<Replies> replies) {
		this.replies = replies;
	}

	public Integer getFk_member_id() {
		return fk_member_id;
	}

	public void setFk_member_id(Integer fk_member_id) {
		this.fk_member_id = fk_member_id;
	}

	public member getMember() {
		return member;
	}

	public void setMember(member member) {
		this.member = member;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

}
