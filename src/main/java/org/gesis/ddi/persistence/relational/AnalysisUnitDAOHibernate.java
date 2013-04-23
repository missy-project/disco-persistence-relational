package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.AnalysisUnit;
import org.gesis.ddi.persistence.dataAccess.AnalysisUnitDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class AnalysisUnitDAOHibernate extends GenericHibernateDAO<AnalysisUnit> implements AnalysisUnitDAO
{

	public AnalysisUnitDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<AnalysisUnit> getAll()
	{
		List<AnalysisUnit> analysisUnits = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( analysisUnits == null )
			return Collections.emptyList();

		return analysisUnits;
	}

}
