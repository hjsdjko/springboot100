package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WeixiuxieyiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiuxieyiView;


/**
 * 维修协议
 *
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
public interface WeixiuxieyiService extends IService<WeixiuxieyiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiuxieyiView> selectListView(Wrapper<WeixiuxieyiEntity> wrapper);
   	
   	WeixiuxieyiView selectView(@Param("ew") Wrapper<WeixiuxieyiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiuxieyiEntity> wrapper);
   	

}

