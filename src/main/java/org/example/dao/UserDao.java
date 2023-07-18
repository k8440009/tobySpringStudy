package org.example.dao;

import org.example.User;

import java.sql.*;

public class UserDao {
    /**
     * JDBC 연결 순서
     * 1. DB 연결을 위한 Connection 을 가져온다.
     * 2. SQL을 담은 Statement(or PreparedStatment)를 만든다.
     * 3. 만들어진 Statement를 실행한다.
     * 4. 조회의 경우 SQL 쿼리 실행 결과를 ResultSet으로 받아서 정보를 저정할 오브젝트에 옮겨준다.
     * 5. 작업 중에 생성된 Connection, Statement, ResultSet 같은 리소스는 작업을 마친 후 반드시 닫아준다.
     * 6. JDBC API가 만들어내는 예외를 잡아서 직접 처리하거나, 메소드에 throws를 선언해서 예외가 발생하면 메소드 밖으로 던지게한다.
     * @param user
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        // 여기는 클래스 이름이 나온다.
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setId(rs.getString("name"));
        user.setId(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

}
