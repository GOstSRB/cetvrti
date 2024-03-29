package jwd.wafepa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Models a physical activity.
 * 
 *
 */
@Entity
@Table(name="tblActivity")
public class Activity {

	@Id 
	@GeneratedValue 
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="admin_coment")
	private String adminComment="Test";
	

	public Activity() {
		super();
	}

	public Activity(String name) {
		super();
		this.name = name;
	}

	public Activity(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * 
	 * @return Activity identifier.
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets activity identifier.
	 * @param id new identifier
 	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return Name of the activity.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name New name of the activity.
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getAdminComment() {
		return adminComment;
	}

	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}
	
	
}
