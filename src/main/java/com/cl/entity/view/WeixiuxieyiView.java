package com.cl.entity.view;

import com.cl.entity.WeixiuxieyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 维修协议
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
@TableName("weixiuxieyi")
public class WeixiuxieyiView  extends WeixiuxieyiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WeixiuxieyiView(){
	}
 
 	public WeixiuxieyiView(WeixiuxieyiEntity weixiuxieyiEntity){
 	try {
			BeanUtils.copyProperties(this, weixiuxieyiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
