package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.Questionnaire;
import org.gesis.ddi.ontology.persistence.QuestionnaireDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class QuestionnaireDAOHibernate extends GenericHibernateDAO<Questionnaire> implements QuestionnaireDAO
{

	public QuestionnaireDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
