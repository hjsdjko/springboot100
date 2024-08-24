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

import com.cl.entity.CuixiutongzhiEntity;
import com.cl.entity.view.CuixiutongzhiView;

import com.cl.service.CuixiutongzhiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 催修通知
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
@RestController
@RequestMapping("/cuixiutongzhi")
public class CuixiutongzhiController {
    @Autowired
    private CuixiutongzhiService cuixiutongzhiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CuixiutongzhiEntity cuixiutongzhi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangdong")) {
			cuixiutongzhi.setFangdongzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			cuixiutongzhi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CuixiutongzhiEntity> ew = new EntityWrapper<CuixiutongzhiEntity>();

		PageUtils page = cuixiutongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cuixiutongzhi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CuixiutongzhiEntity cuixiutongzhi, 
		HttpServletRequest request){
        EntityWrapper<CuixiutongzhiEntity> ew = new EntityWrapper<CuixiutongzhiEntity>();

		PageUtils page = cuixiutongzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cuixiutongzhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CuixiutongzhiEntity cuixiutongzhi){
       	EntityWrapper<CuixiutongzhiEntity> ew = new EntityWrapper<CuixiutongzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cuixiutongzhi, "cuixiutongzhi")); 
        return R.ok().put("data", cuixiutongzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CuixiutongzhiEntity cuixiutongzhi){
        EntityWrapper< CuixiutongzhiEntity> ew = new EntityWrapper< CuixiutongzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cuixiutongzhi, "cuixiutongzhi")); 
		CuixiutongzhiView cuixiutongzhiView =  cuixiutongzhiService.selectView(ew);
		return R.ok("查询催修通知成功").put("data", cuixiutongzhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CuixiutongzhiEntity cuixiutongzhi = cuixiutongzhiService.selectById(id);
		cuixiutongzhi = cuixiutongzhiService.selectView(new EntityWrapper<CuixiutongzhiEntity>().eq("id", id));
        return R.ok().put("data", cuixiutongzhi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CuixiutongzhiEntity cuixiutongzhi = cuixiutongzhiService.selectById(id);
		cuixiutongzhi = cuixiutongzhiService.selectView(new EntityWrapper<CuixiutongzhiEntity>().eq("id", id));
        return R.ok().put("data", cuixiutongzhi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CuixiutongzhiEntity cuixiutongzhi, HttpServletRequest request){
    	cuixiutongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cuixiutongzhi);
        cuixiutongzhiService.insert(cuixiutongzhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CuixiutongzhiEntity cuixiutongzhi, HttpServletRequest request){
    	cuixiutongzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cuixiutongzhi);
        cuixiutongzhiService.insert(cuixiutongzhi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CuixiutongzhiEntity cuixiutongzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cuixiutongzhi);
        cuixiutongzhiService.updateById(cuixiutongzhi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cuixiutongzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
