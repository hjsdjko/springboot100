package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CuixiutongzhiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CuixiutongzhiView;


/**
 * 催修通知
 *
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
public interface CuixiutongzhiService extends IService<CuixiutongzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CuixiutongzhiView> selectListView(Wrapper<CuixiutongzhiEntity> wrapper);
   	
   	CuixiutongzhiView selectView(@Param("ew") Wrapper<CuixiutongzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CuixiutongzhiEntity> wrapper);
   	

}

