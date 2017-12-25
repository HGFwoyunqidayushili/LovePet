package jiyun.com.lovepet.entity;

public class Holiday {

	private Integer id; // 节假日编�??
	private String createTime; // 创建时间
	private String holidaysCode; // 节假日码
	private String holidaysName; // 节假日名�??
	private String beginTime; // �??始时�??
	private String endTime; // 结束时间
	private Integer state; // 状�??

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getHolidaysCode() {
		return holidaysCode;
	}

	public void setHolidaysCode(String holidaysCode) {
		this.holidaysCode = holidaysCode;
	}

	public String getHolidaysName() {
		return holidaysName;
	}

	public void setHolidaysName(String holidaysName) {
		this.holidaysName = holidaysName;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}