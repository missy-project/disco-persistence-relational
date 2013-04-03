package org.gesis.ddi.persistence.relational;

import java.util.List;

import org.gesis.ddi.ontology.Questionnaire;
import org.gesis.ddi.persistence.dataAccess.QuestionnaireDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class QuestionnaireDAOHibernate extends GenericHibernateDAO<Questionnaire> implements QuestionnaireDAO
{

	public QuestionnaireDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	public Questionnaire getById( final String urn, final boolean lock )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Questionnaire> getAll()
	{
		@SuppressWarnings( "unchecked" )
		List<Questionnaire> questionnaires = getHibernateTemplate().find( "from Questionnaire" );

		return questionnaires;
	}

}
