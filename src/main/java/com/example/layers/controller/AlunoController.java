package com.example.layers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.layers.dto.AlunoDTO;
import com.example.layers.service.AlunoService;

@RestController
@RequestMapping("alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@PostMapping
	public AlunoDTO save(@RequestBody AlunoDTO alunoDTO) {
		AlunoDTO alunoSalvo = alunoService.saveAluno(alunoDTO);
		return alunoSalvo;
	}
	
	@GetMapping
	public List<AlunoDTO> list() {
		List<AlunoDTO> alunos = alunoService.listAlunos();
		return alunos;
	}
	
}
