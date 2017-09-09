package com.tsunami.hibernatedemo.entity;

import java.util.Date;

public class Student {
	 private Integer stuId;

	    private String stuName;

	    private Integer stuAge;

	    private Integer stuSex;

	    private String stuNum;

	    private String stuClass;

	    private Date stuCreatetime;

	    private Date stuUpdatetime;

	    public Integer getStuId() {
	        return stuId;
	    }

	    public void setStuId(Integer stuId) {
	        this.stuId = stuId;
	    }

	    public String getStuName() {
	        return stuName;
	    }

	    public void setStuName(String stuName) {
	        this.stuName = stuName == null ? null : stuName.trim();
	    }

	    public Integer getStuAge() {
	        return stuAge;
	    }

	    public void setStuAge(Integer stuAge) {
	        this.stuAge = stuAge;
	    }

	    public Integer getStuSex() {
	        return stuSex;
	    }

	    public void setStuSex(Integer stuSex) {
	        this.stuSex = stuSex;
	    }

	    public String getStuNum() {
	        return stuNum;
	    }

	    public void setStuNum(String stuNum) {
	        this.stuNum = stuNum == null ? null : stuNum.trim();
	    }

	    public String getStuClass() {
	        return stuClass;
	    }

	    public void setStuClass(String stuClass) {
	        this.stuClass = stuClass == null ? null : stuClass.trim();
	    }

	    public Date getStuCreatetime() {
	        return stuCreatetime;
	    }

	    public void setStuCreatetime(Date stuCreatetime) {
	        this.stuCreatetime = stuCreatetime;
	    }

	    public Date getStuUpdatetime() {
	        return stuUpdatetime;
	    }

	    public void setStuUpdatetime(Date stuUpdatetime) {
	        this.stuUpdatetime = stuUpdatetime;
	    }

		@Override
		public String toString() {
			return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuAge="
					+ stuAge + ", stuSex=" + stuSex + ", stuNum=" + stuNum
					+ ", stuClass=" + stuClass + ", stuCreatetime=" + stuCreatetime
					+ ", stuUpdatetime=" + stuUpdatetime + "]";
		}
}
