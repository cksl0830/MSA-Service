package com.rest.webservices.restfulwebservices.user;

import com.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.rest.webservices.restfulwebservices.jpa.BoardRepository;
import com.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class BoardJpaController {

    private UserRepository userRepository;
    private BoardRepository boardRepository;

    public BoardJpaController(UserRepository userRepository, BoardRepository boardRepository) {
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }

    // 게시글 조회
    @GetMapping("/users/{id}/boards")
    public List<Board> retrieveBoardOfUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id " + id + ": not found");
        return user.get().getBoardList();
    }

    // 게시글 추가
    @PostMapping("/users/{id}/boards")
    public ResponseEntity<Objects> createBoardOfUser(@PathVariable int id, @Valid @RequestBody Board board) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id " + id + ": not found");
        board.setUser(user.get());
        Board savedboard = boardRepository.save(board);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedboard.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
