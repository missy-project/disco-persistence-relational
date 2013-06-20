package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.StudyGroup;
import org.gesis.discovery.persistence.StudyGroupDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class StudyGroupDAOHibernate extends GenericHibernateDAO<StudyGroup> implements StudyGroupDAO
{

	public StudyGroupDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
