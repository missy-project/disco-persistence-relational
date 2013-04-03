package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.Study;
import org.gesis.ddi.persistence.dataAccess.StudyDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class StudyHibernateDAO extends GenericHibernateDAO<Study> implements StudyDAO
{

	public StudyHibernateDAO(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	public Study getById( final String urn, final boolean lock )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Study> getAll()
	{
		@SuppressWarnings( "unchecked" )
		List<Study> studies = getHibernateTemplate().find( "from Study" );

		if ( studies == null )
			Collections.emptyList();

		return studies;
	}

}
