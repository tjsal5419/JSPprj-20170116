package com.newlecture.web.data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.newlecture.web.dao.mysql.MySQLMemberDao;
import com.newlecture.web.data.dao.MemberDao;

public class Program {

	public static void main(String[] args){
		System.out.println("검색할 ID를 입력해주세요");
		Scanner scan = new Scanner(System.in);
		String id = scan.nextLine();
		
		MemberDao member = new MySQLMemberDao();
		List<Member> list = new ArrayList<>(); 
		list = member.getList(id);
		
		System.out.println("출력");
		for(Member m : list)
			System.out.printf("%s		%s	%s	%s	%s	%s	\n", m.getId(), m.getName(), m.getPhone(), m.getGender(),m.getBirthday(),m.getRegDate());


		
/*		System.out.println("┌──────────────────────────────┐");
		System.out.println("│                      메         인       메          뉴                                  │");
		System.out.println("└──────────────────────────────┘");
		
		boolean exit = true;
		Scanner scan = new Scanner(System.in);
		
		do{
		System.out.println("1. 회원 관리");
		System.out.println("2. 게시글 관리");
		System.out.println("3. 종료");
		System.out.print(" > ");
		String menu = scan.nextLine();
		switch(menu){
		case "1":
			manage();
			break;
		case "2":
			System.out.println("게시글 관리");
			break;
		case "3":
			exit = false;
			break;
		default:
			System.out.println("1, 2, 3 중에서 입력해주세요.");
		}
		}while(exit);
	      
	}


	public static void manage(){
		Scanner scan = new Scanner(System.in);
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│              회         원              관               리                              │");
		System.out.println("└──────────────────────────────┘");

		MemberDao memberDao = new OracleMemberDao();
		List<Member> list = new ArrayList<>();
		list = memberDao.getList();
		boolean repeat = true;
		
		System.out.println("아이디	이름	전화번호	성별	나이	전공	생일	가입일자");
		for(Member m : list)
			System.out.printf("%s		%s	%s	%s	%s	%s	%s	%s	\n", m.getMid(), m.getName(), m.getPhone(), m.getGender(),m.getAge(),m.getMajor(),m.getBirthday(),m.getRegDate());

		
		do{
		System.out.println("──────────────────────────");
		System.out.println("1.추가 2.수정 3. 삭제 4. 상위메뉴");
		System.out.printf(" 메뉴 >");
		String menu = scan.nextLine();
		
		switch(menu){
			case "1":
				input();
				break;		
				
			case "2" :
				modify();
				break;		
	 		case "3" :
	 			delete();
				break;					
			case "4" :
				repeat = false;
				break;					
			default :
				System.out.println("1~4 사이의 숫자를 입력해주세요.");
		}
		}while(repeat);
	}

	public static void input(){
		Scanner scan = new Scanner(System.in);

		System.out.println("┌──────────────────────────────┐");
		System.out.println("│                      회         원       추          가                                  │");
		System.out.println("└──────────────────────────────┘");

		System.out.println("추가할 회원 정보를 입력하세요.");
		Member member = new Member();
		boolean input = true;
		
		do{
		System.out.print("아이디 :");
		String mid = scan.nextLine();
		member.setMid(mid);

		System.out.print("이름 :");
		String name = scan.nextLine();
		member.setName(name);

		System.out.print("전화번호 :");
		String phone = scan.nextLine();
		member.setPhone(phone);
		
		System.out.print("비밀번호 :");
		String pwd = scan.nextLine();
		member.setPwd(pwd);

		System.out.print("성별 :");
		String gender = scan.nextLine();
		member.setGender(gender);

		System.out.print("나이 :");
		int age = Integer.parseInt(scan.nextLine());
		member.setAge(age);
		
		System.out.print("전공 :");
		String major = scan.nextLine();
		member.setPhone(phone);
		
		System.out.print("생일 : ");
		String birthday = scan.nextLine();
		member.setBirthday(birthday);
		
		MemberDao memberDao = new OracleMemberDao();
		memberDao.add(member);
		
		System.out.println("계속 입력하시겠습니까? [y/n]");
		
		if(scan.nextLine().equals("n")){
			input = false;
			break;
		}
		}while(input);
	}
	public static void delete() {
		
		boolean repeat = true;
		do{
		System.out.println("지우고 싶은 ID를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		String mid = scan.nextLine();
		MemberDao memberDao = new OracleMemberDao();
		
		memberDao.delete(mid);
		
		System.out.println("추가로 더 지우시겠습니까? [y/n]");
		
		if(scan.nextLine().equals("n")){
			repeat = false;
			break;
		}
		
		}while(repeat);
	}
	
	
	
	public static void modify() {
		
		boolean repeat = true;
		do{
			
		Member member = new Member();
	
		System.out.println("수정할 ID를 입력해주세요.");
		Scanner scan = new Scanner(System.in);
		String mid = scan.nextLine();
		member.setMid(mid);
		
		System.out.println("새로 변경할 개인 정보를 입력해주세요.");

		System.out.print("이름 :");
		String name = scan.nextLine();
		member.setName(name);

		System.out.print("전화번호 :");
		String phone = scan.nextLine();
		member.setPhone(phone);
		
		System.out.print("비밀번호 :");
		String pwd = scan.nextLine();
		member.setPwd(pwd);

		System.out.print("성별 :");
		String gender = scan.nextLine();
		member.setGender(gender);

		System.out.print("나이 :");
		int age = Integer.parseInt(scan.nextLine());
		member.setAge(age);
		
		System.out.print("전공 :");
		String major = scan.nextLine();
		member.setPhone(phone);
		
		System.out.print("생일 : ");
		String birthday = scan.nextLine();
		member.setBirthday(birthday);
		
		MemberDao memberDao = new OracleMemberDao();
		
		memberDao.modify(member);
		
		System.out.println("추가로 더 수정하시겠습니까? [y/n]");
		
		if(scan.nextLine().equals("n")){
			repeat = false;
			break;
		}
		
		}while(repeat);
*/		
	}

}
