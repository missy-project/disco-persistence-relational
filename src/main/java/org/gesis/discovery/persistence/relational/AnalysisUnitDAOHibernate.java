package org.gesis.discovery.persistence.relational;

import java.util.List;

import org.gesis.discovery.AnalysisUnit;
import org.gesis.discovery.persistence.AnalysisUnitDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.StringUtils;

/**
 * Hibernate implementation for AnalysisUnit.
 * 
 * @author matthaeus
 * 
 */
public class AnalysisUnitDAOHibernate extends GenericResourceHibernateDAO<AnalysisUnit> implements AnalysisUnitDAO
{

	public AnalysisUnitDAOHibernate()
	{
		super();
	}

	public AnalysisUnitDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	public AnalysisUnit getByNotation( final String notation )
	{
		if ( StringUtils.isEmpty( notation ) )
			return null;

		@SuppressWarnings( "unchecked" )
		List<AnalysisUnit> units = this.getHibernateTemplate().find( "from AnalysisUnit where notation=?", notation );

		if ( units == null || units.size() == 0 )
			return null;

		// there should be only one
		return units.get( 0 );
	}

}
