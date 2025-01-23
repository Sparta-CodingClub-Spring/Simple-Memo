package sparta.week1.Simple_Memo.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sparta.week1.Simple_Memo.dto.MemoRequestDto;
import sparta.week1.Simple_Memo.dto.MemoResponseDto;
import sparta.week1.Simple_Memo.entity.Memo;
import sparta.week1.Simple_Memo.service.MemoService;

@RestController
@RequestMapping("/api")
public class MemoController {

	private final MemoService memoService;

	public MemoController(MemoService memoService) {
		this.memoService = memoService;
	}

	@PostMapping("/memos")
	public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
		return memoService.createMemo(requestDto);
	}

	@GetMapping("/memos")
	public List<MemoResponseDto> getMemos(){

		return memoService.getMemos();
	}

	@PutMapping("/memos/{id}")
	public Long updateMemo(@PathVariable long id, @RequestBody MemoRequestDto requestDto){
		return memoService.updateMemo(id, requestDto);
	}

	@DeleteMapping("/memos/{id}")
	public long deleteMemo(@PathVariable long id){
		return memoService.deleteMemo(id);
	}
}
