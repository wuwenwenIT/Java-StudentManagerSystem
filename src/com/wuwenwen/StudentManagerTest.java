package com.wuwenwen;

import java.util.ArrayList;
import java.util.Scanner;

/*
  *  这是我的学生管理系统的主类型 
 * 步骤如下：
 * 1.定义学生类
 * 2.主界面编写
 * 3.查看功能编写
 * 4.添加功能编写
 * 5.删除功能编写
 * 6.修改功能编写
 */
public class StudentManagerTest {
	public static void main(String[] args) {
		//创建集合对象，用以存储数据
		ArrayList<Student> arr = new ArrayList<Student>();
		

		//学生管理系统主界面
		System.out.println("--------欢迎来到学生管理系统--------");
		System.out.println("1.查看");
		System.out.println("2.添加学生");
		System.out.println("3.删除学生");
		System.out.println("4.修改学生");
		System.out.println("5.退出");
		
		System.out.println("请输入你的选择：");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		
		while(true) {
			
			switch(choice) {
			case "1"://查看
				findAll(arr);
				break;
			case "2"://添加学生
				addStu(arr);
				break;
			case "3"://删除学生
				deleteStu(arr);
				break;
			case "4"://修改学生
				updateStu(arr);
				break;
			case "5"://退出
				//break;
			default:
				System.out.println("谢谢你的使用！");
				System.exit(0); // JVM虚拟机退出
				break;
			}
			System.out.println("请输入你的选择：");
			choice = sc.nextLine();
			
		} 
	}
	//查看
	public static void findAll(ArrayList<Student> arr) {
		if(arr.size()==0) {
			System.out.println("不好意思，目前没有学生数据可供查询！");
			return;
		}else {
			System.out.println("学号\t姓名\t年龄\t居住地");
			for(int i=0;i<arr.size();i++) {
				Student s = arr.get(i);
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getAddress());
			}
			
		}
	}
	
	//添加学生
	public static void addStu(ArrayList<Student> arr){
		Scanner sc = new Scanner(System.in);
		
		String id;
		while(true) {
			
			System.out.println("请输入学生学号：");
			id = sc.nextLine();
			
			
			boolean flag = false;
			
			for(int i=0;i<arr.size();i++) {
				Student s = arr.get(i);
				if(s.getId().equals(id))
					flag = true;
				break;
			}
			
			if(flag) {
				System.out.println("你的学号被占用，请重新输入！");
			}else {
				break;
			}
		}
		
		System.out.println("请输入学生姓名：");
		String name = sc.nextLine();
		System.out.println("请输入学生年龄：");
		String age = sc.nextLine();
		System.out.println("请输入学生居住地：");
		String address = sc.nextLine();
		
		
		
		
		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);
		
		arr.add(s);
		
		System.out.println("添加成功！");
		
	}//添加
	
	//删除学生
	public static void deleteStu(ArrayList<Student> arr) {
		
		if(arr.size()==0) {
			System.out.println("不好意思，目前没有学生数据可供删除！");
			return;
		}else {
			
			int index = -1;
			
			// 键盘录入对象
			Scanner sc = new Scanner(System.in);
			System.out.println("输入你要删除的学生学号：");
			String id = sc.nextLine();
			
			//遍历集合
			for(int i=0;i<arr.size();i++) {
				Student s = arr.get(i);
				if(s.getId().equals(id)) {
					index = i;
					break;
				}
			}
			
			if(index == -1) {
				System.out.println("不好意思，不存在该学号的学生信息");
				return;
			}else {
				arr.remove(index);
				System.out.println("删除学生成功！");
			}
			
			
		}
		
	}//删除
	
	
	//修改学生
	public static void updateStu(ArrayList<Student> arr){
		if(arr.size()==0) {
			System.out.println("不好意思，目前没有学生数据可供修改！");
			return;
		}else {
			
			int a = -1;
			
			// 键盘录入对象
			Scanner sc = new Scanner(System.in);
			System.out.println("输入你要修改的学生学号：");
			String id = sc.nextLine();
			
			//遍历集合
			for(int i=0;i<arr.size();i++) {
				Student s = arr.get(i);
				if(s.getId().equals(id)) {
					a = i;
				}
			}
			
			if(a == -1) {
				System.out.println("不好意思，不存在该学号的学生信息");
				return;
			}else {
				boolean b=true;
				while(b) {
					
					int select = 0;
					System.out.println("请输入你要修改的内容：\t1.学号\t2.姓名\t3.年龄\t4.居住地");
					select = sc.nextInt();
					
					Scanner scc = new Scanner(System.in);
					if(select<1 || select>4) {
						System.out.println("输入选项不正确，请重新输入！");
					}else if(select == 1){
						Student ss = arr.get(a);
						System.out.println("请输入新的学号：");
						ss.setId(scc.nextLine());
						System.out.println("修改学生成功！");
						b=false;
					}else if(select == 2){
						Student ss = arr.get(a);
						System.out.println("请输入新的姓名：");
						ss.setName(scc.nextLine());
						System.out.println("修改学生成功！");
						b=false;
					}else if(select == 3){
						Student ss = arr.get(a);
						System.out.println("请输入新的年龄：");
						ss.setAge(scc.nextLine());
						System.out.println("修改学生成功！");
						b=false;
					}else{
						System.out.println("请输入新的居住地：");
						Student ss = arr.get(a);
						ss.setAddress(scc.nextLine());
						System.out.println("修改学生成功！");
						b=false;
					}//if
				}//while
			}//else
			
			
		}//else

		
	}//修改
	
	
				
		
}		
		
