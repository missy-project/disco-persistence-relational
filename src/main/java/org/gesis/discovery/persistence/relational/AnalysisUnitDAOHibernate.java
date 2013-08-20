package org.gesis.discovery.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.discovery.AnalysisUnit;
import org.gesis.discovery.persistence.AnalysisUnitDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.StringUtils;

/**
 * Hibernate implementation for AnalysisUnit.
 * 
 * @author matthaeus
 * 
 */
public class AnalysisUnitDAOHibernate extends GenericHibernateDAO<AnalysisUnit> implements AnalysisUnitDAO
{

	public AnalysisUnitDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	public List<AnalysisUnit> getByNotation( final String notation )
	{
		if ( StringUtils.isEmpty( notation ) )
			return Collections.emptyList();

		@SuppressWarnings( "unchecked" )
		List<AnalysisUnit> units = this.getHibernateTemplate().find( "from AnalysisUnit where notation=?", notation );

		if ( units == null )
			return Collections.emptyList();

		return units;
	}

}
