package com.example.layers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.layers.dto.AlunoDTO;
import com.example.layers.entity.Aluno;
import com.example.layers.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public AlunoDTO saveAluno(AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno(alunoDTO.getId(), alunoDTO.getNome(), alunoDTO.getMatricula(), alunoDTO.getCurso());
		
		Aluno alunoSalvo = alunoRepository.save(aluno);
		
		alunoDTO = new AlunoDTO(alunoSalvo);
		
		return alunoDTO;
	}
	
	public List<AlunoDTO> listAlunos() {
		List<AlunoDTO> alunosDTO = new ArrayList<>();
		
		List<Aluno> alunos = alunoRepository.findAll();
		
		for (Aluno aluno : alunos) {
			AlunoDTO alunoDTO = new AlunoDTO(aluno);
			alunosDTO.add(alunoDTO);
		}
		
		return alunosDTO;
		
	}
	
}
