package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.ontology.Question;
import org.gesis.ddi.persistence.dataAccess.QuestionDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class QuestionDAOHibernate extends GenericHibernateDAO<Question> implements QuestionDAO
{

	public QuestionDAOHibernate(final HibernateTemplate hibernateTemplate) {
		super( hibernateTemplate );
	}

}
