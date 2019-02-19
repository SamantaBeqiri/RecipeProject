package com.project.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.project.Entity.Category;


@Entity
@Table(name = "recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRecipe", nullable = false, length = 10)
	private int id;
	@Column(name = "title", nullable = false, length = 10)
	private String title;
	@Column(name = "description", nullable = false, length = 10)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="user_Id",nullable=false)
	User user ;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date",nullable=false)
	private Date date;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	@Column(name = "image", length = 500)
	private String image;
	@Column(name = "active", nullable = false)
	private boolean active;
	public int getId() {
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Recipe(int id, String title, String description, User user, Date date,
			Category category, String image, boolean active) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.user = user;
		this.date = date;
		this.category = category;
		this.image = image;
		this.active = active;
	}
	public Recipe() {
		
	}
	
	
	
	
	

}
