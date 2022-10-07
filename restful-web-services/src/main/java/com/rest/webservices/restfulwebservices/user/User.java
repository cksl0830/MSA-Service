package com.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

/**
 * @JsonProperty : json 형식에서 key 이름 설정
 * @JsonIgnore : 클라이언트가 보지못하게 정적 필터링
 * @JsonIgnoreProperties : 클라이언트가 보지못하게 정적 필터링 (전체 클래스에서 복수 설정)
 * @JsonFilter : 동적 필터링 (url마다 다르게 보여주기)
 */

//@JsonFilter("UserInfo")
//@JsonIgnoreProperties("user_name","team")
@Entity(name = "member")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    //@JsonProperty("user_name")
    @Size(min = 2, message = "2글자 이상 입력하세요.")
    private String name;

    private String team;

    //@JsonIgnore
//    @NotNull(message = "생년월일을 입력하세요.")
    private LocalDate birth;

    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Board> boardList;

    public List<Board> getBoardList() {
        return boardList;
    }

    public User(Integer id, String name, String team, LocalDate birth, String password) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.birth = birth;
        this.password = password;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", team='" + team + '\'' + ", birth=" + birth + ", password='" + password + '\'' + '}';
    }
}
