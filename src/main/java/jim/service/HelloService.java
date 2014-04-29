package jim.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jim.dto.HelloDTO;
import jim.entity.HelloEntity;
import jim.repository.HelloRepository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HelloService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private HelloRepository helloRepository;

    @Transactional(readOnly = false)
    public Long create(HelloDTO toCreate) {
        HelloEntity hello = new HelloEntity();
        hello.setMyHello(toCreate.getMyHello());

        return helloRepository.save(hello).getId();
    }

    @Transactional(readOnly = true)
    public List<HelloDTO> findAll() {
        List<HelloDTO> dtos = helloRepository.findAll().stream()
                .map(entity -> HelloDTO.Build(entity))
                .collect(Collectors.toList());

        return dtos;
    }

    @Transactional(readOnly = true)
    public HelloDTO findById(Long id) {
        Session session = (Session) this.entityManager.getDelegate();
        session.getSessionFactory().getStatistics().logSummary();
        HelloEntity entity = helloRepository.findOne(id);
        entityManager.flush();
        session.getSessionFactory().getStatistics().logSummary();

        return HelloDTO.Build(entity);
    }

}
