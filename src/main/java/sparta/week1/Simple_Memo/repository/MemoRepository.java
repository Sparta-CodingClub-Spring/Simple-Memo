package sparta.week1.Simple_Memo.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import sparta.week1.Simple_Memo.entity.Memo;

@Repository
public class MemoRepository {

	@Transactional
	public Memo createMemo(EntityManager em) {
		Memo memo = em.find(Memo.class, 1);
		memo.setUsername("Robbert");
		memo.setContents("@Transactional 전파 테스트 중! 2");

		System.out.println("createMemo 메서드 종료");
		return memo;
	}
}
