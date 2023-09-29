package com.mukho.ranksystem.Service;

import com.mukho.ranksystem.Dto.LoginFormDto;
import com.mukho.ranksystem.Dto.SignUpFormDto;
import com.mukho.ranksystem.Dto.UserInfoDto;
import com.mukho.ranksystem.Dto.Projection.UserInfoProjection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public interface UserService {

	boolean login(LoginFormDto form, HttpServletRequest request, HttpServletResponse response, PrintWriter out);

	boolean signup(SignUpFormDto form, HttpServletRequest request, HttpServletResponse response, PrintWriter out);

	List<UserInfoProjection> getUsers();

	int updateUser(UserInfoDto info);

	boolean isIdDuplication(String id);

}
