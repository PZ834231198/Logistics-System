package 物流面单系统;

public class Logistics {  //物流信息类，包含各项物流信息指标，服务于其他类
	//都用了String类型，方便处理
	String logistNum;
	String netWeight;
	String roughWeight;
	String number;
	String goods;
	
	String receName;
	String recePost;
	String receAddress;
	String receTel;
	
	String sendName;
	String sendPost;
	String sendAddress;
	String sendTel;
	
	String orderNum;

	public Logistics() {
		super();
	}

	public Logistics(String logistNum, String netWeight, String roughWeight, String number, String goods,
			String receName, String recePost, String receAddress, String receTel, String sendName, String sendPost,
			String sendAddress, String sendTel, String orderNum) {
		super();
		this.logistNum = logistNum;
		this.netWeight = netWeight;
		this.roughWeight = roughWeight;
		this.number = number;
		this.goods = goods;
		this.receName = receName;
		this.recePost = recePost;
		this.receAddress = receAddress;
		this.receTel = receTel;
		this.sendName = sendName;
		this.sendPost = sendPost;
		this.sendAddress = sendAddress;
		this.sendTel = sendTel;
		this.orderNum = orderNum;
	}

	public String getLogistNum() {
		return logistNum;
	}

	public void setLogistNum(String logistNum) {
		this.logistNum = logistNum;
	}

	public String getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}

	public String getRoughWeight() {
		return roughWeight;
	}

	public void setRoughWeight(String roughWeight) {
		this.roughWeight = roughWeight;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getReceName() {
		return receName;
	}

	public void setReceName(String receName) {
		this.receName = receName;
	}

	public String getRecePost() {
		return recePost;
	}

	public void setRecePost(String recePost) {
		this.recePost = recePost;
	}

	public String getReceAddress() {
		return receAddress;
	}

	public void setReceAddress(String receAddress) {
		this.receAddress = receAddress;
	}

	public String getReceTel() {
		return receTel;
	}

	public void setReceTel(String receTel) {
		this.receTel = receTel;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getSendPost() {
		return sendPost;
	}

	public void setSendPost(String sendPost) {
		this.sendPost = sendPost;
	}

	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public String getSendTel() {
		return sendTel;
	}

	public void setSendTel(String sendTel) {
		this.sendTel = sendTel;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	public String toString() {
		return "Logistics [logistNum=" + logistNum + ", netWeight=" + netWeight + ", roughWeight=" + roughWeight
				+ ", number=" + number + ", goods=" + goods + ", receName=" + receName + ", recePost=" + recePost
				+ ", receAddress=" + receAddress + ", receTel=" + receTel + ", sendName=" + sendName + ", sendPost="
				+ sendPost + ", sendAddress=" + sendAddress + ", sendTel=" + sendTel + ", orderNum=" + orderNum + "]";
	}
	
	

}
