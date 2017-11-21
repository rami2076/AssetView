package application.asset.model.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class AssetBind {

	private StringProperty iterate;
	private StringProperty tradingNumber;
	private StringProperty underlying;
	private StringProperty option;
	private StringProperty direction;
	private StringProperty tradeRate;
	private StringProperty tradeStatics;
	private StringProperty purchase;
	private StringProperty payout;
	private StringProperty decisionRate;
	private StringProperty tradeStartTime;
	private StringProperty tradeEndTime;


	public AssetBind() {
		this(null,null);
	}

	public AssetBind(Asset asset,Long iterate) {
		this.iterate = new SimpleStringProperty(iterate.toString());
		this.tradingNumber = new SimpleStringProperty(asset.getTradingNumber());
		this.underlying = new SimpleStringProperty(asset.getUnderlying());
		this.option = new SimpleStringProperty(asset.getOption());
		this.direction = new SimpleStringProperty(asset.getDirection());
		this.tradeRate = new SimpleStringProperty(asset.getTradeRate());
		this.tradeStatics = new SimpleStringProperty(asset.getTradeStatics());
		this.purchase = new SimpleStringProperty(asset.getPurchase());
		this.payout = new SimpleStringProperty(asset.getPayout());
		this.decisionRate = new SimpleStringProperty(asset.getDecisionRate());
		this.tradeStartTime = new SimpleStringProperty(asset.getTradeStartTime());
		this.tradeEndTime = new SimpleStringProperty(asset.getTradeEndTime());
	}


//順序
	public String getIterate() {
		return iterate.get();
	}
	public void setIterate(String iterate) {
		this.iterate.set(iterate);
	}
	public StringProperty iterateProperty(){
		return iterate;
	}


//取引番号
	public String getTradingNumber() {
		return tradingNumber.get();
	}
	public void setTradingNumber(String tradingNumber) {
		this.tradingNumber.set(tradingNumber);;
	}
	public StringProperty tradingNumberProperty(){
		return tradingNumber;
	}

	//取引原資産
	public String getUnderlying() {
		return underlying.get();
	}
	public void setUnderlying(String underlying) {
		this.underlying.set(underlying);;
	}
	public StringProperty underlyingProperty(){
		return underlying;
	}


//オプションの種類
	public String getOption() {
		return option.get();
	}
	public void setOption(String option) {
		this.option.set(option);
	}
	public StringProperty optionProperty(){
		return option;
	}


	//方向
	public String getDirection() {
		return direction.get();
	}
	public void setDirection(String direction) {
		this.direction.set(direction);
	}
	public StringProperty directionProperty() {
		return direction;
	}

	//取引内容
	public String getTradeRate() {
		return tradeRate.get();
	}
	public void setTradeRate(String tradeRate) {
		this.tradeRate.set(tradeRate);
	}
	public StringProperty tradeRateProperty(){
		return tradeRate;
	}

	//ステータス
	public String getTradeStatics() {
		return tradeStatics.get();
	}
	public void setTradeStatics(String tradeStatics) {
		this.tradeStatics.set(tradeStatics);
	}
	public StringProperty tradeStaticsProperty(){
		return tradeStatics;
	}


	//購入
	public String getPurchase() {
		return purchase.get();
	}
	public void setPurchase(String purchase) {
		this.purchase.set(purchase);
	}
	public StringProperty purchaseProperty(){
		return purchase;
	}

	//ペイアウト
	public String getPayout() {
		return payout.get();
	}
	public void setPayout(String payout) {
		this.payout.set(payout);
	}
	public StringProperty payoutProperty(){
		return payout;
	}

	//判定レート
	public String getDecisionRate() {
		return decisionRate.get();
	}
	public void setDecisionRate(String decisionRate) {
		this.decisionRate.set(decisionRate);
	}
	public StringProperty decisionRateProperty(){
		return decisionRate;
	}

	//取引時間
	public String getTradeStartTime() {
		return tradeStartTime.get();
	}
	public void setTradeStartTime(String tradeStartTime) {
		this.tradeStartTime.set(tradeStartTime);
	}
	public StringProperty tradeStartTimeProperty(){
		return tradeStartTime;
	}

	//終了時刻
	public String getTradeEndTime() {
		return tradeEndTime.get();
	}
	public void setTradeEndTime(String tradeEndTime) {
		this.tradeEndTime.set(tradeEndTime);
	}
	public StringProperty tradeEndTimeProperty(){
		return tradeEndTime;
	}









}
