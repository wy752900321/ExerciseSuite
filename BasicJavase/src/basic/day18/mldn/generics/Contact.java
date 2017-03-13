package basic.day18.mldn.generics;

public class Contact implements Info9{//实现Info9接口
	private String address;//联系地址
	private String telphone;//联系方式
	private String zipcode;//邮政编码
	public Contact(String address, String telphone, String zipcode) {
		this.setAddress(address);
		this.setTelphone(telphone);
		this.setZipcode(zipcode);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "联系方式："+"\n"+
		"\t|-联系电话："+this.telphone+"\n"+
		"\t|-联系地址："+this.address+"\n"+
		"\t|-邮政编码："+this.zipcode;//返回的信息
	}
	
}
