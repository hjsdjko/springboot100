package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.WeixiuxieyiEntity;
import com.cl.entity.view.WeixiuxieyiView;

import com.cl.service.WeixiuxieyiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修协议
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
@RestController
@RequestMapping("/weixiuxieyi")
public class WeixiuxieyiController {
    @Autowired
    private WeixiuxieyiService weixiuxieyiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiuxieyiEntity weixiuxieyi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			weixiuxieyi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("fangdong")) {
			weixiuxieyi.setFangdongzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WeixiuxieyiEntity> ew = new EntityWrapper<WeixiuxieyiEntity>();

		PageUtils page = weixiuxieyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuxieyi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeixiuxieyiEntity weixiuxieyi, 
		HttpServletRequest request){
        EntityWrapper<WeixiuxieyiEntity> ew = new EntityWrapper<WeixiuxieyiEntity>();

		PageUtils page = weixiuxieyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuxieyi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiuxieyiEntity weixiuxieyi){
       	EntityWrapper<WeixiuxieyiEntity> ew = new EntityWrapper<WeixiuxieyiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiuxieyi, "weixiuxieyi")); 
        return R.ok().put("data", weixiuxieyiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiuxieyiEntity weixiuxieyi){
        EntityWrapper< WeixiuxieyiEntity> ew = new EntityWrapper< WeixiuxieyiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiuxieyi, "weixiuxieyi")); 
		WeixiuxieyiView weixiuxieyiView =  weixiuxieyiService.selectView(ew);
		return R.ok("查询维修协议成功").put("data", weixiuxieyiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiuxieyiEntity weixiuxieyi = weixiuxieyiService.selectById(id);
		weixiuxieyi = weixiuxieyiService.selectView(new EntityWrapper<WeixiuxieyiEntity>().eq("id", id));
        return R.ok().put("data", weixiuxieyi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiuxieyiEntity weixiuxieyi = weixiuxieyiService.selectById(id);
		weixiuxieyi = weixiuxieyiService.selectView(new EntityWrapper<WeixiuxieyiEntity>().eq("id", id));
        return R.ok().put("data", weixiuxieyi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiuxieyiEntity weixiuxieyi, HttpServletRequest request){
    	weixiuxieyi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiuxieyi);
        weixiuxieyiService.insert(weixiuxieyi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiuxieyiEntity weixiuxieyi, HttpServletRequest request){
    	weixiuxieyi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiuxieyi);
        weixiuxieyiService.insert(weixiuxieyi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeixiuxieyiEntity weixiuxieyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiuxieyi);
        weixiuxieyiService.updateById(weixiuxieyi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiuxieyiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<WeixiuxieyiEntity> wrapper = new EntityWrapper<WeixiuxieyiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("fangdong")) {
			wrapper.eq("fangdongzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = weixiuxieyiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
