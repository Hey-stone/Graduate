/**
 * 
 */
package com.stone.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-16]
 */
@Entity
@Table(name="history_wather",catalog="wather")
public class HistoryWather implements Serializable{
	
	private static final long serialVersionUID = 1318986334718865659L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="maxtemperature")
	private Integer maxtemperature;
	
	@Column(name="mintemperature")
	private Integer mintemperature;
	
	@Column(name="wather")
	private String wather;
	
	@Column(name="wind_direction")
	private String wind_direction;
	
	@Column(name="wind_power")
	private String wind_power;
	
	@Column(name="city_name")
	private String city_name;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the maxtemperature
	 */
	public Integer getMaxtemperature() {
		return maxtemperature;
	}

	/**
	 * @param maxtemperature the maxtemperature to set
	 */
	public void setMaxtemperature(Integer maxtemperature) {
		this.maxtemperature = maxtemperature;
	}

	/**
	 * @return the mintemperature
	 */
	public Integer getMintemperature() {
		return mintemperature;
	}

	/**
	 * @param mintemperature the mintemperature to set
	 */
	public void setMintemperature(Integer mintemperature) {
		this.mintemperature = mintemperature;
	}

	/**
	 * @return the wather
	 */
	public String getWather() {
		return wather;
	}

	/**
	 * @param wather the wather to set
	 */
	public void setWather(String wather) {
		this.wather = wather;
	}

	/**
	 * @return the wind_direction
	 */
	public String getWind_direction() {
		return wind_direction;
	}

	/**
	 * @param wind_direction the wind_direction to set
	 */
	public void setWind_direction(String wind_direction) {
		this.wind_direction = wind_direction;
	}

	/**
	 * @return the wind_power
	 */
	public String getWind_power() {
		return wind_power;
	}

	/**
	 * @param wind_power the wind_power to set
	 */
	public void setWind_power(String wind_power) {
		this.wind_power = wind_power;
	}

	/**
	 * @return the city_name
	 */
	public String getCity_name() {
		return city_name;
	}

	/**
	 * @param city_name the city_name to set
	 */
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HistoryWather [id=" + id + ", date=" + date
				+ ", maxtemperature=" + maxtemperature + ", mintemperature="
				+ mintemperature + ", wather=" + wather + ", wind_direction="
				+ wind_direction + ", wind_power=" + wind_power
				+ ", city_name=" + city_name + "]";
	}

	/**
	 * @param id
	 * @param date
	 * @param maxtemperature
	 * @param mintemperature
	 * @param wather
	 * @param wind_direction
	 * @param wind_power
	 * @param city_name
	 */
	public HistoryWather(Integer id, String date, Integer maxtemperature,
			Integer mintemperature, String wather, String wind_direction,
			String wind_power, String city_name) {
		super();
		this.id = id;
		this.date = date;
		this.maxtemperature = maxtemperature;
		this.mintemperature = mintemperature;
		this.wather = wather;
		this.wind_direction = wind_direction;
		this.wind_power = wind_power;
		this.city_name = city_name;
	}

	/**
	 * 
	 */
	public HistoryWather() {
		super();
	}
	
	

}
