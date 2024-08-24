package com.cl.entity.view;

import com.cl.entity.CuixiutongzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 催修通知
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
@TableName("cuixiutongzhi")
public class CuixiutongzhiView  extends CuixiutongzhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CuixiutongzhiView(){
	}
 
 	public CuixiutongzhiView(CuixiutongzhiEntity cuixiutongzhiEntity){
 	try {
			BeanUtils.copyProperties(this, cuixiutongzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
