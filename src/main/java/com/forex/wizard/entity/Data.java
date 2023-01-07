package com.forex.wizard.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Data {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date orderDate;
	private int msgIdOfVipChannel;
	private int msgIdOfFreeChannel;
	private String sellBuy;
	private String pair;
	private String channel;
	private String tokenNo;
	private String entryPoint;
	private String stopLoss;
	private String takeProfit;
	private String pips;
	private String status;
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Data(long id, Date orderDate, int msgIdOfVipChannel, int msgIdOfFreeChannel, String sellBuy, String pair,
			String channel, String tokenNo, String entryPoint, String stopLoss, String takeProfit, String pips,
			String status) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.msgIdOfVipChannel = msgIdOfVipChannel;
		this.msgIdOfFreeChannel = msgIdOfFreeChannel;
		this.sellBuy = sellBuy;
		this.pair = pair;
		this.channel = channel;
		this.tokenNo = tokenNo;
		this.entryPoint = entryPoint;
		this.stopLoss = stopLoss;
		this.takeProfit = takeProfit;
		this.pips = pips;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getMsgIdOfVipChannel() {
		return msgIdOfVipChannel;
	}
	public void setMsgIdOfVipChannel(int msgIdOfVipChannel) {
		this.msgIdOfVipChannel = msgIdOfVipChannel;
	}
	public int getMsgIdOfFreeChannel() {
		return msgIdOfFreeChannel;
	}
	public void setMsgIdOfFreeChannel(int msgIdOfFreeChannel) {
		this.msgIdOfFreeChannel = msgIdOfFreeChannel;
	}
	public String getSellBuy() {
		return sellBuy;
	}
	public void setSellBuy(String sellBuy) {
		this.sellBuy = sellBuy;
	}
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getTokenNo() {
		return tokenNo;
	}
	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}
	public String getEntryPoint() {
		return entryPoint;
	}
	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}
	public String getStopLoss() {
		return stopLoss;
	}
	public void setStopLoss(String stopLoss) {
		this.stopLoss = stopLoss;
	}
	public String getTakeProfit() {
		return takeProfit;
	}
	public void setTakeProfit(String takeProfit) {
		this.takeProfit = takeProfit;
	}
	public String getPips() {
		return pips;
	}
	public void setPips(String pips) {
		this.pips = pips;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", orderDate=" + orderDate + ", msgIdOfVipChannel=" + msgIdOfVipChannel
				+ ", msgIdOfFreeChannel=" + msgIdOfFreeChannel + ", sellBuy=" + sellBuy + ", pair=" + pair
				+ ", channel=" + channel + ", tokenNo=" + tokenNo + ", entryPoint=" + entryPoint + ", stopLoss="
				+ stopLoss + ", takeProfit=" + takeProfit + ", pips=" + pips + ", status=" + status + "]";
	}
	
	
}
