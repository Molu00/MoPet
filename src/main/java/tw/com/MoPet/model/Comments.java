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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createondate")
	private Date createondate;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="comments",cascade=CascadeType.ALL)
	private Set<Replies> replies = new LinkedHashSet<Replies>();

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

	public Comments(Integer id, String title, String content, String name, Date createondate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.name = name;
		this.createondate = createondate;
	}

}
