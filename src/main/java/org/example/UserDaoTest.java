package org.example;

import org.example.dao.*;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        ConnectionMaker connectionMaker1 = new DConnectionMaker();
//        ConnectionMaker connectionMaker2 = new NConnectionMaker();
//        UserDao dao1 = new UserDao(connectionMaker1);
//        UserDao dao2 = new UserDao(connectionMaker2);

        UserDao dao1 = new DaoFactory().userDao1();
        UserDao dao2 = new DaoFactory().userDao2();

        // d사 테스트
        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao1.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao1.get(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());

        System.out.println(user2.getId() + " 조회 성공");

        // n사 테스트
        user = new User();
        user.setId("sungsoo");
        user.setName("이성수");
        user.setPassword("notmarried");

        dao2.add(user);

        System.out.println(user.getId() + " 등록 성공");

        user2 = dao2.get(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}

