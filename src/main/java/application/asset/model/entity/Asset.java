package application.asset.model.entity;

import com.github.mygreen.supercsv.annotation.CsvBean;
import com.github.mygreen.supercsv.annotation.CsvColumn;

import lombok.Data;

@Data
@CsvBean(header=true)
public class Asset {

	// 1番号ここでは定義しない。
	// 2取引番号
	// ,3取引原資産
	// ,4オプションの種類
	// ,5方向,
	// " 6取引内容 "
	// ,"7ステータス "
	// ,8購入,""
	// 9ペイアウト
	// ",10"判定レート
	// "," 11取引時間
	// "," 12終了時刻 "
	//private String iterate;

	//取引番号,取引原資産,オプションの種類,方向,取引内容,ステータス,購入,ペイアウト,判定レート,取引時間,終了時刻

	@CsvColumn(number = 1, label = "取引番号")
	private String tradingNumber;

	@CsvColumn(number = 2, label = "取引原資産")
	private String underlying;

	@CsvColumn(number = 3, label = "オプションの種類")
	private String option;

	@CsvColumn(number = 4, label = "方向")
	private String direction;

	@CsvColumn(number = 5, label = "取引内容")
	private String tradeRate;

	@CsvColumn(number = 6, label = "ステータス")
	private String tradeStatics;

	@CsvColumn(number = 7, label = "購入")
	private String purchase;

	@CsvColumn(number = 8, label = "ペイアウト")
	private String payout;

	@CsvColumn(number = 9, label = "判定レート")
	private String decisionRate;

	@CsvColumn(number = 10, label = "取引時間")
	private String tradeStartTime;

	@CsvColumn(number = 11, label = "終了時刻")
	private String tradeEndTime;

}
