package com.ericbarajas.dojosninjas.models;

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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
//  MEMBER VARIABLES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
// MEMBER VARIABLES - dependent on project
	@NotEmpty
	@Size(min=3)
	private String firstName;
	@NotEmpty
	@Size(min=2)
	private String lastName;
	@NotNull
	@Range(min=1 , max=120)
	private int age;
	
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
// ESTABLISH RELATIONSHIP
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo creator;
    
//	CONSTRUCTORS
// EMPTY CONSTRUCTOR
    public Ninja() {
    	
    }
// FULL CONSTRUCTOR
    public Ninja(@NotEmpty @Size(min = 3) String firstName, @NotEmpty @Size(min = 2) String lastName,
    		@NotEmpty @Size(min = 1) int age, Dojo creator) {
    	super();
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.age = age;
    	this.creator = creator;
    }
    
//	  GETTERS / SETTERS / OTHER METHODS
//  ensures our created_at and updated_at get the dates that it needs (without will get no values)
    @PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
	@PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }
	
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Dojo getCreator() {
		return creator;
	}
	public void setCreator(Dojo creator) {
		this.creator = creator;
	}
    
    
    
}
