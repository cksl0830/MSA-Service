package com.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    // JPA를 이용해 사용자를 찾고, 저장하고 삭제하고 등등..
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount,"charming","R&D", LocalDate.of(1996,8,30),"1231"));
        users.add(new User(++usersCount,"denver","R&D", LocalDate.of(1993,7,13),"1232"));
        users.add(new User(++usersCount,"martini","R&D", LocalDate.of(1995,12,16),"1233"));
    }

    public List<User> findAll(){
        return users;
    }
    /**
    public User findOne(int id) {
        return users.get(id-1);}
     */
    // 함수형 프로그래밍
    public User findOne(int id) {
        Predicate<User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    public void deleteById(int id){
        Predicate<User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}