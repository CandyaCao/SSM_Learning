package com.github.candyacao.special;

import java.util.List;

public interface IUserMapper {
	void insertUser(User user);
	User selectUserByID(int id);
	void insertUserPic(UserPic userPic);
	UserPic getUserPicById(int id);
	List<UserPic> getUserPicAll();
}
