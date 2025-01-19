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

@RestController
@RequestMapping("/api")
public class MemoController {

	// id값을 위한 임시 DB by Map
	private final Map<Long, Memo> memoList = new HashMap<>();

	@PostMapping("/memos")
	public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
		//DB에 저장하기 위해 Entity로 전환
		Memo memo = new Memo(requestDto);

		//현재 DB 연결 안되어 있기에 임시로 Map 사용
		Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;
		memo.setId(maxId);

		//임시DB에 memo(Entity) 저장
		memoList.put(maxId, memo);

		//클라이언트에게 응답하기위해 MemoResponseDto로 전환
		MemoResponseDto responseDto = new MemoResponseDto(memo);

		return responseDto;
	}

	@GetMapping("/memos")
	public List<MemoResponseDto> getMemos(){
		List<MemoResponseDto> responseList = memoList.values().stream()
			.map(MemoResponseDto::new).toList();

		return responseList;
	}

	@PutMapping("/memos/{id}")
	public Long updateMemo(@PathVariable long id, @RequestBody MemoRequestDto requestDto){
		if(memoList.containsKey(id)){
			Memo memo = memoList.get(id);
			memo.update(requestDto);

			return memo.getId();
		}else{
			throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
		}
	}

	@DeleteMapping("/memos/{id}")
	public long deleteMemo(@PathVariable long id){
		if(memoList.containsKey(id)){
			memoList.remove(id);
			return id;
		}else{
			throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
		}
	}
}
