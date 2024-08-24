package com.cl.dao;

import com.cl.entity.CuixiutongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CuixiutongzhiView;


/**
 * 催修通知
 * 
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
public interface CuixiutongzhiDao extends BaseMapper<CuixiutongzhiEntity> {
	
	List<CuixiutongzhiView> selectListView(@Param("ew") Wrapper<CuixiutongzhiEntity> wrapper);

	List<CuixiutongzhiView> selectListView(Pagination page,@Param("ew") Wrapper<CuixiutongzhiEntity> wrapper);
	
	CuixiutongzhiView selectView(@Param("ew") Wrapper<CuixiutongzhiEntity> wrapper);
	

}
