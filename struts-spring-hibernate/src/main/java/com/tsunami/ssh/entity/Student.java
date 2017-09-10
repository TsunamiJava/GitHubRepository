package com.tsunami.ssh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@Column(name="stu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stu_id;
	@Column(name="stu_name")
	private String stu_name;
	@Column(name="stu_age")
	private int stu_age;
	@Column(name="stu_sex")
	private int stu_sex;
	@Column(name="stu_num")
	private String stu_num;
	@Column(name="stu_class")
	private String stu_class;
	@Column(name="stu_createtime")
	private Date stu_createtime;
	@Column(name="stu_updatetime")
	private Date stu_updatetime;

	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public int getStu_age() {
		return stu_age;
	}
	public void setStu_age(int stu_age) {
		this.stu_age = stu_age;
	}
	public int getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(int stu_sex) {
		this.stu_sex = stu_sex;
	}
	public String getStu_num() {
		return stu_num;
	}
	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}
	public String getStu_class() {
		return stu_class;
	}
	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}
	public Date getStu_createtime() {
		return stu_createtime;
	}
	public void setStu_createtime(Date stu_createtime) {
		this.stu_createtime = stu_createtime;
	}
	
	public Date getStu_updatetime() {
		return stu_updatetime;
	}
	public void setStu_updatetime(Date stu_updatetime) {
		this.stu_updatetime = stu_updatetime;
	}
	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", stu_name=" + stu_name
				+ ", stu_age=" + stu_age + ", stu_sex=" + stu_sex
				+ ", stu_num=" + stu_num + ", stu_class=" + stu_class
				+ ", stu_createtime=" + stu_createtime + ", stu_updatetime="
				+ stu_updatetime + "]";
	}
	
}
