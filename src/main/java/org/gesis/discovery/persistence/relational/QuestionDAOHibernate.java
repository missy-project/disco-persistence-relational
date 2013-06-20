package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.Question;
import org.gesis.discovery.persistence.QuestionDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class QuestionDAOHibernate extends GenericHibernateDAO<Question> implements QuestionDAO
{

	public QuestionDAOHibernate(final HibernateTemplate hibernateTemplate) {
		super( hibernateTemplate );
	}

}
