package com.wuwenwen;

import java.util.ArrayList;
import java.util.Scanner;

/*
  *  �����ҵ�ѧ������ϵͳ�������� 
 * �������£�
 * 1.����ѧ����
 * 2.�������д
 * 3.�鿴���ܱ�д
 * 4.��ӹ��ܱ�д
 * 5.ɾ�����ܱ�д
 * 6.�޸Ĺ��ܱ�д
 */
public class StudentManagerTest {
	public static void main(String[] args) {
		//�������϶������Դ洢����
		ArrayList<Student> arr = new ArrayList<Student>();
		

		//ѧ������ϵͳ������
		System.out.println("--------��ӭ����ѧ������ϵͳ--------");
		System.out.println("1.�鿴");
		System.out.println("2.���ѧ��");
		System.out.println("3.ɾ��ѧ��");
		System.out.println("4.�޸�ѧ��");
		System.out.println("5.�˳�");
		
		System.out.println("���������ѡ��");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		
		while(true) {
			
			switch(choice) {
			case "1"://�鿴
				findAll(arr);
				break;
			case "2"://���ѧ��
				addStu(arr);
				break;
			case "3"://ɾ��ѧ��
				deleteStu(arr);
				break;
			case "4"://�޸�ѧ��
				updateStu(arr);
				break;
			case "5"://�˳�
				//break;
			default:
				System.out.println("лл���ʹ�ã�");
				System.exit(0); // JVM������˳�
				break;
			}
			System.out.println("���������ѡ��");
			choice = sc.nextLine();
			
		} 
	}
	//�鿴
	public static void findAll(ArrayList<Student> arr) {
		if(arr.size()==0) {
			System.out.println("������˼��Ŀǰû��ѧ�����ݿɹ���ѯ��");
			return;
		}else {
			System.out.println("ѧ��\t����\t����\t��ס��");
			for(int i=0;i<arr.size();i++) {
				Student s = arr.get(i);
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getAddress());
			}
			
		}
	}
	
	//���ѧ��
	public static void addStu(ArrayList<Student> arr){
		Scanner sc = new Scanner(System.in);
		
		String id;
		while(true) {
			
			System.out.println("������ѧ��ѧ�ţ�");
			id = sc.nextLine();
			
			
			boolean flag = false;
			
			for(int i=0;i<arr.size();i++) {
				Student s = arr.get(i);
				if(s.getId().equals(id))
					flag = true;
				break;
			}
			
			if(flag) {
				System.out.println("���ѧ�ű�ռ�ã����������룡");
			}else {
				break;
			}
		}
		
		System.out.println("������ѧ��������");
		String name = sc.nextLine();
		System.out.println("������ѧ�����䣺");
		String age = sc.nextLine();
		System.out.println("������ѧ����ס�أ�");
		String address = sc.nextLine();
		
		
		
		
		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);
		
		arr.add(s);
		
		System.out.println("��ӳɹ���");
		
	}//���
	
	//ɾ��ѧ��
	public static void deleteStu(ArrayList<Student> arr) {
		
		if(arr.size()==0) {
			System.out.println("������˼��Ŀǰû��ѧ�����ݿɹ�ɾ����");
			return;
		}else {
			
			int index = -1;
			
			// ����¼�����
			Scanner sc = new Scanner(System.in);
			System.out.println("������Ҫɾ����ѧ��ѧ�ţ�");
			String id = sc.nextLine();
			
			//��������
			for(int i=0;i<arr.size();i++) {
				Student s = arr.get(i);
				if(s.getId().equals(id)) {
					index = i;
					break;
				}
			}
			
			if(index == -1) {
				System.out.println("������˼�������ڸ�ѧ�ŵ�ѧ����Ϣ");
				return;
			}else {
				arr.remove(index);
				System.out.println("ɾ��ѧ���ɹ���");
			}
			
			
		}
		
	}//ɾ��
	
	
	//�޸�ѧ��
	public static void updateStu(ArrayList<Student> arr){
		if(arr.size()==0) {
			System.out.println("������˼��Ŀǰû��ѧ�����ݿɹ��޸ģ�");
			return;
		}else {
			
			int a = -1;
			
			// ����¼�����
			Scanner sc = new Scanner(System.in);
			System.out.println("������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
			String id = sc.nextLine();
			
			//��������
			for(int i=0;i<arr.size();i++) {
				Student s = arr.get(i);
				if(s.getId().equals(id)) {
					a = i;
				}
			}
			
			if(a == -1) {
				System.out.println("������˼�������ڸ�ѧ�ŵ�ѧ����Ϣ");
				return;
			}else {
				boolean b=true;
				while(b) {
					
					int select = 0;
					System.out.println("��������Ҫ�޸ĵ����ݣ�\t1.ѧ��\t2.����\t3.����\t4.��ס��");
					select = sc.nextInt();
					
					Scanner scc = new Scanner(System.in);
					if(select<1 || select>4) {
						System.out.println("����ѡ���ȷ�����������룡");
					}else if(select == 1){
						Student ss = arr.get(a);
						System.out.println("�������µ�ѧ�ţ�");
						ss.setId(scc.nextLine());
						System.out.println("�޸�ѧ���ɹ���");
						b=false;
					}else if(select == 2){
						Student ss = arr.get(a);
						System.out.println("�������µ�������");
						ss.setName(scc.nextLine());
						System.out.println("�޸�ѧ���ɹ���");
						b=false;
					}else if(select == 3){
						Student ss = arr.get(a);
						System.out.println("�������µ����䣺");
						ss.setAge(scc.nextLine());
						System.out.println("�޸�ѧ���ɹ���");
						b=false;
					}else{
						System.out.println("�������µľ�ס�أ�");
						Student ss = arr.get(a);
						ss.setAddress(scc.nextLine());
						System.out.println("�޸�ѧ���ɹ���");
						b=false;
					}//if
				}//while
			}//else
			
			
		}//else

		
	}//�޸�
	
	
				
		
}		
		
