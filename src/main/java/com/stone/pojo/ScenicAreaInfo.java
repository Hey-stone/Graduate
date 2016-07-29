/**
 * 
 */
package com.stone.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-26]
 * <景点地区>
 */
public class ScenicAreaInfo implements Serializable{

	private static final long serialVersionUID = -1666727592688366652L;
	
	@Id
	@Column(name="ID")
	private String ID; //城市编码
	
	@Column(name="scenic_name")
	private String scenic_name;//景点名称
	
	@Column(name="city")
	private String city; //地区 (景点所在地区)
	
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
	 * @return the scenic_name
	 */
	public String getScenic_name() {
		return scenic_name;
	}

	/**
	 * @param scenic_name the scenic_name to set
	 */
	public void setScenic_name(String scenic_name) {
		this.scenic_name = scenic_name;
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
		return "ScenicAreaInfo [ID=" + ID + ", scenic_name=" + scenic_name
				+ ", city=" + city + ", province=" + province + "]";
	}
	
	

}
