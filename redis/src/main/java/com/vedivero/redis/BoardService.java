package com.vedivero.redis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    public List<Board> getBoardss(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Board> pageOfBoard = boardRepository.findByOrderByCreatedAtDesc(pageable);
        return pageOfBoard.getContent();
    }
}
