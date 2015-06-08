/**
 * 
 */
package com.fz.util;

import org.apache.hadoop.conf.Configuration;

/**
 * Hadoop 工具类
 * @author fansy
 * @date 2015-5-28
 */
public class HUtils {

	private static Configuration conf = null;
	
	public static boolean flag = false; // get configuration from db or file  ,true : db,false:file
	
	public static Configuration getConf(){
		
		if(conf ==null){
			conf = new Configuration ();
			if(flag){// get configuration from db
				conf.setBoolean("mapreduce.app-submission.cross-platform", true);// 配置使用跨平台提交任务  
				conf.set("fs.defaultFS", "hdfs://node101:8020");//指定namenode    
				conf.set("mapreduce.framework.name", "yarn");  // 指定使用yarn框架  
				conf.set("yarn.resourcemanager.address", "node101:8032"); // 指定resourcemanager  
				conf.set("yarn.resourcemanager.scheduler.address", "node101:8030");// 指定资源分配器
			}else{// get configuration from file
				conf.setBoolean("mapreduce.app-submission.cross-platform", 
						Boolean.getBoolean(Utils.getKey("mapreduce.app-submission.cross-platform")));// 配置使用跨平台提交任务  
				conf.set("fs.defaultFS", Utils.getKey("fs.defaultFS"));//指定namenode    
				conf.set("mapreduce.framework.name", Utils.getKey("mapreduce.framework.name"));  // 指定使用yarn框架  
				conf.set("yarn.resourcemanager.address", Utils.getKey("yarn.resourcemanager.address")); // 指定resourcemanager  
				conf.set("yarn.resourcemanager.scheduler.address", 
						Utils.getKey("yarn.resourcemanager.scheduler.address"));// 指定资源分配器
			}
		}
		
		return conf;
	}
	
	
}
