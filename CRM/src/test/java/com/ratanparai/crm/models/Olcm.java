package com.ratanparai.crm.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Olcm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    
    private String Description;

    public Olcm(String title, String Description) {
        this.title = title;
        this.Description = Description;
    }

    
    /**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
    
    /**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.Description = description;
	}
    
    /**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
    
    /**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
    
    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
}