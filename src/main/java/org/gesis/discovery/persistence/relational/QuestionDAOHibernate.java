package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.Question;
import org.gesis.discovery.persistence.QuestionDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class QuestionDAOHibernate extends GenericResourceHibernateDAO<Question> implements QuestionDAO
{

	public QuestionDAOHibernate()
	{
		super();
	}

	public QuestionDAOHibernate(final HibernateTemplate hibernateTemplate) {
		super( hibernateTemplate );
	}

}
