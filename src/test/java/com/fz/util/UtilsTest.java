/**
 * 
 */
package com.fz.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.fz.dao.BaseDao;
import com.fz.model.HConstants;

/**
 * @author fansy
 * @date 2015-6-8
 */
public class UtilsTest {

	private BaseDao<HConstants> baseDao=null;

	public static void main(String[] args) {
		UtilsTest ut = new UtilsTest();
		ut.testHConstantsWrite2DB();
	}
	
	/**
	 * Utils 获得key
	 */
	public static void testGetKey(){
		String key = "fs.defaultFS";
		System.out.println(Utils.getKey(key));
	}
	/**
	 * hadoop 常量写入数据库
	 * 测试失败2015/6/8 23:29
	 */
	public  void testHConstantsWrite2DB(){
		List<HConstants> lists= new ArrayList<HConstants>();
		lists.add(new HConstants("mapreduce.app-submission.cross-platform", "true"));
		lists.add(new HConstants("fs.defaultFS", "hdfs://node101:8020"));
		lists.add(new HConstants("mapreduce.framework.name", "yarn"));
		lists.add(new HConstants("yarn.resourcemanager.address", "node101:8032"));
		lists.add(new HConstants("yarn.resourcemanager.scheduler.address", "node101:8030"));
		if(baseDao==null){
			baseDao=(BaseDao)SpringUtil.getBeanById("baseDao");
		}
		int ret = baseDao.saveBatch(lists);
		System.out.println(new java.util.Date()+"：HConstants 插入了"+ret+"条记录！");
	}
	
	/**
	 * @return the baseDao
	 */
	public BaseDao<HConstants> getBaseDao() {
		return baseDao;
	}

	/**
	 * @param baseDao the baseDao to set
	 */
	public void setBaseDao(BaseDao<HConstants> baseDao) {
		this.baseDao = baseDao;
	}
}
