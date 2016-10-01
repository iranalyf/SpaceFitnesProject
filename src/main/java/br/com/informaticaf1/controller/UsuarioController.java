package br.com.informaticaf1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.informaticaf1.models.Usuario;
import br.com.informaticaf1.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@RequestMapping("/listar")
	public ModelAndView listar() {

		ModelAndView mv = new ModelAndView("usuario/PesquisaUsuarios");

		List<Usuario> usuarios = repository.findAll();

		mv.addObject("usuarios", usuarios);

		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView cadastrar(Usuario usuario, RedirectAttributes atributes) {

		ModelAndView mv = new ModelAndView("redirect:/usuarios/novo");

		this.repository.save(usuario);

		atributes.addFlashAttribute("mensagem", "Usuario cadastrado com Sucesso");

		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public String form(@ModelAttribute("usuario") Usuario usuario) {

		return "usuario/CadastroUsuario";
	}
}
