package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.Study;
import org.gesis.discovery.persistence.StudyDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class StudyHibernateDAO extends GenericHibernateDAO<Study> implements StudyDAO
{

	public StudyHibernateDAO(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
