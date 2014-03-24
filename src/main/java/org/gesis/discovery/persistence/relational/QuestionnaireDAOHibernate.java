package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.Questionnaire;
import org.gesis.discovery.persistence.QuestionnaireDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class QuestionnaireDAOHibernate extends GenericResourceHibernateDAO<Questionnaire> implements QuestionnaireDAO
{

	public QuestionnaireDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
