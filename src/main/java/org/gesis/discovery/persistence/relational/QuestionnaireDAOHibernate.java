package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.Questionnaire;
import org.gesis.discovery.persistence.QuestionnaireDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class QuestionnaireDAOHibernate extends GenericHibernateDAO<Questionnaire> implements QuestionnaireDAO
{

	public QuestionnaireDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
