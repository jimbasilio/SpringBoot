package service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dto.HelloDTO;
import repository.HelloRepository;
import entity.HelloEntity;

public class HelloService {

	@Autowired
	private HelloRepository helloRepository;
	
	@Transactional(readOnly = false)
	public Long create(HelloDTO toCreate)
	{
		HelloEntity hello = new HelloEntity();
		hello.setMyHello(hello.getMyHello());
		
		return helloRepository.save(hello).getId();
	}
	
	@Transactional(readOnly = true)
	public List<HelloDTO> findAll()
	{
		List<HelloDTO> dtos = helloRepository.findAll().stream().map(entity -> HelloDTO.Build(entity)).collect(Collectors.toList());

		return dtos;
	}

	@Transactional(readOnly = true)
	public HelloDTO findById(Long id)
	{
		HelloEntity entity = helloRepository.findOne(id);
		
		return HelloDTO.Build(entity);
	}

	
}
