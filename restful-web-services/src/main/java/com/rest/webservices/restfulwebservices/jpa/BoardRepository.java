package com.rest.webservices.restfulwebservices.jpa;

import com.rest.webservices.restfulwebservices.user.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
