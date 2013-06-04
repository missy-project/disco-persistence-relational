package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.Question;
import org.gesis.ddi.ontology.persistence.QuestionDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class QuestionDAOHibernate extends GenericHibernateDAO<Question> implements QuestionDAO
{

	public QuestionDAOHibernate(final HibernateTemplate hibernateTemplate) {
		super( hibernateTemplate );
	}

}
