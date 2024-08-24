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


import com.cl.dao.WeixiuxieyiDao;
import com.cl.entity.WeixiuxieyiEntity;
import com.cl.service.WeixiuxieyiService;
import com.cl.entity.view.WeixiuxieyiView;

@Service("weixiuxieyiService")
public class WeixiuxieyiServiceImpl extends ServiceImpl<WeixiuxieyiDao, WeixiuxieyiEntity> implements WeixiuxieyiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiuxieyiEntity> page = this.selectPage(
                new Query<WeixiuxieyiEntity>(params).getPage(),
                new EntityWrapper<WeixiuxieyiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiuxieyiEntity> wrapper) {
		  Page<WeixiuxieyiView> page =new Query<WeixiuxieyiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WeixiuxieyiView> selectListView(Wrapper<WeixiuxieyiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiuxieyiView selectView(Wrapper<WeixiuxieyiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
