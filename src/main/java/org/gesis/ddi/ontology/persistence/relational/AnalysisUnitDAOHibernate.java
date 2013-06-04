package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.AnalysisUnit;
import org.gesis.ddi.ontology.persistence.AnalysisUnitDAO;
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
