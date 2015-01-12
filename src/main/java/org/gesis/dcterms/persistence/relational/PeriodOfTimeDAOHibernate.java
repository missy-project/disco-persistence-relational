package org.gesis.dcterms.persistence.relational;

import java.util.Date;
import java.util.List;

import org.gesis.dcterms.PeriodOfTime;
import org.gesis.dcterms.persistence.PeriodOfTimeDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class PeriodOfTimeDAOHibernate extends GenericResourceHibernateDAO<PeriodOfTime> implements PeriodOfTimeDAO
{

	public PeriodOfTimeDAOHibernate()
	{
		super();
	}

	public PeriodOfTimeDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	public PeriodOfTime getByStartDate( final Date startDate )
	{
		if ( startDate == null )
			return null;

		String query = new StringBuilder()
		.append( "FROM PeriodOfTime p " )
		.append( "WHERE p.startDate = ?" )
		.toString();

		@SuppressWarnings( "unchecked" )
		List<org.gesis.dcterms.PeriodOfTime> periodOfTimes = getHibernateTemplate().find( query, startDate );

		if ( periodOfTimes == null || periodOfTimes.size() == 0 )
			return null;

		return periodOfTimes.get( 0 );

	}

}