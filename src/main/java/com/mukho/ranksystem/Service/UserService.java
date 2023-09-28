package com.mukho.ranksystem.Service;

import com.mukho.ranksystem.Dto.LoginFormDto;
import com.mukho.ranksystem.Dto.SignUpFormDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public interface UserService {

	boolean login(LoginFormDto form, HttpServletRequest request, HttpServletResponse response, PrintWriter out);

	boolean signup(SignUpFormDto form, HttpServletRequest request, HttpServletResponse response, PrintWriter out);

	boolean isIdDuplication(String id);

}
