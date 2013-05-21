package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.ontology.LogicalDataSet;
import org.gesis.ddi.persistence.dataAccess.LogicalDataSetDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class LogicalDataSetDAOHibernate extends GenericHibernateDAO<LogicalDataSet> implements LogicalDataSetDAO
{

	public LogicalDataSetDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
