package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 电器维修
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-13 19:55:33
 */
@TableName("dianqiweixiu")
public class DianqiweixiuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DianqiweixiuEntity() {
		
	}
	
	public DianqiweixiuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 协议编号
	 */
					
	private String xieyibianhao;
	
	/**
	 * 协议名称
	 */
					
	private String xieyimingcheng;
	
	/**
	 * 上传图片
	 */
					
	private String shangchuantupian;
	
	/**
	 * 电器名称
	 */
					
	private String dianqimingcheng;
	
	/**
	 * 申请维修内容
	 */
					
	private String shenqingweixiuneirong;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：协议编号
	 */
	public void setXieyibianhao(String xieyibianhao) {
		this.xieyibianhao = xieyibianhao;
	}
	/**
	 * 获取：协议编号
	 */
	public String getXieyibianhao() {
		return xieyibianhao;
	}
	/**
	 * 设置：协议名称
	 */
	public void setXieyimingcheng(String xieyimingcheng) {
		this.xieyimingcheng = xieyimingcheng;
	}
	/**
	 * 获取：协议名称
	 */
	public String getXieyimingcheng() {
		return xieyimingcheng;
	}
	/**
	 * 设置：上传图片
	 */
	public void setShangchuantupian(String shangchuantupian) {
		this.shangchuantupian = shangchuantupian;
	}
	/**
	 * 获取：上传图片
	 */
	public String getShangchuantupian() {
		return shangchuantupian;
	}
	/**
	 * 设置：电器名称
	 */
	public void setDianqimingcheng(String dianqimingcheng) {
		this.dianqimingcheng = dianqimingcheng;
	}
	/**
	 * 获取：电器名称
	 */
	public String getDianqimingcheng() {
		return dianqimingcheng;
	}
	/**
	 * 设置：申请维修内容
	 */
	public void setShenqingweixiuneirong(String shenqingweixiuneirong) {
		this.shenqingweixiuneirong = shenqingweixiuneirong;
	}
	/**
	 * 获取：申请维修内容
	 */
	public String getShenqingweixiuneirong() {
		return shenqingweixiuneirong;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
