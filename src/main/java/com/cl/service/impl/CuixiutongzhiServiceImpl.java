package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.CuixiutongzhiDao;
import com.cl.entity.CuixiutongzhiEntity;
import com.cl.service.CuixiutongzhiService;
import com.cl.entity.view.CuixiutongzhiView;

@Service("cuixiutongzhiService")
public class CuixiutongzhiServiceImpl extends ServiceImpl<CuixiutongzhiDao, CuixiutongzhiEntity> implements CuixiutongzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CuixiutongzhiEntity> page = this.selectPage(
                new Query<CuixiutongzhiEntity>(params).getPage(),
                new EntityWrapper<CuixiutongzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CuixiutongzhiEntity> wrapper) {
		  Page<CuixiutongzhiView> page =new Query<CuixiutongzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<CuixiutongzhiView> selectListView(Wrapper<CuixiutongzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CuixiutongzhiView selectView(Wrapper<CuixiutongzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
