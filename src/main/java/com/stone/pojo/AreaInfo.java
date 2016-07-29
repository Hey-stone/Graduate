/**
 * 
 */
package com.stone.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-26]
 */
@Entity
@Table(name="area_info",catalog="wather")
public class AreaInfo implements Serializable{

	private static final long serialVersionUID = 6666914145341461260L;
	
	@Id
	@Column(name="ID")
	private String ID; //城市编码
	
	@Column(name="city_pinying")
	private String citypinying;//城市拼音
	
	@Column(name="county")
	private String county;//县、市
	
	@Column(name="city")
	private String city; //城市名(省会城市名)
	
	@Column(name="province")
	private String province; //省、直辖市

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the citypinying
	 */
	public String getCitypinying() {
		return citypinying;
	}

	/**
	 * @param citypinying the citypinying to set
	 */
	public void setCitypinying(String citypinying) {
		this.citypinying = citypinying;
	}

	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AreaInfo [ID=" + ID + ", citypinying=" + citypinying
				+ ", county=" + county + ", city=" + city + ", province="
				+ province + "]";
	}

	
	
	
	

}
