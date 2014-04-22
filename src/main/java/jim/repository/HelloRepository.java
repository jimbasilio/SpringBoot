package jim.repository;

import jim.entity.HelloEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<HelloEntity, Long>{

}
