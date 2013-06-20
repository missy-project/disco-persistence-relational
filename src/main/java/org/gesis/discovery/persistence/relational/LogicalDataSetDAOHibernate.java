package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.LogicalDataSet;
import org.gesis.discovery.persistence.LogicalDataSetDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class LogicalDataSetDAOHibernate extends GenericHibernateDAO<LogicalDataSet> implements LogicalDataSetDAO
{

	public LogicalDataSetDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
