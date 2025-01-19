package sparta.week1.Simple_Memo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sparta.week1.Simple_Memo.dto.MemoRequestDto;

@Getter
@Setter
@NoArgsConstructor
public class Memo {
	private Long id;
	private String username;
	private String contents;

	public Memo(MemoRequestDto requestDto) {
		this.username = requestDto.getUsername();
		this.contents = requestDto.getContents();
	}

	public void update(MemoRequestDto requestDto) {
		this.username = requestDto.getUsername();
		this.contents = requestDto.getContents();
	}
}
