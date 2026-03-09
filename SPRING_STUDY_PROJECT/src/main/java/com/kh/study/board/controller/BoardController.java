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


	@PostConstruct
	public void init() {
		// key=코드 , value=게시판이름
		Map<String, String> boardTypeMap
			= boardService.getBoardTypeMap();
		application.setAttribute("boardTypeMap", boardTypeMap);
		log.debug("boardTypeMap : {}" , boardTypeMap);
	}

	
	@GetMapping("/list")
	public String selectBoardList(Model model) {
		
		List<Board> list = boardService.selectBoardList();
		
		model.addAttribute("list", list);
		
		return "board/boardList";
	}
	
	 // 글작성 페이지
    @GetMapping("/insert")
    public String insertPage(){

        return "board/list";
    }

    // 글 등록
    @PostMapping("/insert")
    public String insertBoard(Board board){

        boardService.insertBoard(board);

        return "redirect:/list";
    }

    // 상세조회
    @GetMapping("/detail")
    public String boardDetail(int boardNo, Model model){

        Board board = boardService.selectBoardDetail(boardNo);

        model.addAttribute("board", board);

        return "board/detail";
    }











}