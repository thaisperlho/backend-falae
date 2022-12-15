package br.edu.fateccotia.falae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.fateccotia.falae.model.Posts;
import br.edu.fateccotia.falae.model.PostsGet;



@Repository
public interface PostGetRepository extends JpaRepository<PostsGet, Integer> {
	
	@Query(value = "SELECT p.*, sum(CASE WHEN r.tipo_reaction  = 1 then 1 else 0 end) as gostei, sum(CASE WHEN r.tipo_reaction  = 2 then 1 else 0 end) as nao_gostei FROM posts as p left join reactions r on p.id = r.fk_post_id group by p.id, p.dt_post, p.post, p.fk_user_id, p.model_post order by p.dt_post desc", 
			nativeQuery = true)
	List<PostsGet> buscaComQtdReaction();

}
