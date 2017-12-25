/**  
 * @Title: Address.java
 * @Package com.qlx.thousand_miles.entity
 * @Description: TODO
 * @author cxp 
 * @date 2016�??3�??8�?? 上午11:33:15
 * @version V1.0  
 */
package jiyun.com.lovepet.entity;

import java.io.Serializable;

/**
 * @ClassName: Address
 * @Description: 城市
 * @author cxp
 * @date 2016�??3�??8�?? 上午11:33:15
 * 
 */
public class City implements Serializable {

	private String code;
	private String city;

	@Override
	public String toString() {
		return "City [code=" + code + ", city=" + city + "]";
	}

	public City() {
		super();
	}

	public City(String code, String city) {
		super();
		this.code = code;
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
