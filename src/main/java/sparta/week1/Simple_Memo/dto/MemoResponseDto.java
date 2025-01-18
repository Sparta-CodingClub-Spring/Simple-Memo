package sparta.week1.Simple_Memo.dto;

import lombok.Getter;
import sparta.week1.Simple_Memo.entity.Memo;

//ResponseDto로 반환 시, 해당 클래스에 @Getter가 있어야 올바른 JSON 타입으로 반환 가능하다!
@Getter
public class MemoResponseDto {
	Long id;
	String username;
	String contents;

	public MemoResponseDto(Memo memo) {
		this.id = memo.getId();
		this.username = memo.getUsername();
		this.contents = memo.getContents();
	}
}


