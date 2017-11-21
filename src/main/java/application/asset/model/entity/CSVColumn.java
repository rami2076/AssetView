package application.asset.model.entity;

public enum CSVColumn {
		tradingNumber("取引番号"),
		underlying("取引原資産"),
		option("オプションの種類"),
		direction("方向"),
		tradeRate("取引内容"),
		tradeStatics("ステータス"),
		purchase("購入"),
		payout("ペイアウト"),
		decisionRate("判定レート"),
		tradeStartTime("取引時間"),
		tradeEndTime("終了時刻");
		private final String name;

		private CSVColumn(final String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public String getConstantName(){
			return this.getClass().getFields()[this.ordinal()].getName();
		}
	}

