package com.forex.wizard.currencyExchange.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForexExchange {
	private String fromCurrencyCode;
	 private String fromCurrencyName;
	 private String toCurrencyCode;
	 private String toCurrencyName;
	 private String exchangeRate;
	 @JsonProperty("LastRefreshed") 
	 private String LastRefreshed;
	 private String timeZone;
	 private String bidPrice;
	 private String askPrice;


	 // Getter Methods 

	 public String getFromCurrencyCode() {
	  return fromCurrencyCode;
	 }

	 public String getFromCurrencyName() {
	  return fromCurrencyName;
	 }

	 public String getToCurrencyCode() {
	  return toCurrencyCode;
	 }

	 public String getToCurrencyName() {
	  return toCurrencyName;
	 }

	 public String getExchangeRate() {
	  return exchangeRate;
	 }

	 public String getLastRefreshed() {
	  return LastRefreshed;
	 }

	 public String getTimeZone() {
	  return timeZone;
	 }

	 public String getBidPrice() {
	  return bidPrice;
	 }

	 public String getAskPrice() {
	  return askPrice;
	 }

	 // Setter Methods 

	 public void setFromCurrencyCode(String fromCurrencyCode) {
	  this.fromCurrencyCode = fromCurrencyCode;
	 }

	 public void setFromCurrencyName(String fromCurrencyName) {
	  this.fromCurrencyName = fromCurrencyName;
	 }

	 public void setToCurrencyCode(String toCurrencyCode) {
	  this.toCurrencyCode = toCurrencyCode;
	 }

	 public void setToCurrencyName(String toCurrencyName) {
	  this.toCurrencyName = toCurrencyName;
	 }

	 public void setExchangeRate(String exchangeRate) {
	  this.exchangeRate = exchangeRate;
	 }

	 public void setLastRefreshed(String LastRefreshed) {
	  this.LastRefreshed = LastRefreshed;
	 }

	 public void setTimeZone(String timeZone) {
	  this.timeZone = timeZone;
	 }

	 public void setBidPrice(String bidPrice) {
	  this.bidPrice = bidPrice;
	 }

	 public void setAskPrice(String askPrice) {
	  this.askPrice = askPrice;
	 }
}