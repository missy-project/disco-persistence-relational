package org.gesis.discovery.persistence.relational;

import java.util.List;

import org.gesis.discovery.Study;
import org.gesis.discovery.persistence.StudyDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.joda.time.DateTime;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class StudyDAOHibernate extends GenericHibernateDAO<Study> implements StudyDAO
{

	public StudyDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	public Study getByTitle( final String studyGroupTitle, final String studyYear )
	{
		if ( studyGroupTitle == null || studyYear == null )
			return null;

		// build query

		StringBuilder query = new StringBuilder();
		query.append( "SELECT s " );
		query.append( "FROM Study s " );
		query.append( "JOIN s.temporal AS t " );
		query.append( "WHERE s.title.en = ? " );
		query.append( "AND t.startDate = ? " );

		DateTime dateTime = DateTime.parse( studyYear );

		// query

		@SuppressWarnings( "unchecked" )
		List<Study> studies = getHibernateTemplate().find( query.toString(), studyGroupTitle, dateTime.toDate() );

		if ( studies == null || studies.size() == 0 )
			return null;

		return studies.get( 0 );
	}

}
