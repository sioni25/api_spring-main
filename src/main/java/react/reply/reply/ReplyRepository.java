package react.reply.reply;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer>{
	public Page<ReplyEntity> findByTitleContaining(String searchWord, Pageable page);
	public Page<ReplyEntity> findByContentContaining(String searchWord, Pageable page);
	public Page<ReplyEntity> findByTitleContainingOrContentContaining(String searchWord, String searchWord2, Pageable page);
	
	// ono 수정
	@Modifying // update는 반드시 추가
	@Query("update ReplyEntity set ono=ono+1 where gno=?1 AND ono > ?2")
	public void updateOno(int gno, int ono);
}
