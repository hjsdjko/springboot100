package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DianqiweixiuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DianqiweixiuView;


/**
 * 电器维修
 *
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
public interface DianqiweixiuService extends IService<DianqiweixiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianqiweixiuView> selectListView(Wrapper<DianqiweixiuEntity> wrapper);
   	
   	DianqiweixiuView selectView(@Param("ew") Wrapper<DianqiweixiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianqiweixiuEntity> wrapper);
   	

}

