package com.jxyy.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jxyy.pojo.Dept;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//insert();
		//update();
		//delete();
		SqlSession session = null;
		try {
			//获取SqlSessionFactory，也是读取配置文件
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader("mybatis.xml"));
			//获取SqlSession，相当于jdbc中的Connection
			session = build.openSession();
			List<Dept> depts = session.selectList("com.jxyy.mapper.DeptMapper.selectDepts", null);
			for (Dept dept : depts) {
				System.out.println(dept);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(session != null){
				session.close();
			}
		}
	}

	private static void delete() {
		SqlSession session = null;
		try {
			//获取SqlSessionFactory，也是读取配置文件
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader("mybatis.xml"));
			//获取SqlSession，相当于jdbc中的Connection
			session = build.openSession();
			session.delete("com.jxyy.mapper.DeptMapper.deleteDeptByDeptno", 50);
			//提示事务
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(session != null){
				session.close();
			}
		}
	}

	private static void update() {
		SqlSession session = null;
		try {
			//获取SqlSessionFactory，也是读取配置文件
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader("mybatis.xml"));
			//获取SqlSession，相当于jdbc中的Connection
			session = build.openSession();
			Dept dept = new Dept(50, null, "南昌");
			session.update("com.jxyy.mapper.DeptMapper.updateDept", dept);
			//提示事务
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(session != null){
				session.close();
			}
		}
	}

	private static void insert() {
		SqlSession session = null;
		try {
			//获取SqlSessionFactory，也是读取配置文件
			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader("mybatis.xml"));
			//获取SqlSession，相当于jdbc中的Connection
			session = build.openSession();
			Dept dept = new Dept(50, "IT", "江西");
			session.insert("com.jxyy.mapper.DeptMapper.insertDept", dept);
			//提示事务
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(session != null){
				session.close();
			}
		}
	}
	
	

}
