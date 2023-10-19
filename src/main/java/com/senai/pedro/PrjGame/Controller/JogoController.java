package com.senai.pedro.PrjGame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.pedro.PrjGame.Entities.Jogo;
import com.senai.pedro.PrjGame.Service.JogoService;

@RestController
@RequestMapping("/jogos")
public class JogoController {
	@Autowired
	private final JogoService jogoService;

	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}

	@PostMapping
	public Jogo createjogo(@RequestBody Jogo jogo) {
		return jogoService.saveJogo(jogo);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getjogo(@PathVariable Long id) {
		Jogo jogo = jogoService.getJogoById(id);
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/home")
	public String paginainicial() {
		return "index";

	}

	@GetMapping
	public List<Jogo> getAllJogo() {
		return jogoService.getAllJogo();

	}

	public void deletejogo(@PathVariable Long id) {
		jogoService.deletejogo(id);
	}

}
