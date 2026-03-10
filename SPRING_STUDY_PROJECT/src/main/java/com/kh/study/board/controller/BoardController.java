package com.kh.study.board.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.kh.study.common.model.vo.PageInfo;
//import com.kh.study.common.template.Pagination;
import com.kh.study.board.model.service.BoardService;
import com.kh.study.board.model.vo.Board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	private final ResourceLoader resourceLoader;
	private final ServletContext application; // application scope

	@GetMapping("/list")
	public String selectBoardList(Model model) {
	
		List<Board> list = boardService.selectBoardList();
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	 // 글작성 페이지
    @GetMapping("/insert")
    public String insertPage(){

        return "board/insert";
    }

    // 글 등록
    @PostMapping("/insert")
    public String insertBoard(Board board){

        boardService.insertBoard(board);

        return "redirect:/board/list";
    }

    // 상세조회
    @GetMapping("/detail")
    public String boardDetail(int boardNo, Model model){

        Board board = boardService.selectBoardDetail(boardNo);

        model.addAttribute("board", board);

        return "board/detail";
    }











}