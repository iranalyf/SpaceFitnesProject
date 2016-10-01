package br.com.informaticaf1.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.informaticaf1.models.Avaliacao;

public class AvaliacaoFisicaRepository {

	@Autowired
	private static Avaliacao avaliacao;

	@PersistenceContext
	private static EntityManager em;

	protected Map<Date, String> avaliacaoPorData(Avaliacao avaliacao) {

		// pega a data Atual, menos 15 dias
		LocalDate dataAtual = LocalDate.now();
		dataAtual.minusDays(15);

		Session session = em.unwrap(Session.class);

		Criteria criteria = session.createCriteria(Avaliacao.class);

		criteria.add(Restrictions.eq("data", avaliacao.getDataCriacao()));
		criteria.add(Restrictions.eq("peitoral", avaliacao.getPeitoral()));
		// fazer com todo mundo

		List<Avaliacao> avaliacoes = criteria.list();

		for (Avaliacao avaliacaoFisica : avaliacoes) {

			// TODO implementar
		}

		return null;
	}

	public static Avaliacao getAvaliacao() {
		return avaliacao;
	}
}
