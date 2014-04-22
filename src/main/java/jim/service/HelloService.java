package jim.service;

import java.util.List;
import java.util.stream.Collectors;

import jim.dto.HelloDTO;
import jim.entity.HelloEntity;
import jim.repository.HelloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
