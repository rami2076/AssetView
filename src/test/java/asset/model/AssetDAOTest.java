package asset.model;

import static org.junit.Assert.*;

import org.junit.Test;

import application.asset.model.dao.AssetDAO;

public class AssetDAOTest {

	@Test
	public void test() {
		//fail("まだ実装されていません");
		AssetDAO a = new AssetDAO();
		assertEquals(a.connect(), true);
	}

}
