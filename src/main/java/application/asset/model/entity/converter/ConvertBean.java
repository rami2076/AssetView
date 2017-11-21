package application.asset.model.entity.converter;

import java.util.ArrayList;
import java.util.List;

import application.asset.model.entity.Asset;
import application.asset.model.entity.AssetBind;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConvertBean {

	/**
	 * リストの変換
	 * assetBindList to AssetList
	 * @param assetBindList
	 * @return List<Asset>
	 */
	public List<Asset> toAssetList(List<AssetBind> assetBindList) {
		List<Asset> assetList = new ArrayList<>();
		for (AssetBind assetBind : assetBindList) {
			Asset asset = new Asset();
			asset.setTradingNumber(assetBind.getTradingNumber());
			asset.setUnderlying(assetBind.getUnderlying());
			asset.setOption(assetBind.getOption());
			asset.setDirection(assetBind.getDirection());
			asset.setTradeRate(assetBind.getTradeRate());
			asset.setTradeStatics(assetBind.getTradeStatics());
			asset.setPurchase(assetBind.getPurchase());
			asset.setPayout(assetBind.getPayout());
			asset.setDecisionRate(assetBind.getDecisionRate());
			asset.setTradeStartTime(assetBind.getTradeStartTime());
			asset.setTradeEndTime(assetBind.getTradeEndTime());
			assetList.add(asset);
		}
		return assetList;
	}

	/**
	 * assetList to assetBindList
	 * @param assetList
	 * @return
	 */
	public ObservableList<AssetBind> toAssetBindList(List<Asset> assetList) {
		ObservableList<AssetBind> assetBindList = FXCollections.observableArrayList();
		for (Asset asset : assetList) {
			Long iterate = 1L;
			//TODO pass to the iterate
			AssetBind assetBind = new AssetBind(asset,iterate);
			assetBindList.add(assetBind);
		}

		return assetBindList;
	}

    /*public static List<TeamMenber2> supercsvannotationToBean(File file) {
        try {
            CsvAnnotationBeanReader<TeamMenber2> csvReader = new CsvAnnotationBeanReader<TeamMenber2>(
                    TeamMenber2.class, new InputStreamReader(new FileInputStream(file), "SJIS"),
                    CsvPreference.STANDARD_PREFERENCE);
            List<TeamMenber2> list = new ArrayList<TeamMenber2>();
            TeamMenber2 menber = null;
            csvReader.getHeader(false);
            while ((menber = csvReader.read()) != null) {
                list.add(menber);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/





}
