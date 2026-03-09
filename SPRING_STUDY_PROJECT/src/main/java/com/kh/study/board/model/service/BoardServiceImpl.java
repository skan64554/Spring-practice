package com.kh.study.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.study.board.model.service.BoardServiceImpl;
import com.kh.study.board.model.vo.Board;
import com.kh.study.board.model.dao.BoardDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;
	
	@Override
	public Map<String, String> getBoardTypeMap() {
		return boardDao.getBoardTypeMap();
	}

	@Override
	public List<Board> selectBoardList() {
		return boardDao.selectBoardList();
	}
	
	@Override
	public int insertBoard(Board board) {
		return boardDao.insertBoard(board);
	}
	
	@Override
	public Board selectBoardDetail(int boardNo) {
		return boardDao.selectBoardDetail(boardNo);
	}

}
