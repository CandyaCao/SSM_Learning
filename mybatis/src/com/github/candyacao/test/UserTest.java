package com.github.candyacao.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.candyacao.special.Gender;
import com.github.candyacao.special.IUserMapper;
import com.github.candyacao.special.User;
import com.github.candyacao.special.UserPic;
import com.github.candyacao.utils.MybatisSqlSessionFactory;

public class UserTest {

	SqlSession sqlSession = null;
	IUserMapper mapper = null;

	@Test
	public void map() {
		Map<Integer, UserPic> map = sqlSession.selectMap("getUserPicAll", "id");
		for(Integer key:map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}
	}
	
	@Test
	public void test_getUserPicById() {

		SqlSession session = null;
		try {

			UserPic userPic = mapper.getUserPicById(1);

			System.out.println(userPic.getId());
			System.out.println(userPic.getName());
			System.out.println(userPic.getBio());
			System.out.println(userPic.getPic().length);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test_insertUserPic() {
		byte[] pic = null;
		try {
			// 读取用户头像图片
			File file = new File("src/com/github/candyacao/special/test.png");
			InputStream is = new FileInputStream(file);
			pic = new byte[is.available()];
			is.read(pic);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String name = "tom";
		String bio = "可以是很长的字符串";
		// 准备好要插入到数据库中的数据并封装成对象
		UserPic userPic = new UserPic(name, pic, bio);
		mapper.insertUserPic(userPic);

	}

	@Test
	public void save() {
		User user1 = new User("lisi", Gender.FEMALE);
		mapper.insertUser(user1);
		User user = mapper.selectUserByID(4);
		System.out.println(user);
	}

	@Before
	public void getMapper() {
		try {
			sqlSession = MybatisSqlSessionFactory.getSqlSession();
			mapper = sqlSession.getMapper(IUserMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void close() {

		try {
			sqlSession.commit();
			sqlSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
