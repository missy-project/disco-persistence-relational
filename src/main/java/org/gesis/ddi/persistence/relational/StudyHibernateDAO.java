package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.ontology.Study;
import org.gesis.ddi.persistence.dataAccess.StudyDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class StudyHibernateDAO extends GenericHibernateDAO<Study> implements StudyDAO
{

	public StudyHibernateDAO(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
