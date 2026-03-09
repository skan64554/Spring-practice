package com.kh.study.board.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.study.board.model.vo.Board;

public interface BoardDao {

	Map<String, String> getBoardTypeMap();

	List<Board> selectBoardList();

	int insertBoard(Board board);
	
	Board selectBoardDetail(int boardNo);
}
