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

import com.cl.entity.DianqiweixiuEntity;
import com.cl.entity.view.DianqiweixiuView;

import com.cl.service.DianqiweixiuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 电器维修
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
@RestController
@RequestMapping("/dianqiweixiu")
public class DianqiweixiuController {
    @Autowired
    private DianqiweixiuService dianqiweixiuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DianqiweixiuEntity dianqiweixiu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dianqiweixiu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DianqiweixiuEntity> ew = new EntityWrapper<DianqiweixiuEntity>();

		PageUtils page = dianqiweixiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianqiweixiu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DianqiweixiuEntity dianqiweixiu, 
		HttpServletRequest request){
        EntityWrapper<DianqiweixiuEntity> ew = new EntityWrapper<DianqiweixiuEntity>();

		PageUtils page = dianqiweixiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianqiweixiu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DianqiweixiuEntity dianqiweixiu){
       	EntityWrapper<DianqiweixiuEntity> ew = new EntityWrapper<DianqiweixiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dianqiweixiu, "dianqiweixiu")); 
        return R.ok().put("data", dianqiweixiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DianqiweixiuEntity dianqiweixiu){
        EntityWrapper< DianqiweixiuEntity> ew = new EntityWrapper< DianqiweixiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dianqiweixiu, "dianqiweixiu")); 
		DianqiweixiuView dianqiweixiuView =  dianqiweixiuService.selectView(ew);
		return R.ok("查询电器维修成功").put("data", dianqiweixiuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DianqiweixiuEntity dianqiweixiu = dianqiweixiuService.selectById(id);
		dianqiweixiu = dianqiweixiuService.selectView(new EntityWrapper<DianqiweixiuEntity>().eq("id", id));
        return R.ok().put("data", dianqiweixiu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DianqiweixiuEntity dianqiweixiu = dianqiweixiuService.selectById(id);
		dianqiweixiu = dianqiweixiuService.selectView(new EntityWrapper<DianqiweixiuEntity>().eq("id", id));
        return R.ok().put("data", dianqiweixiu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DianqiweixiuEntity dianqiweixiu, HttpServletRequest request){
    	dianqiweixiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianqiweixiu);
        dianqiweixiuService.insert(dianqiweixiu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DianqiweixiuEntity dianqiweixiu, HttpServletRequest request){
    	dianqiweixiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianqiweixiu);
        dianqiweixiuService.insert(dianqiweixiu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DianqiweixiuEntity dianqiweixiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dianqiweixiu);
        dianqiweixiuService.updateById(dianqiweixiu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dianqiweixiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
