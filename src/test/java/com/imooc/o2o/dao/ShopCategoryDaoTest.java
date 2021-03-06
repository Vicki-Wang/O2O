package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest {

	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Test
	public void testQueryShopCategory() {
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
		assertEquals(2, shopCategoryList.size());
		ShopCategory testShopCategory = new ShopCategory();
		ShopCategory parentShopCategory = new ShopCategory();
		testShopCategory.setShopCategoryId(1L);
		parentShopCategory.setParent(testShopCategory);
		shopCategoryList = shopCategoryDao.queryShopCategory(parentShopCategory);
		assertEquals(1, shopCategoryList.size());
	}

}
