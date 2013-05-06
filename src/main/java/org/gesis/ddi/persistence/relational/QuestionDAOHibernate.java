package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.Question;
import org.gesis.ddi.persistence.dataAccess.QuestionDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class QuestionDAOHibernate extends GenericHibernateDAO<Question> implements QuestionDAO
{

	public QuestionDAOHibernate(final HibernateTemplate hibernateTemplate) {
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<Question> getAll()
	{
		List<Question> questions = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( questions == null )
			return Collections.emptyList();

		return questions;
	}

}
