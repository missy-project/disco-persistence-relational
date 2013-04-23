package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.Questionnaire;
import org.gesis.ddi.persistence.dataAccess.QuestionnaireDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class QuestionnaireDAOHibernate extends GenericHibernateDAO<Questionnaire> implements QuestionnaireDAO
{

	public QuestionnaireDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<Questionnaire> getAll()
	{
		List<Questionnaire> questionnaires = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( questionnaires == null )
			return Collections.emptyList();

		return questionnaires;
	}

}
