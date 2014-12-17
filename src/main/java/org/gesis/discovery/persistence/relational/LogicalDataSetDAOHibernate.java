package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.LogicalDataSet;
import org.gesis.discovery.persistence.LogicalDataSetDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class LogicalDataSetDAOHibernate extends GenericResourceHibernateDAO<LogicalDataSet> implements LogicalDataSetDAO
{

	public LogicalDataSetDAOHibernate()
	{
		super();
	}

	public LogicalDataSetDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
