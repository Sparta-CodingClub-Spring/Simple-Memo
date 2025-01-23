package sparta.week1.Simple_Memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sparta.week1.Simple_Memo.entity.Memo;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
}
