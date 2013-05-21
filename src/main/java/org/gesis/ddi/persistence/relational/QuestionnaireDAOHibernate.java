package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.ontology.Questionnaire;
import org.gesis.ddi.persistence.dataAccess.QuestionnaireDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class QuestionnaireDAOHibernate extends GenericHibernateDAO<Questionnaire> implements QuestionnaireDAO
{

	public QuestionnaireDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
