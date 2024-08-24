package com.cl.dao;

import com.cl.entity.WeixiuxieyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiuxieyiView;


/**
 * 维修协议
 * 
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
public interface WeixiuxieyiDao extends BaseMapper<WeixiuxieyiEntity> {
	
	List<WeixiuxieyiView> selectListView(@Param("ew") Wrapper<WeixiuxieyiEntity> wrapper);

	List<WeixiuxieyiView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiuxieyiEntity> wrapper);
	
	WeixiuxieyiView selectView(@Param("ew") Wrapper<WeixiuxieyiEntity> wrapper);
	

}
