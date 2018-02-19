package dk.tec;

public class Device 
{
	
	private int pID;
	private String brandStr;
	private String modelStr;
	private String roomLocationStr;
	private String deviceTypeStr;
	
	public Device() {}
	public Device(String b, String m, String r, String d) {
		setBrandStr(b);
		setModelStr(m);
		setRoomLocationStr(r);
		setDeviceTypeStr(d);
	}
	
	//Getter and Setters
	
	public String getBrandStr() {
		return brandStr;
	}
	public void setBrandStr(String brandStr) {
		this.brandStr = brandStr;
	}
	public String getModelStr() {
		return modelStr;
	}
	public void setModelStr(String modelStr) {
		this.modelStr = modelStr;
	}
	public String getRoomLocationStr() {
		return roomLocationStr;
	}
	public void setRoomLocationStr(String roomLocationStr) {
		this.roomLocationStr = roomLocationStr;
	}
	public String getDeviceTypeStr() {
		return deviceTypeStr;
	}
	public void setDeviceTypeStr(String deviceTypeStr) {
		this.deviceTypeStr = deviceTypeStr;
	}
	public int getpID() {
		return pID;
	}
	public void setpID(int pID) {
		this.pID = pID;
	}

	
//	@Override
//	public String toString()
//	{
//		return String.format("Brand: %1$s Model: %2$s  Room: %3$s Device: %4$s", this.brandStr, this.modelStr, this.roomLocationStr, this.deviceTypeStr);
//	}
	
	
}
