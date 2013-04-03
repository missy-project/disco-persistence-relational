package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.Question;
import org.gesis.ddi.persistence.dataAccess.QuestionDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class QuestionDAOHibernate extends GenericHibernateDAO<Question> implements QuestionDAO
{

	public QuestionDAOHibernate(final HibernateTemplate hibernateTemplate) {
		super( hibernateTemplate );
	}

	@Override
	public List<Question> getAll()
	{

		@SuppressWarnings("unchecked")
		List<Question> questions = getHibernateTemplate().find( "from Question" );

		if ( questions == null )
			return Collections.emptyList();

		return questions;
	}

}
