package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.AnalysisUnit;
import org.gesis.discovery.persistence.AnalysisUnitDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Hibernate implementation for AnalysisUnit.
 * 
 * @author matthaeus
 * 
 */
public class AnalysisUnitDAOHibernate extends GenericHibernateDAO<AnalysisUnit> implements AnalysisUnitDAO
{

	public AnalysisUnitDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
