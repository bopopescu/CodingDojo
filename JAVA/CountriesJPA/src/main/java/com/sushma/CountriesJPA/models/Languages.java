package com.sushma.CountriesJPA.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Languages {
    @Id
    @GeneratedValue
    private Long id;
    private String country_code;
    private String language;
    private String is_offical;
    private Float percentage;
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country_id")
    private Countries country;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getIs_offical() {
		return is_offical;
	}
	public void setIs_offical(String is_offical) {
		this.is_offical = is_offical;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	public Countries getCountry() {
		return country;
	}
	public void setCountry(Countries country) {
		this.country = country;
	}
    
}
