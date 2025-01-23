package sparta.week1.Simple_Memo.entity;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sparta.week1.Simple_Memo.dto.MemoRequestDto;

@Entity // JPA가 관리할 수 있도록 Entity 지정
@Table(name = "memo") //매핑할 DB의 테이블 이름 지정
@Getter
@Setter
@NoArgsConstructor
public class Memo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment 사용
	private Long id;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "contents", nullable = false, length = 500)
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
