package com.cl.dao;

import com.cl.entity.DianqiweixiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DianqiweixiuView;


/**
 * 电器维修
 * 
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
public interface DianqiweixiuDao extends BaseMapper<DianqiweixiuEntity> {
	
	List<DianqiweixiuView> selectListView(@Param("ew") Wrapper<DianqiweixiuEntity> wrapper);

	List<DianqiweixiuView> selectListView(Pagination page,@Param("ew") Wrapper<DianqiweixiuEntity> wrapper);
	
	DianqiweixiuView selectView(@Param("ew") Wrapper<DianqiweixiuEntity> wrapper);
	

}
