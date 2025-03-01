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

import com.cl.entity.HetongxinxiEntity;
import com.cl.entity.view.HetongxinxiView;

import com.cl.service.HetongxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 合同信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-13 19:55:32
 */
@RestController
@RequestMapping("/hetongxinxi")
public class HetongxinxiController {
    @Autowired
    private HetongxinxiService hetongxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HetongxinxiEntity hetongxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			hetongxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("fangdong")) {
			hetongxinxi.setFangdongzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HetongxinxiEntity> ew = new EntityWrapper<HetongxinxiEntity>();

		PageUtils page = hetongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hetongxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HetongxinxiEntity hetongxinxi, 
		HttpServletRequest request){
        EntityWrapper<HetongxinxiEntity> ew = new EntityWrapper<HetongxinxiEntity>();

		PageUtils page = hetongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hetongxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HetongxinxiEntity hetongxinxi){
       	EntityWrapper<HetongxinxiEntity> ew = new EntityWrapper<HetongxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( hetongxinxi, "hetongxinxi")); 
        return R.ok().put("data", hetongxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HetongxinxiEntity hetongxinxi){
        EntityWrapper< HetongxinxiEntity> ew = new EntityWrapper< HetongxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( hetongxinxi, "hetongxinxi")); 
		HetongxinxiView hetongxinxiView =  hetongxinxiService.selectView(ew);
		return R.ok("查询合同信息成功").put("data", hetongxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HetongxinxiEntity hetongxinxi = hetongxinxiService.selectById(id);
		hetongxinxi = hetongxinxiService.selectView(new EntityWrapper<HetongxinxiEntity>().eq("id", id));
        return R.ok().put("data", hetongxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HetongxinxiEntity hetongxinxi = hetongxinxiService.selectById(id);
		hetongxinxi = hetongxinxiService.selectView(new EntityWrapper<HetongxinxiEntity>().eq("id", id));
        return R.ok().put("data", hetongxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HetongxinxiEntity hetongxinxi, HttpServletRequest request){
    	hetongxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(hetongxinxi);
        hetongxinxiService.insert(hetongxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HetongxinxiEntity hetongxinxi, HttpServletRequest request){
    	hetongxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(hetongxinxi);
        hetongxinxiService.insert(hetongxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HetongxinxiEntity hetongxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(hetongxinxi);
        hetongxinxiService.updateById(hetongxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        hetongxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<HetongxinxiEntity> wrapper = new EntityWrapper<HetongxinxiEntity>();
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

		int count = hetongxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	








}
