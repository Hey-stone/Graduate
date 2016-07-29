/**
 * 
 */
package com.stone.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-29]
 */
@Entity
@Table(name="t_24h_aqi",catalog="wather")
public class AQI_24H implements Serializable{
	
	private static final long serialVersionUID = -5947664192307422597L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="aqi")
	private Integer aqi;
	
	@Column(name="area")
	private String area;
	
	@Column(name="co")
	private Double co;
	
	@Column(name="co_24h")
	private Double co_24h;
	
	@Column(name="no2")
	private Double no2;
	
	@Column(name="no2_24h")
	private Double no2_24h;
	
	@Column(name="o3")
	private Double o3;
	
	@Column(name="o3_24h")
	private Double o3_24h;
	
	@Column(name="o3_8h")
	private Double o3_8h;
	
	@Column(name="o3_8h_24h")
	private Double o3_8h_24h;
	
	@Column(name="pm10")
	private Double pm10;
	
	@Column(name="pm10_24h")
	private Double pm10_24h;
	
	@Column(name="pm2_5")
	private Double pm2_5;
	
	@Column(name="pm2_5_24h")
	private Double pm2_5_24h;
	
	@Column(name="level")
	private String level; 
	
	@Column(name="primary_pollutant")
	private String primary_pollutant;
	
	@Column(name="quality")
	private String quality;
	
	@Column(name="so2")
	private Double so2;
	
	@Column(name="so2_24h")
	private Double so2_24h;
	
	@Column(name="time_point")
	private Timestamp time_point;
	
	@Column(name="create_time")
	private Timestamp create_time;

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
	 * @return the aqi
	 */
	public Integer getAqi() {
		return aqi;
	}

	/**
	 * @param aqi the aqi to set
	 */
	public void setAqi(Integer aqi) {
		this.aqi = aqi;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the co
	 */
	public Double getCo() {
		return co;
	}

	/**
	 * @param co the co to set
	 */
	public void setCo(Double co) {
		this.co = co;
	}

	/**
	 * @return the co_24h
	 */
	public Double getCo_24h() {
		return co_24h;
	}

	/**
	 * @param co_24h the co_24h to set
	 */
	public void setCo_24h(Double co_24h) {
		this.co_24h = co_24h;
	}

	/**
	 * @return the no2
	 */
	public Double getNo2() {
		return no2;
	}

	/**
	 * @param no2 the no2 to set
	 */
	public void setNo2(Double no2) {
		this.no2 = no2;
	}

	/**
	 * @return the no2_24h
	 */
	public Double getNo2_24h() {
		return no2_24h;
	}

	/**
	 * @param no2_24h the no2_24h to set
	 */
	public void setNo2_24h(Double no2_24h) {
		this.no2_24h = no2_24h;
	}

	/**
	 * @return the o3
	 */
	public Double getO3() {
		return o3;
	}

	/**
	 * @param o3 the o3 to set
	 */
	public void setO3(Double o3) {
		this.o3 = o3;
	}

	/**
	 * @return the o3_24h
	 */
	public Double getO3_24h() {
		return o3_24h;
	}

	/**
	 * @param o3_24h the o3_24h to set
	 */
	public void setO3_24h(Double o3_24h) {
		this.o3_24h = o3_24h;
	}

	/**
	 * @return the o3_8h
	 */
	public Double getO3_8h() {
		return o3_8h;
	}

	/**
	 * @param o3_8h the o3_8h to set
	 */
	public void setO3_8h(Double o3_8h) {
		this.o3_8h = o3_8h;
	}

	/**
	 * @return the o3_8h_24h
	 */
	public Double getO3_8h_24h() {
		return o3_8h_24h;
	}

	/**
	 * @param o3_8h_24h the o3_8h_24h to set
	 */
	public void setO3_8h_24h(Double o3_8h_24h) {
		this.o3_8h_24h = o3_8h_24h;
	}

	/**
	 * @return the pm10
	 */
	public Double getPm10() {
		return pm10;
	}

	/**
	 * @param pm10 the pm10 to set
	 */
	public void setPm10(Double pm10) {
		this.pm10 = pm10;
	}

	/**
	 * @return the pm10_24h
	 */
	public Double getPm10_24h() {
		return pm10_24h;
	}

	/**
	 * @param pm10_24h the pm10_24h to set
	 */
	public void setPm10_24h(Double pm10_24h) {
		this.pm10_24h = pm10_24h;
	}

	/**
	 * @return the pm2_5
	 */
	public Double getPm2_5() {
		return pm2_5;
	}

	/**
	 * @param pm2_5 the pm2_5 to set
	 */
	public void setPm2_5(Double pm2_5) {
		this.pm2_5 = pm2_5;
	}

	/**
	 * @return the pm2_5_24h
	 */
	public Double getPm2_5_24h() {
		return pm2_5_24h;
	}

	/**
	 * @param pm2_5_24h the pm2_5_24h to set
	 */
	public void setPm2_5_24h(Double pm2_5_24h) {
		this.pm2_5_24h = pm2_5_24h;
	}

	
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the primary_pollutant
	 */
	public String getPrimary_pollutant() {
		return primary_pollutant;
	}

	/**
	 * @param primary_pollutant the primary_pollutant to set
	 */
	public void setPrimary_pollutant(String primary_pollutant) {
		this.primary_pollutant = primary_pollutant;
	}

	/**
	 * @return the quality
	 */
	public String getQuality() {
		return quality;
	}

	/**
	 * @param quality the quality to set
	 */
	public void setQuality(String quality) {
		this.quality = quality;
	}

	/**
	 * @return the so2
	 */
	public Double getSo2() {
		return so2;
	}

	/**
	 * @param so2 the so2 to set
	 */
	public void setSo2(Double so2) {
		this.so2 = so2;
	}

	/**
	 * @return the so2_24h
	 */
	public Double getSo2_24h() {
		return so2_24h;
	}

	/**
	 * @param so2_24h the so2_24h to set
	 */
	public void setSo2_24h(Double so2_24h) {
		this.so2_24h = so2_24h;
	}


	/**
	 * @return the time_point
	 */
	public Timestamp getTime_point() {
		return time_point;
	}

	/**
	 * @param time_point the time_point to set
	 */
	public void setTime_point(Timestamp time_point) {
		this.time_point = time_point;
	}
	
	
	/**
	 * @return the create_time
	 */
	public Timestamp getCreate_time() {
		return create_time;
	}

	/**
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	/**
	 * 
	 */
	public AQI_24H() {
		super();
	}

	/**
	 * @param id
	 * @param aqi
	 * @param area
	 * @param co
	 * @param co_24h
	 * @param no2
	 * @param no2_24h
	 * @param o3
	 * @param o3_24h
	 * @param o3_8h
	 * @param o3_8h_24h
	 * @param pm10
	 * @param pm10_24h
	 * @param pm2_5
	 * @param pm2_5_24h
	 * @param level
	 * @param primary_pollutant
	 * @param quality
	 * @param so2
	 * @param so2_24h
	 * @param time_point
	 * @param create_time
	 */
	public AQI_24H(Integer id, Integer aqi, String area, Double co,
			Double co_24h, Double no2, Double no2_24h, Double o3,
			Double o3_24h, Double o3_8h, Double o3_8h_24h, Double pm10,
			Double pm10_24h, Double pm2_5, Double pm2_5_24h, String level,
			String primary_pollutant, String quality, Double so2,
			Double so2_24h, Timestamp time_point, Timestamp create_time) {
		super();
		this.id = id;
		this.aqi = aqi;
		this.area = area;
		this.co = co;
		this.co_24h = co_24h;
		this.no2 = no2;
		this.no2_24h = no2_24h;
		this.o3 = o3;
		this.o3_24h = o3_24h;
		this.o3_8h = o3_8h;
		this.o3_8h_24h = o3_8h_24h;
		this.pm10 = pm10;
		this.pm10_24h = pm10_24h;
		this.pm2_5 = pm2_5;
		this.pm2_5_24h = pm2_5_24h;
		this.level = level;
		this.primary_pollutant = primary_pollutant;
		this.quality = quality;
		this.so2 = so2;
		this.so2_24h = so2_24h;
		this.time_point = time_point;
		this.create_time = create_time;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AQI_24H [id=" + id + ", aqi=" + aqi + ", area=" + area
				+ ", co=" + co + ", co_24h=" + co_24h + ", no2=" + no2
				+ ", no2_24h=" + no2_24h + ", o3=" + o3 + ", o3_24h=" + o3_24h
				+ ", o3_8h=" + o3_8h + ", o3_8h_24h=" + o3_8h_24h + ", pm10="
				+ pm10 + ", pm10_24h=" + pm10_24h + ", pm2_5=" + pm2_5
				+ ", pm2_5_24h=" + pm2_5_24h + ", level=" + level
				+ ", primary_pollutant=" + primary_pollutant + ", quality="
				+ quality + ", so2=" + so2 + ", so2_24h=" + so2_24h
				+ ", time_point=" + time_point + ", create_time=" + create_time
				+ "]";
	}

	
	

}
