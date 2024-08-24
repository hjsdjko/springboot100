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


import com.cl.dao.DianqiweixiuDao;
import com.cl.entity.DianqiweixiuEntity;
import com.cl.service.DianqiweixiuService;
import com.cl.entity.view.DianqiweixiuView;

@Service("dianqiweixiuService")
public class DianqiweixiuServiceImpl extends ServiceImpl<DianqiweixiuDao, DianqiweixiuEntity> implements DianqiweixiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DianqiweixiuEntity> page = this.selectPage(
                new Query<DianqiweixiuEntity>(params).getPage(),
                new EntityWrapper<DianqiweixiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DianqiweixiuEntity> wrapper) {
		  Page<DianqiweixiuView> page =new Query<DianqiweixiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DianqiweixiuView> selectListView(Wrapper<DianqiweixiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DianqiweixiuView selectView(Wrapper<DianqiweixiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
