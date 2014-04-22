package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.HelloEntity;

public interface HelloRepository extends JpaRepository<HelloEntity, Long>{

}
