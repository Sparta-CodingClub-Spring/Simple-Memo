package sparta.week1.Simple_Memo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sparta.week1.Simple_Memo.dto.MemoRequestDto;
import sparta.week1.Simple_Memo.dto.MemoResponseDto;
import sparta.week1.Simple_Memo.entity.Memo;
import sparta.week1.Simple_Memo.repository.MemoRepository;

@Service
public class MemoService {

	private final MemoRepository memoRepository;

	public MemoService(MemoRepository memoRepository){
		this.memoRepository = memoRepository;
	}

	public MemoResponseDto createMemo(MemoRequestDto requestDto) {
		Memo memo = new Memo(requestDto);

		memoRepository.save(memo);

		MemoResponseDto responseDto = new MemoResponseDto(memo);

		return responseDto;
	}

	public List<MemoResponseDto> getMemos() {
		return memoRepository.findAll().stream().map(MemoResponseDto::new).toList();
	}

	// update의 경우, Dirty Checking 작동을 위해 트랜잭션 설정 필수
	@Transactional
	public Long updateMemo(Long id, MemoRequestDto requestDto){
		Memo memo = findMemo(id);
		memo.update(requestDto);
		return id;
	}

	public Long deleteMemo(Long id){
		Memo memo = findMemo(id);
		memoRepository.delete(memo);

		return id;
	}

	private Memo findMemo(Long id){
		return memoRepository.findById(id).orElseThrow(() ->
			new IllegalArgumentException("선택한 메세지는 존재하지 않습니다."));
	}
}
