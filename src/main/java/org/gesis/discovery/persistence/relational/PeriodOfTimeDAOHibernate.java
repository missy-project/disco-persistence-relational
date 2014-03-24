package org.gesis.discovery.persistence.relational;

import java.util.Date;

import org.gesis.dcterms.PeriodOfTime;
import org.gesis.discovery.persistence.PeriodOfTimeDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class PeriodOfTimeDAOHibernate extends GenericResourceHibernateDAO<PeriodOfTime> implements PeriodOfTimeDAO
{

	public PeriodOfTimeDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	public PeriodOfTime getByStartDate( final Date date )
	{
		// TODO ZL implement method
		return null;
	}

}