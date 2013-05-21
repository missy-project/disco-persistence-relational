package org.gesis.ddi.persistence.relational;

import org.gesis.dcterms.PeriodOfTime;
import org.gesis.ddi.persistence.dataAccess.PeriodOfTimeDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class PeriodOfTimeDAOHibernate extends GenericHibernateDAO<PeriodOfTime> implements PeriodOfTimeDAO
{

	public PeriodOfTimeDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}