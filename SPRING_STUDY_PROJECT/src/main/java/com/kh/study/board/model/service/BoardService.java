package com.kh.study.board.model.service;

import java.util.List;
import java.util.Map;

import com.kh.study.board.model.vo.Board;

public interface BoardService {

	Map<String, String> getBoardTypeMap();

	List<Board> selectBoardList();

	Board selectBoardDetail(int boardNo);

	int insertBoard(Board board);
}
