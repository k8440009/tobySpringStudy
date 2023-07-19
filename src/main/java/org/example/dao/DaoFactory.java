package org.example.dao;

public class DaoFactory {
    /*
        팩토리의 메소드는 UserDao 타입의 오브젝트를 어떻게 만들고, 어떻게 준비시킬지를 결정한다.
    */
    public UserDao userDao1() {
//        ConnectionMaker connectionMaker = new DConnectionMaker();
//        UserDao userDao = new UserDao(connectionMaker);
//        return userDao;
        return new UserDao(connectionMaker1());
    }

    public AccountDao accountDao1() {
//        ConnectionMaker connectionMaker = new DConnectionMaker();
//        AccountDao accountDao = new AccountDao(connectionMaker);
//        return accountDao;
        return new AccountDao(connectionMaker1());
    }

    public MessageDao messageDao1() {
//        ConnectionMaker connectionMaker = new DConnectionMaker();
//        MessageDao messageDao = new MessageDao(connectionMaker);
//        return messageDao;
        // 중복 제거
        return new MessageDao(connectionMaker1());
    }

    public ConnectionMaker connectionMaker1() {
        return new DConnectionMaker();
    }

    public UserDao userDao2() {
        /*
            팩토리의 메소드는 UserDao 타입의 오브젝트를 어떻게 만들고, 어떻게 준비시킬지를 결정한다.
         */
        ConnectionMaker connectionMaker = new NConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
