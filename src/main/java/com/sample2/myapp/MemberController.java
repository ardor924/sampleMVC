package com.sample2.myapp;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample2.model.MemberDTO;
import com.sample2.service.MemberService;

@Controller
public class MemberController {

	@Autowired MemberService memberService;
	
	
	// 회원가입(페이지)
	@RequestMapping("memberJoinPage.do")
	public String memberJoinPage() {
		return "membership/join";
	}
	
	
	// 회원가입 (DB등록)
	@RequestMapping("memberInsert.do")
	public String memberInsert(HttpServletRequest request, MemberDTO mDto) {
		
		
		// 생일
		String str_member_birth = request.getParameter("str_member_birth");
		Date member_birth = memberService.stringToDate(str_member_birth);
			
		// 등록날자
		Date member_regdate = memberService.getNowDate();
		
		// DTO에 파라미터 세팅
		mDto.setMember_birth(member_birth);
		mDto.setMember_regdate(member_regdate);
		
		// 비지니스로직(서비스) 실행
		memberService.joinMembership(mDto);


		return "redirect:/memberListPage.do";
	}
	
	
	// 로그인 (페이지)
	@RequestMapping("memberLoginPage.do")
	public String memberLoginPage() {
		return "membership/login";
	}
	
	
	// 로그인 (DB조회)
	@RequestMapping("memberLogin.do")
	public String memberLogin(HttpSession session,HttpServletRequest request, MemberDTO mDto) {
		
		MemberDTO member_info = memberService.loginMembership(mDto);
			
		
		// 로그인 성공
		if(member_info != null) {
			
			String member_name = member_info.getMember_name();
			
			session.setAttribute("member_name", member_name);
			session.setAttribute("isLogin", "yes");
			request.setAttribute("login_msg", "success");
		}

		
		// 로그인 실패
		else {
			request.setAttribute("login_msg", "fail");
			return "membership/login";
		}
		
		
		return "home";
	}
	
	
	
	// 로그아웃
	@RequestMapping("memberLogout.do")
	public String memberLogout(HttpSession session, HttpServletRequest request) {
		
		session.removeAttribute("member_name");
		session.removeAttribute("isLogin");
		
		
		
		return "redirect:/";
	}
	

	
	
	// 회원 전체목록 조회(페이지)
	@RequestMapping("memberListPage.do")
	public String memberListPage(Model model) {
		
		List<MemberDTO> member_list =  memberService.getAllMemberList();
		
		model.addAttribute("member_list", member_list);
		
		return "membership/list";
	}
	
	
	
	
}
