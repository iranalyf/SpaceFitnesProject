package br.com.informaticaf1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.informaticaf1.models.Avaliacao;
import br.com.informaticaf1.models.Usuario;
import br.com.informaticaf1.repository.AvaliacaoRepository;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoRepository repository;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView cadastrar(Avaliacao avaliacao, Usuario usuario, RedirectAttributes atributes) {

	/*	// pega o usuario logado na sessão
		Authentication auth = null;

		if (usuario.getId() == null) {

			avaliacao.setUsuario(usuarioLogado);

		}

		avaliacao = usuario.setId(id);*/

		this.repository.save(avaliacao);

		atributes.addFlashAttribute("mensagem", "Avaliação Física Cadastrada com Sucesso para o Usuario");

		return new ModelAndView("redirect:/avaliacoes/nova");
	}

	@RequestMapping("/nova")
	public ModelAndView form(@ModelAttribute("avaliacao") Avaliacao avaliacao) {

		return new ModelAndView("avaliacao/CadastroAvaliacao");
	}

}
