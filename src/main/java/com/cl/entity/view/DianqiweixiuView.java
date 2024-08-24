package com.cl.entity.view;

import com.cl.entity.DianqiweixiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 电器维修
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
@TableName("dianqiweixiu")
public class DianqiweixiuView  extends DianqiweixiuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DianqiweixiuView(){
	}
 
 	public DianqiweixiuView(DianqiweixiuEntity dianqiweixiuEntity){
 	try {
			BeanUtils.copyProperties(this, dianqiweixiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
