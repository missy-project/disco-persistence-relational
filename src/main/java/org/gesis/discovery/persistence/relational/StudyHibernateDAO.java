package org.gesis.discovery.persistence.relational;

import java.util.List;

import org.gesis.discovery.Study;
import org.gesis.discovery.persistence.StudyDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class StudyHibernateDAO extends GenericHibernateDAO<Study> implements StudyDAO
{

	public StudyHibernateDAO(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	public Study getByName( final String studyName )
	{
		if ( studyName == null )
			return null;

		@SuppressWarnings( "unchecked" )
		List<Study> studies = getHibernateTemplate().find( "FROM Study s WHERE s.title.en = ?", studyName );

		if ( studies == null || studies.size() == 0 )
			return null;

		return studies.get( 0 );
	}

}
