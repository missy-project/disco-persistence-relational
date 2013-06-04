package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.LogicalDataSet;
import org.gesis.ddi.ontology.persistence.LogicalDataSetDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class LogicalDataSetDAOHibernate extends GenericHibernateDAO<LogicalDataSet> implements LogicalDataSetDAO
{

	public LogicalDataSetDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
