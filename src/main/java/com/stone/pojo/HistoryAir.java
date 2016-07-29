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
@Table(name="history_air",catalog="wather")
public class HistoryAir implements Serializable{
	
	private static final long serialVersionUID = -8084568769680808652L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="AQI")
	private Double AQI;
	
	@Column(name="PM")
	private Double PM;
	
	@Column(name="PM10")
	private Double PM10;
	
	@Column(name="SO2")
	private Double SO2;
	
	@Column(name="CO")
	private Double CO;
	
	@Column(name="NO2")
	private Double NO2;
	
	@Column(name="O3")
	private Double O3;
	
	@Column(name="numorder")
	private Integer numorder; //排名
	
	@Column(name="air_quality")
	private String air_quality;
	
	@Column(name="city_name")
	private String city_name;
	
	@Column(name="rang")
	private String rang;
	
	@Column(name="monthofyear")
	private Integer monthofyear;
	
	@Column(name="dayofmonth")
	private Integer dayofmonth;

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
	 * @return the aQI
	 */
	public Double getAQI() {
		return AQI;
	}

	/**
	 * @param aQI the aQI to set
	 */
	public void setAQI(Double aQI) {
		AQI = aQI;
	}

	/**
	 * @return the pM
	 */
	public Double getPM() {
		return PM;
	}

	/**
	 * @param pM the pM to set
	 */
	public void setPM(Double pM) {
		PM = pM;
	}

	/**
	 * @return the pM10
	 */
	public Double getPM10() {
		return PM10;
	}

	/**
	 * @param pM10 the pM10 to set
	 */
	public void setPM10(Double pM10) {
		PM10 = pM10;
	}

	/**
	 * @return the sO2
	 */
	public Double getSO2() {
		return SO2;
	}

	/**
	 * @param sO2 the sO2 to set
	 */
	public void setSO2(Double sO2) {
		SO2 = sO2;
	}

	/**
	 * @return the cO
	 */
	public Double getCO() {
		return CO;
	}

	/**
	 * @param cO the cO to set
	 */
	public void setCO(Double cO) {
		CO = cO;
	}

	/**
	 * @return the nO2
	 */
	public Double getNO2() {
		return NO2;
	}

	/**
	 * @param nO2 the nO2 to set
	 */
	public void setNO2(Double nO2) {
		NO2 = nO2;
	}

	/**
	 * @return the o3
	 */
	public Double getO3() {
		return O3;
	}

	/**
	 * @param o3 the o3 to set
	 */
	public void setO3(Double o3) {
		O3 = o3;
	}

	/**
	 * @return the numorder
	 */
	public Integer getNumorder() {
		return numorder;
	}

	/**
	 * @param numorder the numorder to set
	 */
	public void setNumorder(Integer numorder) {
		this.numorder = numorder;
	}

	/**
	 * @return the air_quality
	 */
	public String getAir_quality() {
		return air_quality;
	}

	/**
	 * @param air_quality the air_quality to set
	 */
	public void setAir_quality(String air_quality) {
		this.air_quality = air_quality;
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

	/**
	 * @return the rang
	 */
	public String getRang() {
		return rang;
	}

	/**
	 * @param rang the rang to set
	 */
	public void setRang(String rang) {
		this.rang = rang;
	}

	/**
	 * @return the monthofyear
	 */
	public Integer getMonthofyear() {
		return monthofyear;
	}

	/**
	 * @param monthofyear the monthofyear to set
	 */
	public void setMonthofyear(Integer monthofyear) {
		this.monthofyear = monthofyear;
	}

	/**
	 * @return the dayofmonth
	 */
	public Integer getDayofmonth() {
		return dayofmonth;
	}

	/**
	 * @param dayofmonth the dayofmonth to set
	 */
	public void setDayofmonth(Integer dayofmonth) {
		this.dayofmonth = dayofmonth;
	}

	/**
	 * @param id
	 * @param date
	 * @param aQI
	 * @param pM
	 * @param pM10
	 * @param sO2
	 * @param cO
	 * @param nO2
	 * @param o3
	 * @param numorder
	 * @param air_quality
	 * @param city_name
	 * @param rang
	 * @param monthofyear
	 * @param dayofmonth
	 */
	public HistoryAir(Integer id, String date, Double aQI, Double pM, Double pM10,
			Double sO2, Double cO, Double nO2, Double o3, Integer numorder,
			String air_quality, String city_name, String rang, Integer monthofyear,
			Integer dayofmonth) {
		super();
		this.id = id;
		this.date = date;
		this.AQI = aQI;
		this.PM = pM;
		this.PM10 = pM10;
		this.SO2 = sO2;
		this.CO = cO;
		this.NO2 = nO2;
		this.O3 = o3;
		this.numorder = numorder;
		this.air_quality = air_quality;
		this.city_name = city_name;
		this.rang = rang;
		this.monthofyear = monthofyear;
		this.dayofmonth = dayofmonth;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HistoryAir [id=" + id + ", date=" + date + ", AQI=" + AQI
				+ ", PM=" + PM + ", PM10=" + PM10 + ", SO2=" + SO2 + ", CO="
				+ CO + ", NO2=" + NO2 + ", O3=" + O3 + ", numorder=" + numorder
				+ ", air_quality=" + air_quality + ", city_name=" + city_name
				+ ", rang=" + rang + ", monthofyear=" + monthofyear
				+ ", dayofmonth=" + dayofmonth + "]";
	}

	public HistoryAir() {
		super();
	}


}
