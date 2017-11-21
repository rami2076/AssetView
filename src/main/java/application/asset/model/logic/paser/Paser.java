package application.asset.model.logic.paser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.supercsv.prefs.CsvPreference;

import com.github.mygreen.supercsv.io.CsvAnnotationBeanReader;

import application.asset.model.entity.Asset;
import application.asset.model.entity.CSVColumn;

public class Paser {

	//private static final String[] HEADER = new String[] { "取引番号", "取引原資産", "オプションの種類", "方向", "取引内容", "ステータス ", "購入",
	//	"ペイアウト ", "判定レート ", " 取引時間 ", " 終了時刻 " };
	//
	//	public List<String[]> opencsvToStringArray(File file) {
	//		try {
	//			// TODO reader 対策する。
	//			CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(file), "SJIS"));
	//			return reader.readAll();
	//		} catch (Exception e) {
	//			throw new RuntimeException(e);
	//		}
	//	}
/*
	public List<Asset> opencsvToBean(File file) {
		try {
			// TODO this flow property be wronging.
			// FIXME
			CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(file), "SJIS"), ',', '"', 1);
			HeaderColumnNameTranslateMappingStrategy<Asset> strat = new HeaderColumnNameTranslateMappingStrategy<>();
			//ColumnPositionMappingStrategy<Asset> strat = new ColumnPositionMappingStrategy<>();

			Map<String, String> map = createMapping();
			strat.setType(Asset.class);
			strat.setColumnMapping(map);
			CsvToBean<Asset> csv = new CsvToBean<>();
			List<Asset> assetList = csv.parse(strat, reader);
			for (Asset a : assetList) {
				System.out.println(a.getPayout());
			}
			return assetList;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}*/

	// TODO TODAYS first step
	private static Map<String, String> createMapping() {
		Map<String, String> map = new HashMap<String, String>();

		for (CSVColumn cc : CSVColumn.values()) {
			//	System.out.println(cc.getClass().getAnnotation());
			System.out.println(cc.getConstantName() + ":" + cc.getName());
			map.put(cc.getName(), cc.getConstantName());
			//変数名：csvの列名
			//map.put(cc.getConstantName(), cc.getName());
		}
		return map;
	}

	/*
	こいつも結局、列挙型クラスにすべて渡すこと。
	public void getReflectionCSVColumn() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {


		Class<?> c = Class.forName("application.model.CSVColumn");

		Object[] objects = c.getEnumConstants();

		for (Object obj :objects) {
		    Class<?> clzz = obj.getClass();
		    System.out.println(clzz.getFields()[((Enum<?>)obj).ordinal()].getName());
		}


	*/

	//参考にしたが、うまくいかなかったコード

	//	//TODO: Modify:: erorr catch statement is not readble.
	//	try {
	//		Class<?> c = Class.forName("application.model.CSVColumn");
	//
	//		Object[] objects = c.getEnumConstants();
	//		// now this is not what I want, but almost
	//		for (Object obj : objects) {
	//			try {
	//				Field keyField = obj.getClass().getDeclaredField("name");
	//				keyField.setAccessible(true); // if it is private for example.
	//				System.out.println("value : " + keyField.get(obj));
	//			} catch (NoSuchFieldException e) {
	//				// fallback to toString()
	//				System.out.println("value : " + obj);
	//			} catch (IllegalArgumentException e) {
	//				System.out.println("value : " + obj);
	//			} catch (IllegalAccessException e) {
	//				System.out.println("value : " + obj);
	//			}
	//		}
	//	} catch (ClassNotFoundException e) {
	//		e.printStackTrace();
	//	}
	//
	public  List<Asset> supercsvannotationToBean(File file) {
		try {
			CsvAnnotationBeanReader<Asset> csvReader = new CsvAnnotationBeanReader<>(
					Asset.class, new InputStreamReader(new FileInputStream(file), "SJIS"),
					CsvPreference.STANDARD_PREFERENCE);
			List<Asset> list = new ArrayList<Asset>();
			Asset menber = null;
			csvReader.getHeader(false);
			while ((menber = csvReader.read()) != null) {
				list.add(menber);
			}

			csvReader.close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {

		}

	}
}
