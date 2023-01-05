package com.ericbarajas.dojosninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {

//-------------------MEMBER VARIABLES---------------//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
// MEMEBER VARIABLES - dependent on project
	@Size(min=2)
	private String name;
	
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
//------------------MEMBER VARIABLES---------------//    
    
    
//-----------------ESTABLISH RELATIONSHIP-----------//
    @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;
// ----------------ESTABLISH RELATIONSHIP-----------//   
    
    
//--------------------CONSTRUCTORS------------------//
// EMPTY CONSTRUCTOR
    public Dojo() {
    	
    }
    
// FULL CONSTRUCTOR
    public Dojo(@NotEmpty @Size(min=2)String name) {
    	super();
    	this.name = name;
    }
//--------------------CONSTRUCTORS------------------//
    
//--------------------CONSTRUCTORS------------------//
    
    
//---------GETTERS / SETTERS / OTHER METHODS--------//
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
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
//---------GETTERS / SETTERS / OTHER METHODS--------//
	
    
}
